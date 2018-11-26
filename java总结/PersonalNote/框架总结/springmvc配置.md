# springmvc中相关的配置问题,以及相关的解析

## 利用Java configuration来配置DispatcherServlet前端控制器

```java
//在spring in action中
package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;
//整个配置类对应的就是web.xml
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  //这个应该是配置的是spring     applicationContext.xml
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  //指定配置类对应springmvc.xml
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  //将DispatcherServlet映射到"/"
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
```

1. 以上是对于上面代码的解析:注释已经说明了很多所以我们直接探讨AbstractAnnotationConfigDispatcherServletInitializer
    * 在Servlet3.0环境中,容器会在类路径中查找实现javax.servlet.ServletContainerInitializer接口的类,如果能发现的话就会用它来配置Servlet容器.
    * Spring提供了这个接口的实现,名为SpringServletContainerInitializer,这个类反过来又会查找实现WebApplicationInitializer的类并将配置的任务交给它们来完成.
    * Spring3.2引入了一个便利的WebApplicationInitializer基础实现,也就是AbstractAnnotationConfigDispatcherServletInitializer.
    * 因为我们的SpittrWebAppInitializer扩展了AbstractAnnotationConfigDispatcherServletInitializer(同时也就实现了WebApplicationInitializer),因此当部署到Servlet3.0容器中的时候,容器会自动发现它,并用它来配置Servlet上下文.
1. 来看一下在Springmvc文档中的配置

```java
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}
```

1. 解析:In addition to using the ServletContext API directly, you can also extend AbstractAnnotationConfigDispatcherServletInitializer and override specific methods (see example under Context Hierarchy).文档中写道注意,也可以用AbstractAnnotationConfigDispacherServletInitializer配置,即第一个配置.

2. 那么我们就来看一下spring的启动过程到底做了什么事情
    * Servlet Context Initialization即ServletContext的初始化
    Embedded servlet containers do not directly execute the Servlet 3.0+ _javax.servlet.ServletContainerInitializer interface_ or Spring’s _org.springframework.web.WebApplicationInitializer interface_. This is an intentional design decision intended to reduce the risk that third party libraries designed to run inside a war may break Spring Boot applications.不直接使用两个接口,这是一个有意为之的设计决策，旨在降低在war中运行的第三方库可能破坏Spring引导应用程序的风险。

    If you need to perform servlet context initialization in a Spring Boot application, you should register a bean that implements the _org.springframework.boot.web.servlet.ServletContextInitializer interface_. The single onStartup method provides access to the ServletContext and, if necessary, can easily be used as an adapter to an existing _WebApplicationInitializer_.那么如果你要驱动Spring启动应用,你应该注册一个beanServletContextInitializer,在单例的onStartup方法中提供一个ServletContext的入口,如果需要,可以很容易的应用一个适配器去适配一个存在的WebApplicationInitializer

    Scanning for Servlets, Filters, and listeners
    When using an embedded container, automatic registration of classes annotated with @WebServlet, @WebFilter, and @WebListener can be enabled by using @ServletComponentScan.

    [Tip]
    @ServletComponentScan has no effect in a standalone container, where the container’s built-in discovery mechanisms are used instead.

## 用xml配置

```xml
<web-app>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/app-context.xml</param-value>
    </context-param>

    <servlet>
        <servlet-name>app</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value></param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>app</servlet-name>
        <url-pattern>/app/*</url-pattern>
    </servlet-mapping>

</web-app>
```

1. 解析:要解释这个xml文件其实很简单,只需要翻看web应用配置即可
    * ServletContext初始化参数:
        * 我们可以用通过\<context-param>添加ServletContext初始化参数,它配置了一个键值对,这样我们可以在应用程序中使用*javax.servet.ServletContext.getInitParamerter()*方法,通过指定的键**获取**参数值,可以控制应用程序的行为.我们可以使用它配置加载文件路径和应用运行状态(开发和测试和生产)以及日志等.
    * servlet声明及映射
        ```xml
        <servlet>
            <servlet-name>myServlet</servlet-name>
            <servlet-class>org.myapp.servlet.MainServlet</servlet-class>
            <init-param>
                <param-name>name</param-name>
                <param-value>value</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
        ```

        * 解释两个:
            * init-param:用于指定Servlet初始化参数,在应用中可以通过*javax.servlet.http.HttpServlet.getInitParameter* **获取**.同时一个Servlet可以添加多个初始化参数.
            * load-on-startup:用于控制在Web应用启动时,Servlet的加载顺序.如果值小于0,在Web应用启动时,将不加载该Servlet
    * 应用声明周期监听器
        * \<listener>用于添加Web应用声明周期监听器,可以同时配置多个.监听器必须实现javax.servlet.ServletContextListener接口.Web应用启动时会调用监听器的contextInitialized()方法,停止时调用其contextDestoryed()方法.启动时,ServletContextListener的执行顺序与web.xml中的配置顺序一致,停止时执行顺序恰好相反.

## 启动DispatcherServlet到底做了什么事情(两个应用上下文之间的故事)

1. 当DispatcherServlet启动的时候,他会创建Springmvc应用上下文,并加载配置文件或配置类中所声明的bean.
2. 但是在Spring Web应用中,通常还会有另外一个应用上下文.另外的这个应用上下文是由ContextLoaderListerner创建的.即根上下文spring的上下文
3. 我们希望DispatcherServlet加载包含Web组件的bean,如控制器和试图解析器以及处理器映射,而ContextLoaderListener要加载应用中的其他bean.这些bean通常是驱动应用后端的中间层和数据层组件.
4. 实际上,AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener.GetServletConfigClasses()方法返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean.getRootConfigClasses()方法返回的带有@Configuration注解的类将会用来配置ContextLoaderListerener创建的应用上下文中的bean.

## 第二阶段主配置

```java
package spittr.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc//启用springMVC
@ComponentScan("spittr.web")//启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    //配置JSP视图解析器
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
  //配置静态资源的处理
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // TODO Auto-generated method stub
    super.addResourceHandlers(registry);
  }
}
```