### Maven高级

#####   maven概念：

​        项目管理工具

​         作用：1.统一进行jar包管理

​                     2.统一开发规范和工具，适合团队协同开发

​         依赖管理：指的就是通过坐标引入jar包

​                  仓库引入顺序： 本地仓库 ---------------远程仓库-------------------中央仓库

```xml
    <groupId>org.mybatis</groupId>    :公司名称 com是盈利组织  org非盈利组织
    <artifactId>mybatis</artifactId>  :项目名
    <version>${mybatis.version}</version>：当前使用的版本
```

​         一键构建

​                   生命周期：

​                     clean生命周期：   清理    mvn  clean

​                     default生命周期：编译

​                     site生命周期：       生成站点文档

​                    常用命令:

​                         compile : 编译 ： 将java文件编译成class文件

​                         test        ：测试： 执行test下的测试案例

​                         package：打包： 将项目达成jar包 或war包

​                         install    ：安装：将项目打包安装到本地仓库

                         deploy   ：部署：将项目打包并上传到私服（远程仓库）

##### SSM整合复习

​      1.创建数据库及items表

​      2.创建了maven web工程  archetypeCatalog  internal

​      3.导入pom.xml

​           直接依赖 ：A项目直接引入B项目的坐标

​           依赖传递（间接依赖）：A项目直接依赖与B项目，B项目直接依赖于C项目，那么A项目间接依赖与C项目

​           依赖版本冲突： （1）第一声明优先       （2）路径近者优先        （3）直接排除 exclusions

```xml
 <properties>
    <spring.version>5.0.2.RELEASE</spring.version>
    <slf4j.version>1.6.6</slf4j.version>
    <log4j.version>1.2.12</log4j.version>
    <shiro.version>1.2.3</shiro.version>
    <mysql.version>5.1.6</mysql.version>
    <mybatis.version>3.4.5</mybatis.version>
    <spring.security.version>5.0.1.RELEASE</spring.security.version>
  </properties>

  <!-- 锁定jar包版本 -->
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>${mybatis.version}</version>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <!-- 项目依赖jar包 -->
  <dependencies>
    <!-- spring -->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.6.8</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-orm</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>${mysql.version}</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <!-- log start -->
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>${log4j.version}</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>${slf4j.version}</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>${slf4j.version}</version>
    </dependency>
    <!-- log end -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version}</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.0</version>
    </dependency>
    <dependency>
      <groupId>c3p0</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.1.2</version>
      <type>jar</type>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>5.1.2</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-web</artifactId>
      <version>${spring.security.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-config</artifactId>
      <version>${spring.security.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-core</artifactId>
      <version>${spring.security.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-taglibs</artifactId>
      <version>${spring.security.version}</version>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.0.9</version>
    </dependency>
  </dependencies>
  <!-- 添加tomcat7插件 -->
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
      </plugin>
    </plugins>
  </build>
```

​       4.编写Dao

​            创建实体类items、创建itemsDao接口

```java
public interface ItemsDao {
    @Select("select * from items where id = #{id}")
    public Items findById(Integer id);
}
```

​            创建applicationContext.xml ，进行mybatis的配置

​               （1） 数据源            （2）sqlSessionFactory           (3) mapper映射扫描

```xml
 <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql:///maven"/>
        <property name="user" value="root"/>
        <property name="password" value="root"/>
    </bean>

    <!--创建一个生产SqlSeesion对象的工厂对象-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--引入数据源-->
        <property name="dataSource" ref="dataSource"/>
        <!--给pojo对象起别名【此处注解开发可以省略】-->
        <property name="typeAliasesPackage" value="com.itheima.domain"/>
    </bean>

    <!--我们对所有dao接口包下的接口进行扫描，使用SqlSeesion对象给其创建代理对象，并且放入到容器中-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.itheima.dao"/>
    </bean>
```

​        测试：

```java
    @Test
    public void daoTest(){
        //得到spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring容器中得到所需dao接口的代理对象
        ItemsDao itemsDao = applicationContext.getBean(ItemsDao.class);
        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());
    }
```

​     5.编写service

​           创建service的接口及实现类

​           实现类上加@Service: 创建service的实例对象并存到IOC容器中

​           实现类上加@Transtional: 在service层进行事务管理

​           编写applicationContext.xml中service部分：（1）IOC注解扫描    （2）事务管理器      （3）事务注解扫描

```java
@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;
    @Override
    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }
}
```

```xml
   <!--service层配置开始-->

    <!--组建扫描-->
    <context:component-scan base-package="com.itheima.service"/>

    <!--配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!--注入连接池-->
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--开启事务注解的支持-->
    <tx:annotation-driven/>
```

​    测试

```java
    @Test
    public void serviceTest(){
        //得到spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring容器中得到所需dao接口的代理对象
        ItemsService itemsService = applicationContext.getBean(ItemsService.class);
        //调用方法
        Items items = itemsService.findById(1);
        System.out.println(items.getName());
    }
```

​       6.编写web层步骤：

​          创建controller类，类上@Controller：生成实例对象放到springmvc的IOC容器中，方法上

​         @RequestMapping注解：用于设置映射路径

​         编写web.xml:  (1)前端控制器       （2）中文乱码过滤器       （3）spring的监听器

​        编写springmvc.xml: （1）IOC注解扫描 （2）视图解析器（3）开启springmvc注解支持 （4） 静态资源放行

​        测试

controller类：

```java
@Controller
@RequestMapping("/itmes")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/showDetail")
    public String showDetail(Model model){
        Items items = itemsService.findById(1);
        model.addAttribute("item", items);
        return "itemDetail";
    }
}
```

web.xml

```xml
  <!--中文乱码过滤器-->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!--前端控制器-->
  <servlet>
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>

  <!--spring核心监听器-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>

```

springmvc.xml

```xml
   <!--组建扫描-->
    <context:component-scan base-package="com.itheima.controller"/>

    <!--开启springmvc注解支持-->
    <mvc:annotation-driven/>

    <!--视图解析器-->
    <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/pages/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <!--释放静态资源-->
    <mvc:default-servlet-handler/>
```



##### 使用聚合工程完成SSM整合

​    1.创建maven 父工程  打包方式 pom

    2.创建maven子工程 maven_dao   jar    maven_service  jar      maven_web    war

​    3.复制代码到父子工程中，并让子工程产生依赖关系

​    4.测试：启动方式3种

​                                          1.选中父工程   tomcat7:run  

​                                          2.使用本地tomcat，添加项目启动         项目依赖：本地仓库中可以没有当前项目的jar包

​                                          3.选中maven_web工程 tomcat7:run    jar包依赖：依赖本地仓库中的jar包



##### 私服的安装与使用（了解）

​     1.安装私服: 解压nexus打目录下，进入到bin目录下，执行nexus.bat install   nexus.bat  start 

        访问地址：http://localhost:8081/nexus

​     2.私服的仓库类型： hosted:宿主仓库：上传自己的jar包   分为releases:发行版        snapshots:测试版

​                                        proxy：代理仓库，用于代理远程的公共仓库  如maven中央仓库

​     3.   项目上传到私服（资料中查看PDF）

           项目下载到私服（资料中查看PDF）













