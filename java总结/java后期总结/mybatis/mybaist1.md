第一堂课：
	1.什么是框架： 
			半成品，简化开发
	2.介绍SSM框架与javaEE三层体系结构的对应关系
			springmvc:web层      springIOC:service层      mybatis:Dao层
	3.jdbc操作数据库存在的问题：
			硬编码 、 频繁创建及释放数据库连接
	4.mybaits概述
			持久层框架、 ORM思想、开发者关注sql本身

第二堂课
	1.mybatis准备工作：
			创建maven工程、导入依赖、资料中sql导入到数据库中 
	2.mybatis的环境搭建（重点）：
			(1)创建了与数据库User表对应的实体类user及dao的接口
			(2)创建核心配置文件 sqlMapConfig.xml
			(3)创建映射配置文件 IUserDao.xml
第三堂课
	1.mybatis的入门案例：
			（1） 读取配置文件
			（2） sessionFactory
			 (3)  sqlSession
			 (4)  获取代理对象
			 (5)  调用方法
			 (6)  释放资源
  	2.mybatis注解开发和编写dao实现类的方式
第四堂课
	1.mybatis入门案例中的设计模式分析
			构建者模式:将创建对象的细节隐藏，使用者直接调用方法就可以获取对象
			工厂模式:解耦
			代理模式：不修改源码的情况下，对方法进行增强
	2.selectList方法内部分析
	2.getMapper方法内部分析
			1.创建代理对象
			2.invork方法内部调用selectList
第五堂课
	1. 自定义mybatis的编码-根据测试类中缺少的创建接口和类
	2. 自定义mybatis的编码-解析XML的工具类介绍

第六堂课
	1.自定义Mybatis的编码-创建两个默认实现类并分析类之间的关系
	2.自定义Mybatis的编码-实现基于XML的查询所有操作
	3.自定义Mybatis的编码-实现基于注解配置的查询所有
	
	

	