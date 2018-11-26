# springmvc总结

## 架构分析

### 三层架构

1. 关于三层架构: 在 JavaEE 开发中，几乎全都是基于 B/S架构的开发。那么在 B/S架构中，系统标准的三层架构 包括：表现层、业务层、持久层。
    * 表现层：  也就是我们常说的web层。它负责接收客户端请求，向客户端响应结果，通常客户端使用http协议请求 web 层，web 需要接收 http 请求，完成 http 响应。  表现层包括**展示层和控制层**：控制层负责接收请求，展示层负责结果的展示。  表现层依赖业务层，接收到客户端请求一般会调用业务层进行业务处理，并将处理结果响应给客户端。  表现层的设计一般都使用 MVC 模型。（MVC 是表现层的设计模型，和其他层没有关系）
    * 业务层：  也就是我们常说的 service 层。它负责业务逻辑处理，和我们开发项目的需求息息相关。web 层依赖业 务层，但是业务层不依赖 web 层。  业务层在业务处理时可能会依赖持久层，如果要对数据持久化需要保证事务一致性。（也就是我们说的， 事务应该放到业务层来控制）
    * 持久层：  也就是我们是常说的 dao 层。负责数据持久化，包括数据层即数据库和数据访问层，数据库是对数据进 行持久化的载体，数据访问层是业务层和持久层交互的接口，业务层需要通过数据访问层将数据持久化到数据库中。通俗的讲，持久层就是和数据库交互，对数据库表进行曾删改查的

### mvc设计模式

1. mvc
    1. 来自菜鸟教程
        * Model（模型） - 模型代表一个存取数据的对象或 JAVA POJO。它也可以带有逻辑，在数据变化时更新控制器。
        * View（视图） - 视图代表模型包含的数据的可视化。
        * Controller（控制器） - 控制器作用于模型和视图上。它控制数据流向模型对象，并在数据变化时更新视图。它使视图与模型分离开。
    1. 来自百度百科
        * MVC 是一种使用 MVC（Model View Controller 模型-视图-控制器）设计创建 Web 应用程序的模式：
            * Model（模型）表示应用程序核心（比如数据库记录列表）。
            * View（视图）显示数据（数据库记录）。
            * Controller（控制器）处理输入（写入数据库记录）。
    1. MVC 全名是 Model View Controller，是模型(model)－视图(view)－控制器(controller)的缩写， 是一种用于设计创建 Web 应用程序表现层的模式。MVC 中每个部分各司其职：  
        * Model（模型）：   通常指的就是我们的数据模型。作用一般情况下用于封装数据。  
        * View（视图）：   通常指的就是我们的 jsp 或者 html。作用一般就是展示数据的。   通常视图是依据模型数据创建的。
        * Controller（控制器）：   是应用程序中处理用户交互的部分。作用一般就是处理程序逻辑的。   它相对于前两个不是很好理解，这里举个例子：   例如：    我们要保存一个用户的信息，该用户信息中包含了姓名，性别，年龄等等。    这时候表单输入要求年龄必须是 1~100 之间的整数。姓名和性别不能为空。并且把数据填充 到模型之中。    此时除了 js 的校验之外，服务器端也应该有数据准确性的校验，那么校验就是控制器的该做 的。    当校验失败后，由控制器负责把错误页面展示给使用者。    如果校验成功，也是控制器负责把数据填充到模型，并且调用业务层实现完整的业务需求。

@import "./img/MVC.png"
@import "./img/framwork.png"

## springMVC

1. SpringMVC 是一种基于 Java 的实现 MVC 设计模型的请求驱动类型的轻量级 Web 框架，属于 Spring       FrameWork 的后续产品，已经融合在 Spring Web Flow 里面。Spring 框架提供了构建 Web 应用程序的全功 能 MVC 模块。使用 Spring 可插入的 MVC 架构，从而在使用 Spring 进行 WEB 开发时，可以选择使用 Spring 的 Spring MVC 框架或集成其他 MVC 开发框架，如 Struts1(现在一般不用)，Struts2 等。 SpringMVC 已经成为目前最主流的 MVC 框架之一，并且随着 Spring3.0 的发布，全面超越 Struts2，成 为最优秀的 MVC 框架。 它通过一套注解，让一个简单的 Java 类成为处理请求的控制器，而无须实现任何接口。同时它还支持 RESTful 编程风格的请求

@import "./img/springmvc执行流程原理.jpg"

1. 优点:3、SpringMVC的优势
    1. 清晰的角色划分：
        * 前端控制器（DispatcherServlet）:用户请求到达前端控制器，它就相当于 mvc 模式中的 c，dispatcherServlet 是整个流程控制的中心，由 它调用其它组件处理用户的请求，dispatcherServlet 的存在降低了组件之间的耦合性。
        * 请求到处理器映射（HandlerMapping）:HandlerMapping 负责根据用户请求找到 Handler 即处理器，SpringMVC 提供了不同的映射器实现不同的 映射方式，例如：配置文件方式，实现接口方式，注解方式等。
        * 处理器适配器（HandlerAdapter）:通过 HandlerAdapter 对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理 器进行执行。
        * 视图解析器（ViewResolver）:View Resolver 负责将处理结果生成 View 视图，View Resolver 首先根据逻辑视图名解析成物理视图名 即具体的页面地址，再生成 View 视图对象，最后对 View 进行渲染将处理结果通过页面展示给用户。
        * 处理器或页面控制器（Controller）:它就是我们开发中要编写的具体业务控制器。由DispatcherServlet 把用户请求转发到 Handler。由 Handler 对具体的用户请求进行处理。
        * 验证器（ Validator）
        * 命令对象（Command 请求参数绑定到的对象就叫命令对象）
        * 表单对象（Form Object 提供给表单展示和提交到的对象就叫表单对象）。
    2. 分工明确，而且扩展点相当灵活，可以很容易扩展，虽然几乎不需要。
    3. 由于命令对象就是一个 POJO，无需继承框架特定 API，可以使用命令对象直接作为业务对象。
    4. 和 Spring 其他框架无缝集成，是其它 Web 框架所不具备的。
    5. 可适配，通过 HandlerAdapter 可以支持任意的类作为处理器。
    6. 可定制性，HandlerMapping. ViewResolver 等能够非常简单的定制。
    7. 功能强大的数据验证. 格式化. 绑定机制。
    8. 利用 Spring 提供的 Mock 对象能够非常简单的进行 Web 层单元测试。
    9. 本地化. 主题的解析的支持，使我们更容易进行国际化和主题的切换。
    10. 强大的 JSP 标签库，使 JSP 编写更容易。
    ………………还有比如RESTful风格的支持、简单的文件上传、约定大于配置的契约式编程支持、基于注解的零配
    置支持等等。
1. 在 SpringMVC 的各个组件中，处理器映射器、处理器适配器、视图解析器称为 SpringMVC 的三大组件。

### SpringMVC 和 Struts2 的优略分析

1. 共同点：
    * 它们都是表现层框架，都是基于 MVC 模型编写的。  
    * 它们的底层都离不开原始 ServletAPI。  
    * 它们处理请求的机制都是一个核心控制器。
2. 区别：
    * Spring MVC 的入口是 Servlet, 而 Struts2 是 Filter   Spring MVC 是基于方法设计的，而 Struts2 是基于类，Struts2 每次执行都会创建一个动作类。所 以 Spring MVC 会稍微比 Struts2 快些。  
    * Spring MVC 使用更加简洁,同时还支持 JSR303, 处理 ajax 的请求更方便  (JSR303 是一套 JavaBean 参数校验的标准，它定义了很多常用的校验注解，我们可以直接将这些注 解加在我们 JavaBean 的属性上面，就可以在需要校验的时候进行校验了。)
    * Struts2 的 OGNL 表达式使页面的开发效率相比 Spring MVC 更高些，但执行效率并没有比 JSTL 提 升，尤其是 struts2 的表单标签，远没有 html 执行效率高。
3. 使用\<mvc:annotation-driven> 自动加载 RequestMappingHandlerMapping （处理映射器）和 RequestMappingHandlerAdapter （ 处 理 适 配 器 ） ， 可 用 在 SpringMVC.xml 配 置 文 件 中 使 用 \<mvc:annotation-driven>替代注解处理器和适配器的配置。

```xml
<!-- 使用上面的配置就相当于配置了下面几个bean -->
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"></bean>
 <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
<!-- HandlerAdapter -->
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerA dapter"></bean>
<bean class="org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter"></bean>
<bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"></bean>
<!-- HadnlerExceptionResolvers -->
<bean class="org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver"></bean>
<bean class="org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolv er"></bean>
<bean class="org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver" ></bean>
```

### spring启动过程-----spring和springMVC父子容器的原理

1. 要想很好理解这三个上下文的关系，需要先熟悉spring是怎样在web容器中启动起来的。spring的启动过程其实就是其IoC容器的启动过程，对于web程序，IoC容器启动过程即是建立上下文的过程。
1. spring的启动过程：
    * 首先，对于一个web应用，其部署在web容器中，web容器提供其一个全局的上下文环境，这个上下文就是*ServletContext*，其为后面的spring IoC容器提供宿主环境；
    * 其次，在web.xml中会提供有contextLoaderListener。在web容器启动时，会触发容器初始化事件，此时contextLoaderListener会监听到这个事件，其contextInitialized方法会被调用，在这个方法中，spring会初始化一个启动上下文，这个上下文被称为根上下文，即*WebApplicationContext*，这是一个接口类，确切的说，其实际的实现类是XmlWebApplicationContext。这个就是spring的IoC容器，其对应的Bean定义的配置由web.xml中的context-param标签指定。在这个IoC容器初始化完毕后，spring以WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE为属性Key，将其存储到ServletContext中，便于获取；
    * 再次，contextLoaderListener监听器初始化完毕后，开始初始化web.xml中配置的Servlet，这个servlet可以配置多个，以最常见的DispatcherServlet为例，这个servlet实际上是一个标准的前端控制器，用以转发、匹配、处理每个servlet请求。*DispatcherServlet上下文*在初始化的时候会建立自己的IoC上下文，用以持有spring mvc相关的bean。在建立DispatcherServlet自己的IoC上下文时，会利用WebApplicationContext.ROOTWEBAPPLICATIONCONTEXTATTRIBUTE先从ServletContext中获取之前的根上下文(即WebApplicationContext)作为自己上下文的parent上下文。有了这个parent上下文之后，再初始化自己持有的上下文。这个DispatcherServlet初始化自己上下文的工作在其initStrategies方法中可以看到，大概的工作就是初始化处理器映射、视图解析等。这个servlet自己持有的上下文默认实现类也是mlWebApplicationContext。初始化完毕后，spring以与servlet的名字相关(此处不是简单的以servlet名为Key，而是通过一些转换，具体可自行查看源码)的属性为属性Key，也将其存到ServletContext中，以便后续使用。这样每个servlet就持有自己的上下文，即拥有自己独立的bean空间，同时各个servlet共享相同的bean，即根上下文(第2步中初始化的上下文)定义的那些bean。
1. 何为父子上下文呢？
    * 父上下文：使用listener监听器来加载配置文件，如下：

```xml
<listener>
  <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```

1. Spring 会创建一个WebApplicationContext上下文，称为父上下文（父容器），保存在 ServletContext中，key是WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE的值。
1. 可以使用Spring提供的工具类取出上下文对象：WebApplicationContextUtils.getWebApplicationContext(ServletContext);
1. 子上下文：
    * 使用Spring MVC 来处理拦截相关的请求时，会配置DispatchServlet：

```xml
<servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet
    </servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/applicationContext-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

1. 每个DispatchServlet会有一个自己的上下文，称为子上下文，它也保存在 ServletContext中，key 是"org.springframework.web.servlet.FrameworkServlet.CONTEXT"+Servlet名称。当一 个Request对象产生时，会把这个子上下文对象（WebApplicationContext）保存在Request对象中，key是 DispatcherServlet.class.getName() + ".CONTEXT"。
1. 可以使用工具类取出上下文对象：RequestContextUtils.getWebApplicationContext(request);
1. 父上下文（父容器）和子上下文（子容器）的访问权限：
1. 子上下文可以访问父上下文中的bean，但是父上下文不可以访问子上下文中的bean。
1. 父上下文使用与否
    * **方案一，传统型：**

    父上下文容器中保存数据源、服务层、DAO层、事务的Bean。  

    子上下文容器中保存Mvc相关的Action的Bean.

    事务控制在服务层。  

    由于父上下文容器不能访问子上下文容器中内容，事务的Bean在父上下文容器中，无法访问子上下文容器中内容，就无法对子上下文容器中Action进行AOP（事务）。  

    当然，做为“传统型”方案，也没有必要这要做。  

    * 方案二，激进型：

    Java世界的“面向接口编程”的思想是正确的，但在增删改查为主业务的系统里，Dao层接口，Dao层实现类，Service层接口，Service层实现类，Action父类，Action。再加上众多的O(vo\po\bo)和jsp页面。写一个小功能 7、8个类就写出来了。 开发者说我就是想接点私活儿，和PHP，ASP抢抢饭碗，但我又是Java程序员。最好的结果是大项目能做好，小项目能做快。所以“激进型”方案就出现了-----没有接口、没有Service层、还可以没有众多的O(vo\po\bo)。那没有Service层事务控制在哪一层？只好上升的Action层。  

    本文不想说这是不是正确的思想，我想说的是Spring不会限制你这样做。  

    由于有了父子上下文，你将无法实现这一目标。解决方案是只使用子上下文容器，不要父上下文容器 。所以数据源、服务层、DAO层、事务的Bean、Action的Bean都放在子上下文容器中。就可以实现了，事务（注解事务）就正常工作了。这样才够激进。  

    总结：不使用listener监听器来加载spring的配置文件，只使用DispatcherServlet来加载spring的配置，不要父子上下文，只使用一个DispatcherServlet，事情就简单了，什么麻烦事儿也没有了。  