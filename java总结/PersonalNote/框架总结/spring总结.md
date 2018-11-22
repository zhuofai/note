# spring总结

## 快速入门

### Ioc(inverse of control)

1. 获取spring的Ioc核心容器，并根据id获取对象
    * ApplicationContext的三个常用实现类：
        * ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
        * FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
        * AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
2. 核心容器的两个接口引发出的问题：
    * ApplicationContext:单例对象适用采用此接口 它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
    * BeanFactory:            多例对象使用
        它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。

### spring对bean的管理

1. 把对象的创建交给spring来管理
    * spring对bean的管理细节
        * 创建bean的三种方式
        * bean对象的作用范围
        * bean对象的生命周期
2. 创建Bean的三种方式
    * 第一种方式：使用默认构造函数创建。
            * 在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
            * 采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。

    ```xml
    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"></bean>
    ```

    * 第二种方式： 使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）

    ```xml
    <bean id="instanceFactory" class="com.itheima.factory.InstanceFactory"></bean>
    <bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
    ```

    * 第三种方式：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器)

    ```xml
    <bean id="accountService" class="com.itheima.factory.StaticFactory" factory-method="getAccountService"></bean>
    ```

3. bean的作用范围调整
        bean标签的scope属性：
            作用：用于指定bean的作用范围
            取值： 常用的就是单例的和多例的
                singleton：单例的（默认值）
                prototype：多例的
                request：作用于web应用的请求范围
                session：作用于web应用的会话范围
                global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时，它就是session

    ```xml
        <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl" scope="prototype"></bean>
    ```

4. bean对象的生命周期
    * 单例对象
        * 出生：当容器创建时对象出生
        * 活着：只要容器还在，对象一直活着
        * 死亡：容器销毁，对象消亡
        * 总结：单例对象的生命周期和容器相同
    * 多例对象
        * 出生：当我们使用对象时spring框架为我们创建
        * 活着：对象只要是在使用过程中就一直活着。
        * 死亡：当对象长时间不用，且没有别的对象引用时，由Java的垃圾回收器回收

### 依赖注入

1. spring中的依赖注入
    * 依赖注入：Dependency Injection
    * IOC的作用：降低程序间的耦合（依赖关系）
    * 依赖关系的管理：以后都交给spring来维护
2. 在当前类需要用到其他类的对象，由spring为我们提供，我们只需要在配置文件中说明.依赖关系的维护：就称之为依赖注入。
3. 依赖注入：
    能注入的数据：有三类
    基本类型和String
    其他bean类型（在配置文件中或者注解配置过的bean）
    复杂类型/集合类型
4. 注入的方式：有三种
    * 第一种：使用构造函数提供
    * 第二种：使用set方法提供
    * 第三种：使用注解提供（明天的内容）
5. 构造函数注入：
    * 使用的标签:constructor-arg
    * 标签出现的位置：bean标签的内部
    * 标签中的属性
        * type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型
        * index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始
        * name：用于指定给构造函数中指定名称的参数赋值                                        常用的
        =============以上三个用于指定给构造函数中哪个参数赋值===============================
        * value：用于提供基本类型和String类型的数据
        * ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象
    * 优势：
        在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
    * 弊端：
        改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供。
6. set方法注入                更常用的方式
    * 涉及的标签：property
    * 出现的位置：bean标签的内部
    * 标签的属性
        * name：用于指定注入时所调用的set方法名称
        * value：用于提供基本类型和String类型的数据
        * ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象
    * 优势：
        创建对象时没有明确的限制，可以直接使用默认构造函数
    * 弊端：
        如果有某个成员必须有值，则获取对象是有可能set方法没有执行。

### 注解开发

1. 账户的业务层实现类 曾经XML的配置：

    ```xml
    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
            scope=""  init-method="" destroy-method="">
        <property name=""  value="" | ref=""></property>
    </bean>
    ```

2. 用于创建对象的   他们的作用就和在XML配置文件中编写一个\<bean>标签实现的功能是一样的
    * Component:
        * 作用：用于把当前类对象存入spring容器中
        * 属性：value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写。
    * Controller：一般用在表现层
    * Service：一般用在业务层
    * Repository：一般用在持久层
    >以上三个注解他们的作用和属性与Component是一模一样。他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
3. 用于注入数据的 他们的作用就和在xml配置文件中的bean标签中写一个\ \<property>标签的作用是一样的
    * Autowired:
        * 作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
        * 如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
        * 如果Ioc容器中有多个类型匹配时:
            * 出现位置：
                可以是变量上，也可以是方法上
            * 细节：
                在使用注解注入时，set方法就不是必须的了。
    * Qualifier:
        * 作用：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以（稍后我们讲）
        * 属性：
            * value：用于指定注入bean的id。
    * Resource
        * 作用：直接按照bean的id注入。它可以独立使用
        * 属性：
        * name：用于指定bean的id。
    * 以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
    另外，集合类型的注入只能通过XML来实现。
    * Value
    * 作用：用于注入基本类型和String类型的数据
    * 属性：
        * value：用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式）SpEL的写法：{表达式 }
4. 用于改变作用范围的他们的作用就和在bean标签中使用scope属性实现的功能是一样的
    * Scope
    * 作用：用于指定bean的作用范围
    * 属性：
        * value：指定范围的取值。常用取值：singleton prototype
5. 和生命周期相关 了解他们的作用就和在bean标签中使用init-method和destroy-methode的作用是一样的
    * PreDestroy
        作用：用于指定销毁方法
    * PostConstruct
        作用：用于指定初始化方法
6. spring中的新注解
    * Configuration
    * 作用：指定当前类是一个配置类
        * 细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
    * ComponentScan
        * 作用：用于通过注解指定spring在创建容器时要扫描的包
        * 属性：
        * value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
        * 我们使用此注解就等同于在xml中配置了:
        * \\<context:component-scan base-package="com.itheima"></context:component-scan>
    * Bean
        * 作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
        * 属性:name:用于指定bean的id。当不写时，默认值是当前方法的名称
        * 细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
        * 查找的方式和Autowired注解的作用是一样的
    * Import
        * 作用：用于导入其他的配置类
        * 属性：
        * value：用于指定其他配置类的字节码。
        * 当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
    * PropertySource
        * 作用：用于指定properties文件的位置
        * 属性：
        * value：指定文件的名称和路径。
        * 关键字：classpath，表示类路径下

### spring中基于XML的AOP配置步骤

1. 把通知Bean也交给spring来管理
2. 使用aop:config标签表明开始AOP的配置
3. 使用aop:aspect标签表明配置切面
    * id属性：是给切面提供一个唯一标识
    * ref属性：是指定通知类bean的Id。
4. 在aop:aspect标签的内部使用对应标签来配置通知的类型
    * 我们现在示例是让printLog方法在切入点方法执行之前之前：所以是前置通知
    * aop:before：表示配置前置通知
        * method属性：用于指定Logger类中哪个方法是前置通知
        * pointcut属性：用于指定切入点表达式，该表达式的含义指的是对业务层中哪些方法增强
5. 切入点表达式的写法：
    * 关键字：execution(表达式)
    * 表达式：访问修饰符  返回值  包名.包名.包名...类名.方法名(参数列表)
    * 标准的表达式写法：public void com.itheima.service.impl.AccountServiceImpl.saveAccount()
    * 访问修饰符可以省略void com.itheima.service.impl.AccountServiceImpl.saveAccount()
    * 返回值可以使用通配符，表示任意返回* com.itheima.service.impl.AccountServiceImpl.saveAccount()
    * 包名可以使用通配符，表示任意包。但是有几级包，就需要写几个*.* \*.\*.\*.*.AccountServiceImpl.saveAccount())
    * 包名可以使用..表示当前包及其子包
        * *..AccountServiceImpl.saveAccount()
    * 类名和方法名都可以使用*来实现通配
        \* \*..\*.*()
    * 参数列表：
        可以直接写数据类型：
            基本类型直接写名称           int
            引用类型写包名.类名的方式   java.lang.String
        可以使用通配符表示任意类型，但是必须有参数
        可以使用..表示有无参数均可，有参数可以是任意类型
    全通配写法：
        * \*..\*.*(..)

    实际开发中切入点表达式的通常写法：
        切到业务层实现类下的所有方法
            * com.itheima.service.impl.\*.*(..)

## spring开发实战

1. spring采取4种关键策略:
    * 基于POJO的轻量级和最小侵入性编程;
    * 通过依赖注入和面向接口实现松耦合
    * 基于切面和惯例进行声明式编程.
    * 通过切面和模版减少样板式代码.
2. 一些术语补充
    * 创建应用组件之间协作行为通常称为装配(wiring)
3. DI能够让相互写作的组件保持松散耦合,而面向切面编程(aspect-oriented programming,AOP)允许你把遍布应用各处的功能分离出来形成可重用的组件.

### 依赖注入DI(Dependency Injection)

1. 通过ID,对象的依赖关系将由系统中负责协调各对象的第三方组件在创建对象的时候进行设定.对象无需自行创建或管理它们的依赖关系,依赖关系将被自动注入到需要它们的对象中去.
2. spring通过应用上下文(Application Context)装载bean的定义并把他们组装起来.spring应用上下文全权负责对象的创建和组装.

### 面向切面编程 AOP(Aspect-Oriented Programming)

1. 导引:面向切面编程往往被定义为促使软件系统**实现关注点的分离**的一项技术.那么系统每一个组件各负责一块特定功能.除了实现自身核心的功能之外,这些组件还经常承担着额外的职责.诸如日志 事务管理和安全这样的系统服务经常融入到自身具有核心业务逻辑的组件中去,这些系统服务通常被称为横切关注点.因为它们会跨越系统的多个组件.
2. 面临的问题
    * 实现系统关注点功能的代码将会重复出现在多个组件中.这意味这如果你要该变这些关注点的逻辑,必须修改各个模块中的相关实现.即使你把这些关注点抽象为一个独立的模块,其他模块只是调用它的方法,但方法的调用还是会重复出现在各个模块中.
    * 组件会因为那些与自身核心业务无关的代码而变得混乱.一个向地址簿增加地址条目的方法应该只关注如何添加地址,而不应该关注它是不是安全的,或者是否需要支持事务.

### Bean

1. 基于spring的应用中,你的应用对象生存于spring容器(container)中.容器负责创建对象,装配它们,配置它们并管理它们的整个生命周期,从生存到死亡.
2. spring自带了多个容器实现,可以归为两种不同的类型.**bean工厂**(由org.springframework.beans.factory.eanFactory接口定义,一般不用太低级)是最简单的容器,提供基本的DI支持.**应用上下文**(由org.springframework.context.ApplicationContext接口定义)基于BeanFactory构建,并提供应用框架级别的服务.
3. 不同的应用上下文将bean加载到bean工厂的过程都是相似的.

### spring概览

@import "./img/spring-overview.png"

1. spring核心容器
    * 容器是Spring框架最核心的部分,他管理者Spring应用中bean的创建 配置和管理.在该模块中,包括了Spring bean工厂,它为Spring提供了DI的功能.
    * 所有的Spring模块都构建与核心容器之上.
2. Spring的AOP模块
    * 在AOP模块中,Spring对面向切面编程提供了丰富的支持.
    * 与DI以牙膏AOP可以帮助应用对象解耦
3. 数据访问与集成.
    * Spring的JDBC和DAO(Data Access Object)模块抽象了样板式代码.
    * 对于更喜欢使用ORM(Object-Relational Mapping)工具而不愿意直接使用JDBC的开发者,Spring提供了ORM模块.
    * 除此之外本模块会使用SpringAOP模块为Spring应用中的对象提供事务管理服务.
4. Web与远程调用
    * MVC(Model-View-Controller)模式是一种普遍被接受的构建Web应用的方法.
    * 他的Web和远程调用模块自带了一个强大的MVC框架,有助于在Web层提升应用的松耦合水平.
    * 除了面向用户的Web应用,该模块还提供了多种构建与其他应用交互的远程调用方案.Spring远程调用功能继承了RMI(Remote Method Invocation) Hessian Burlap JAX-WS,同时Spring还自带了一个远程调用框架:Http invoker.
5. Instrumentation
    * 该模块提供了为JVM添加代理(agent)的功能.具体来讲它为Tomcat提供了一个织入代理,能够为Tomcat传递类文件,就像这些文件是被类加载器加载的一样.(补偿用)
6. 测试
    * spring为使用JNDI Servlet和Portlet编写单元测试提供了一些列的mock对象实现.
    * 对于继承测试,该模块加载Spring应用上下文中的bean集合以及与Spring上下文中的bean进行交互提供了支持.

## 学习中遇到的问题及解决

1. spring已经实现了aop，为什么还要用aspectj?
    * spring有自己的AOP实现与aspectj的实现不同比较麻烦，马士兵的教程所讲的是spring整合了aspectj的AOP马士兵没有将spring自己的aop，在视频的末尾他说一般情况用不到spring自己的AOP你可以仔细听听，spring在做声明式事物处理时就没有用aspectj嘛！springAOP是设计用于在应用服务器环境下实现AOP，切入点与方面均由普通Java对象实现，其中连接点模型与AspectJ相同，只是远不如AspectJ丰富。针对你的问题spring有两组AOP一组是spring本身的一组是整合AspectJ，就好比在国际上一个中国人说英语是因为大家都说英语（好比AspectJ），但中国人还有自己的语言中文（spring自己的AOP）
    * 根据我看spring官方文档的理解
        1. 选择spring的AOP还是AspectJ?
        spring确实有自己的AOP。功能已经基本够用了，除非你的要在接口上动态代理或者方法拦截精确到getter和setter。这些都是写奇葩的需求，一般不使用。
        2. 在使用AOP的时候，你是用xml还是注解的方式（@Aspect）？
        1）如果使用xml方式，不需要任何额外的jar包。
        2）如果使用@Aspect方式，你就可以在类上直接一个@Aspect就搞定，不用费事在xml里配了。但是这需要额外的jar包（ aspectjweaver.jar）。因为spring直接使用AspectJ的注解功能，注意只是使用了它 的注解功能而已。并不是核心功能 ！！！
        3. 注意到文档上还有一句很有意思的话：文档说到 是选择spring AOP还是使用full aspectJ？
        什么是full aspectJ？如果你使用"full aspectJ"。就是说你可以实现基于接口的动态代理，等等强大的功能。而不仅仅是aspectj的 注-解-功-能 ！！！
        4. 如果用full AspectJ。比如说Load-Time Weaving的方式 还 需要额外的jar包 spring-instrument.jar
        当然，无论是使用spring aop还是 aspectj都需要aspectjweaver.jar spring-aop.jar这两个jar包。

## Spring Core文档

### IOC容器

1. Foremost amongst these is the Spring Framework’s Inversion of Control (IoC) container. (在这些模块中最重要的是IOC容器)
2. IOC的由来: It is a process whereby objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes, or a mechanism such as the Service Locator pattern.
3. The _org.springframework.beans_ and _org.springframework.context packages_ are the basis for Spring Framework’s IoC container.
4. bean:In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans.
