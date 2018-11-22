# mybatis总结

## 框架概述

1. 框架（Framework）是整个或部分系统的可重用设计，表现为一组抽象构件及构件实例间交互的方法;另一种 定义认为，框架是可被应用开发者定制的应用骨架。前者是从应用方面而后者是从目的方面给出的定义。  简而言之，框架其实就是某种应用的半成品，就是一组组件，供你选用完成你自己的系统。简单说就是使用别 人搭好的舞台，你来做表演。而且，框架一般是成熟的，不断升级的软件。
2. 框架要解决的问题
    * 框架要解决的最重要的一个问题是技术整合的问题，在 J2EE 的 框架中，有着各种各样的技术，不同的 软件企业需要从 J2EE 中选择不同的技术，这就使得软件企业最终的应用依赖于这些技术，技术自身的复杂性和技 术的风险性将会直接对应用造成冲击。而应用是软件企业的核心，是竞争力的关键所在，因此应该将应用自身的设计和具体的实现技术解耦。这样，软件企业的研发将集中在应用的设计上，而不是具体的技术实现，技术实现是应 用的底层支撑，它不应该直接对应用产生影响。
3. 框架一般处在低层应用平台（如 J2EE）和高层业务逻辑之间的中间层。

## 入门

1. 什么是 MyBatis ？
    >MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集.MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。(ORM[Object Relational Mapping]对象关系映射)采用 ORM 思想解决了实体和数据库映射的问题，对 jdbc进行了封装，屏蔽了 jdbc api 底层访问细节，使我 们不用与 jdbc api 打交道，就可以完成对数据库的持久化操作。
2. 如何使用:
    * 使用首先构建依赖
        ```xml
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>x.x.x</version>
        </dependency>
        ```
    * 从 XML 中构建 SqlSessionFactory
    * 从 SqlSessionFactory 中获取 SqlSession
3. 几个概念:
    * 命名空间（Namespaces）在之前版本的 MyBatis 中是可选的，这样容易引起混淆因此毫无益处。现在命名空间则是必须的，且意于简单地用更长的完全限定名来隔离语句。
    * 命名解析：为了减少输入量，MyBatis 对所有的命名配置元素（包括语句，结果映射，缓存等）使用了如下的命名解析规则。
    完全限定名（比如“com.mypackage.MyMapper.selectAllThings”）将被直接查找并且找到即用。
    短名称（比如“selectAllThings”）如果全局唯一也可以作为一个单独的引用。
4. 作用域（Scope）和生命周期
    * 提示:对象生命周期和依赖注入框架 依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器（mapper）并将它们直接注入到你的 bean 中，因此可以直接忽略它们的生命周期。
    * SqlSessionFactoryBuilder:这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）。
    * SqlSessionFactory:一旦被创建就应该在应用的运行期间一直存在，没有任何理由对它进行清除或重建。使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。因此 SqlSessionFactory 的最佳作用域是应用作用域。有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。
    * SqlSession:每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。也绝不能将 SqlSession 实例的引用放在任何类型的管理作用域中,也就是在web项目中每次完成一个请求就立刻关闭它
        ```java
        SqlSession session = sqlSessionFactory.openSession();
        try {
        // do work
        } finally {
        session.close();
        }
        ```
    * 映射器实例（Mapper Instances）:映射器是一个你创建来绑定你映射的语句的接口。映射器接口的实例是从 SqlSession 中获得的。因此从技术层面讲，任何映射器实例的最大作用域是和请求它们的 SqlSession 相同的。尽管如此，映射器实例的最佳作用域是方法作用域。也就是说，映射器实例应该在调用它们的方法中被请求，用过之后即可废弃。并不需要显式地关闭映射器实例
        ```java
        SqlSession session = sqlSessionFactory.openSession();
        try {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        // do work
        } finally {
        session.close();
        }
        ```

## XML映射配置文件

1. 文档的顶层结构configuration 配置
    * configuration 配置
    * properties 属性
    * settings 设置
    * typeAliases 类型别名
    * typeHandlers 类型处理器
    * objectFactory 对象工厂
    * plugins 插件
    * environments 环境
        * environment 环境变量
            * transactionManager 事务管理器
            * dataSource 数据源
    * databaseIdProvider 数据库厂商标识
    * mappers 映射器

### properties属性

1. 这些属性都是可外部配置且可动态替换的，既可以在典型的 Java 属性文件中配置，亦可通过 properties 元素的子元素来传递。然后其中的属性就可以在整个配置文件中被用来替换需要动态配置的属性值。(一般是引入数据库信息的properties文件,然后再配置中替换)
2. 加载顺序:
    * 在 properties 元素体内指定的属性首先被读取。
    * 然后根据 properties 元素中的 resource 属性读取类路径下属性文件或根据 url 属性指定的路径读取属性文件，并覆盖已读取的同名属性。
    * 最后读取作为方法参数传递的属性，并覆盖已读取的同名属性。

### Settings属性

1. 这是 MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为。下表描述了设置中各项的意图、默认值等。
2. 几个常用的参数设置:
    * cacheEnabled:全局地开启或关闭配置文件中的所有映射器已经配置的任何缓存。默认值为true
    * lazyLoadingEnabled:延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置fetchType属性来覆盖该项的开关状态。默认值false
    * aggressiveLazyLoading:当开启时，任何方法的调用都会加载该对象的所有属性。否则，每个属性会按需加载（参考lazyLoadTriggerMethods).默认值false

### typeAliases属性

1. 类型别名是为 Java 类型设置一个短的名字。它只和 XML 配置有关，存在的意义仅在于用来减少类完全限定名的冗余。
2. 常用方式是配置packet

```xml
<typeAliases>
  <package name="domain.blog"/>
</typeAliases>
```

1. 每一个在包 domain.blog 中的 Java Bean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。注解书写为(@Alias("author"))

### typeHandlers

1. 无论是 MyBatis 在预处理语句（PreparedStatement）中设置一个参数时，还是从结果集中取出一个值时， 都会用类型处理器将获取的值以合适的方式转换成 Java 类型。下表描述了一些默认的类型处理器。
2. 你可以重写类型处理器或创建你自己的类型处理器来处理不支持的或非标准的类型。 具体做法为：实现 org.apache.ibatis.type.TypeHandler 接口， 或继承一个很便利的类 org.apache.ibatis.type.BaseTypeHandler， 然后可以选择性地将它映射到一个 JDBC 类型。

### 对象工厂（objectFactory）

1. MyBatis 每次创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成。 默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认构造方法，要么在参数映射存在的时候通过参数构造方法来实例化。 如果想覆盖对象工厂的默认行为，则可以通过创建自己的对象工厂来实现。

### 插件（plugins）

1. MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
    * Executor (update, query, flushStatements, commit, rollback, getTransaction,close, isClosed)
    * ParameterHandler (getParameterObject, setParameters)
    * ResultSetHandler (handleResultSets, handleOutputParameters)
    * StatementHandler (prepare, parameterize, batch, update, query)
2. 也就是说在我们执行一些sql语句的执行的时候,都会交给底层的mybatis的Executor ParameterHandler ResultSetHandler StatementHandler负责执行底层映射语句的内部对象

### 配置环境（environments）

1. MyBatis 可以配置成适应多种环境，这种机制有助于将 SQL 映射应用于多种数据库之中， 现实情况下有多种理由需要这么做。
2. 不过要记住：尽管可以配置多个环境，每个 SqlSessionFactory 实例只能选择其一。
3. 如果你想连接两个数据库，就需要创建两个 SqlSessionFactory 实例，每个数据库对应一个。而如果是三个数据库，就需要三个实例，依此类推，记起来很简单：
4. 每个数据库对应一个 SqlSessionFactory 实例

```xml
<environments default="development">
  <environment id="development">
    <transactionManager type="JDBC">
        <property name="..." value="..."/>
    </transactionManager>
    <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
      <property name="password" value="${password}"/>
    </dataSource>
  </environment>
</environments>
```

1. 注意这里的关键点:
    * 默认的环境 ID（比如:default="development"）。
    * 每个 environment 元素定义的环境 ID（比如:id="development"）。
    * 事务管理器的配置（比如:type="JDBC"）。
    * 数据源的配置（比如:type="POOLED"）。
2. 事务管理器（transactionManager）:在 MyBatis 中有两种类型的事务管理器（也就是 type=”[JDBC|MANAGED]”）：
    * JDBC – 这个配置就是直接使用了 JDBC 的提交和回滚设置，它依赖于从数据源得到的连接来管理事务作用域。
    * MANAGED – 这个配置几乎没做什么。它从来不提交或回滚一个连接，而是让容器来管理事务的整个生命周期（比如 JEE 应用服务器的上下文）。 默认情况下它会关闭连接，然而一些容器并不希望这样，因此需要将 closeConnection 属性设置为 false 来阻止它默认的关闭行为。
3. 如果你正在使用 Spring + MyBatis，则没有必要配置事务管理器， 因为 Spring 模块会使用自带的管理器来覆盖前面的配置。

### 数据源（dataSource）

1. dataSource 元素使用标准的 JDBC 数据源接口来配置 JDBC 连接对象的资源。
2. 有三种内建的数据源类型（也就是 type=”[UNPOOLED|POOLED|JNDI]”）：
    * UNPOOLED– 这个数据源的实现只是每次被请求时打开和关闭连接。虽然有点慢，但对于在数据库连接可用性方面没有太高要求的简单应用程序来说，是一个很好的选择。
    * POOLED– 这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来，避免了创建新的连接实例时所必需的初始化和认证时间。 这是一种使得并发 Web 应用快速响应请求的流行处理方式。(配置属性有很多)
    * JNDI – 这个数据源的实现是为了能在如 EJB 或应用服务器这类容器中使用，容器可以集中或在外部配置数据源，然后放置一个 JNDI 上下文的引用。这种数据源配置只需要两个属性：

### databaseIdProvider

1. MyBatis 可以根据不同的数据库厂商执行不同的语句，这种多厂商的支持是基于映射语句中的 databaseId 属性。

### 映射器（mappers）

1. 既然 MyBatis 的行为已经由上述元素配置完了，我们现在就要定义 SQL 映射语句了。但是首先我们需要告诉 MyBatis 到哪里去找到这些语句。 Java 在自动查找这方面没有提供一个很好的方法，所以最佳的方式是告诉 MyBatis 到哪里去找映射文件。
2. 三种配置方式:其中最常用的是使用packet方法配置,此时我们需要注意的就是映射文件与类同包同名才行.

```xml
<!-- 使用相对于类路径的资源引用 -->
<mappers>
  <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
  <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
  <mapper resource="org/mybatis/builder/PostMapper.xml"/>
</mappers>
```

```xml
<!-- 使用完全限定资源定位符（URL） -->
<mappers>
  <mapper url="file:///var/mappers/AuthorMapper.xml"/>
  <mapper url="file:///var/mappers/BlogMapper.xml"/>
  <mapper url="file:///var/mappers/PostMapper.xml"/>
</mappers>
```

```xml
<!-- 使用映射器接口实现类的完全限定类名 -->
<mappers>
  <mapper class="org.mybatis.builder.AuthorMapper"/>
  <mapper class="org.mybatis.builder.BlogMapper"/>
  <mapper class="org.mybatis.builder.PostMapper"/>
</mappers>
```

```xml
<!-- 将包内的映射器接口实现全部注册为映射器 -->
<mappers>
  <package name="org.mybatis.builder"/>
</mappers>
```

## Mapper XML 文件

1. SQL 映射文件有很少的几个顶级元素（按照它们应该被定义的顺序）：
    * cache – 给定命名空间的缓存配置。
    * cache-ref – 其他命名空间缓存配置的引用。
    * resultMap – 是最复杂也是最强大的元素，用来描述如何从数据库结果集中来加载对象。
    * parameterMap – 已废弃！老式风格的参数映射。内联参数是首选,这个元素可能在将来被移除，这里不会记录。
    * sql – 可被其他语句引用的可重用语句块。
    * insert – 映射插入语句
    * update – 映射更新语句
    * delete – 映射删除语句
    * select – 映射查询语句

### select

1. 查询语句是 MyBatis 中最常用的元素之一，光能把数据存到数据库中价值并不大，如果还能重新取出来才有用，多数应用也都是查询比修改要频繁。对每个插入、更新或删除操作，通常对应多个查询操作。这是 MyBatis 的基本原则之一，也是将焦点和努力放到查询和结果映射的原因。

```m
<select id="selectPerson" parameterType="int" resultType="hashmap">
  SELECT * FROM PERSON WHERE ID = #{id}
</select>
```

```m
<select
  id="selectPerson"
  parameterType="int"
  parameterMap="deprecated"
  resultType="hashmap"
  resultMap="personResultMap"
  flushCache="false"
  useCache="true"
  timeout="10000"
  fetchSize="256"
  statementType="PREPARED"
  resultSetType="FORWARD_ONLY">
```

### insert, update 和 delete

```m
<insert id="insertAuthor">
  insert into Author (id,username,password,email,bio)
  values (#{id},#{username},#{password},#{email},#{bio})
</insert>

<update id="updateAuthor">
  update Author set
    username = #{username},
    password = #{password},
    email = #{email},
    bio = #{bio}
  where id = #{id}
</update>

<delete id="deleteAuthor">
  delete from Author where id = #{id}
</delete>
```

### sql

1. 这个元素可以被用来定义可重用的 SQL 代码段，可以包含在其他语句中。它可以被静态地(在加载参数) 参数化. 不同的属性值通过包含的实例变化.

### Result Maps

1. resultMap 元素是 MyBatis 中最重要最强大的元素。它可以让你从 90% 的 JDBC ResultSets 数据提取代码中解放出来, 并在一些情形下允许你做一些 JDBC 不支持的事情。 实际上，在对复杂语句进行联合映射的时候，它很可能可以代替数千行的同等功能的代码。 ResultMap 的设计思想是，简单的语句不需要明确的结果映射，而复杂一点的语句只需要描述它们的关系就行了。

resultMap
constructor - 用于在实例化类时，注入结果到构造方法中
idArg - ID 参数;标记出作为 ID 的结果可以帮助提高整体性能
arg - 将被注入到构造方法的一个普通结果
id – 一个 ID 结果;标记出作为 ID 的结果可以帮助提高整体性能
result – 注入到字段或 JavaBean 属性的普通结果
association – 一个复杂类型的关联;许多结果将包装成这种类型
嵌套结果映射 – 关联可以指定为一个 resultMap 元素，或者引用一个
collection – 一个复杂类型的集合
嵌套结果映射 – 集合可以指定为一个 resultMap 元素，或者引用一个
discriminator – 使用结果值来决定使用哪个 resultMap
case – 基于某些值的结果映射
嵌套结果映射 – 一个 case 也是一个映射它本身的结果,因此可以包含很多相 同的元素，或者它可以参照一个外部的 resultMap。

#### id&result

```m
<id property="id" column="post_id"/>
<result property="subject" column="post_subject"/>
```

这些是结果映射最基本的内容。id 和 result 都将一个列的值映射到一个简单数据类型(字符串,整型,双精度浮点数,日期等)的属性或字段。

这两者之间的唯一不同是， id 表示的结果将是对象的标识属性，这会在比较对象实例时用到。 这样可以提高整体的性能，尤其是缓存和嵌套结果映射(也就是联合映射)的时候。

#### 关联

1. 关联元素处理“有一个”类型的关系。比如,在我们的示例中,一个博客有一个用户。 关联映射就工作于这种结果之上。你指定了目标属性,来获取值的列,属性的 java 类型(很 多情况下 MyBatis 可以自己算出来) ,如果需要的话还有 jdbc 类型,如果你想覆盖或获取的 结果值还需要类型控制器。

```m
<association property="author" column="blog_author_id" javaType="Author">
  <id property="id" column="author_id"/>
  <result property="username" column="author_username"/>
</association>
```

* column:来自数据库的列名,或重命名的列标签。这和通常传递给 resultSet.getString(columnName)方法的字符串是相同的。 column 注 意 : **要 处 理 复 合 主 键** , 你 可 以 指 定 多 个 列 名 通 过 column= ” {prop1=col1,prop2=col2} ” 这种语法来**传递给嵌套查询语 句**。这会引起 prop1 和 prop2 以参数对象形式来设置给目标嵌套查询语句。
* select:另外一个映射语句的 ID,可以加载这个属性映射需要的复杂类型。获取的 在列属性中指定的列的值将被传递给目标 select 语句作为参数。表格后面 有一个详细的示例。 select 注 意 : 要 处 理 复 合 主 键 , 你 可 以 指 定 多 个 列 名 通 过 column= ” {prop1=col1,prop2=col2} ” 这种语法来传递给嵌套查询语 句。这会引起 prop1 和 prop2 以参数对象形式来设置给目标嵌套查询语句。
* fetchType:可选的。有效值为 lazy和eager。 如果使用了，它将取代全局配置参数lazyLoadingEnabled。

#### 集合

```m
<collection property="posts" ofType="domain.blog.Post">
  <id property="id" column="post_id"/>
  <result property="subject" column="post_subject"/>
  <result property="body" column="post_body"/>
</collection>
```

1. 首先,你应 该注意我们使用的是集合元素。然后要注意那个新的“ofType”属性。这个属性用来区分 JavaBean(或字段)属性类型和集合包含的类型来说是很重要的。

### 缓存

1. MyBatis 包含一个非常强大的查询缓存特性,它可以非常方便地配置和定制。MyBatis 3 中的缓存实现的很多改进都已经实现了,使得它更加强大而且易于配置。默认情况下是没有开启缓存的,除了局部的 session 缓存,可以增强变现而且处理循环 依赖也是必须的。要开启二级缓存,你需要在你的 SQL 映射文件中添加一行:\<cache/>
2. 缓存中:
    * 映射语句文件中的所有 select 语句将会被缓存。
    * 映射语句文件中的所有 insert,update 和 delete 语句会刷新缓存。
    * 缓存会使用 Least Recently Used(LRU,最近最少使用的)算法来收回。
    * 根据时间表(比如 no Flush Interval,没有刷新间隔), 缓存不会以任何时间顺序 来刷新。
    * 缓存会存储列表集合或对象(无论查询方法返回什么)的 1024 个引用。
    * 缓存会被视为是 read/write(可读/可写)的缓存,意味着对象检索不是共享的,而 且可以安全地被调用者修改,而不干扰其他调用者或线程所做的潜在修改。
3. 关于一级缓存的范围是sqlsession范围,而二级缓存是mapper映射范围有效.在sqlsession查询完毕提交后,才会写入二级缓存中,此时就不直接去查询数据库而直接从缓存中读取.

## 动态 SQL

1. MyBatis 的强大特性之一便是它的动态 SQL。

### if:动态 SQL 通常要做的事情是根据条件包含 where 子句的一部分。比如：

```m
<select id="findActiveBlogWithTitleLike"
     resultType="Blog">
  SELECT * FROM BLOG
  WHERE state = ‘ACTIVE’
  <if test="title != null">
    AND title like #{title}
  </if>
</select>
```

### choose, when, otherwise

       有时我们不想应用到所有的条件语句，而只想从中择其一项。针对这种情况，MyBatis 提供了 choose 元素，它有点像 Java 中的 switch 语句。

```m
<select id="findActiveBlogLike"
     resultType="Blog">
  SELECT * FROM BLOG
  WHERE
  <if test="state != null">
    state = #{state}
  </if>
  <if test="title != null">
    AND title like #{title}
  </if>
  <if test="author != null and author.name != null">
    AND author_name like #{author.name}
  </if>
</select>
```

1. **where 元素只会在至少有一个子元素的条件返回 SQL 子句的情况下才去插入“WHERE”子句。而且，若语句的开头为“AND”或“OR”，where 元素也会将它们去除。**

### foreach

动态 SQL 的另外一个常用的操作需求是对一个集合进行遍历，通常是在构建 IN 条件语句的时候。比如：

```m
<select id="selectPostIn" resultType="domain.blog.Post">
  SELECT *
  FROM POST P
  WHERE ID in
  <foreach item="item" index="index" collection="list"
      open="(" separator="," close=")">
        #{item}
  </foreach>
</select>
```