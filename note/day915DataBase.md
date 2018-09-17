# Database

1. mysql安装

查看版本：mysql --version
启动服务：net start 服务名
停止服务：net stop 服务名

登录：mysql [-hip地址] -u用户名 -p密码
mysql [--host=ip地址] --user=用户名 --password=密码
登出：quit/exit

sql通用语法：
1.分号结尾。 
2.不区分大小写,建议关键字大写
3.注释：-- 注释  # 注释（mysql特有） /* 注释 */  

2.库的增删改查
增：create database [if not exists] 库名 [character set 字符集];
删：drop database [if exists] 库名
改：alter database 库名 character set 字符集;
查：查询所有：show databases;	
    查询建库语句：show create database 库名;
使用：use 库名
      查看正在使用的库:select database()
3.表的增删改查
增：create table 表名(
	列名 数据类型,
	列名 数据类型...
    );
    数据类型：
	1.整数 int
	2.小数 double
	3.字符串 varchar
	4.日期 date   datetime   timestamp（时间戳）
     复制：create table 表名 like 旧表名
	
删：drop table [if exists] 表名
改：修改表名：alter table 表名 rename to 新表名;
    修改字符集：alter table 表名 character set 字符集;
    添加列：alter table 表名 add 列名 数据类型;
    删除列：alter table 表名 drop 列名
    修改列：alter table 表名 change 列名 新列名 新数据类型;
    	    alter table 表名 modify 列名 新数据类型;
查：show tables;
    查询表结构：desc 表名;


4.记录的增删改查
增：INSERT INTO 表名 VALUES (值1,值2...); 注：要写出表中所有列的值
    INSERT INTO 表名 (列1,列2...) VALUES (值1,值2...);
    批量添加：
    INSERT INTO student (列1,列2...) VALUES (记录1的值1,记录1的值2,记录1的值3),(记录2的值1,记录2的值2,记录2的值3)...;

删：delete from 表名 where 条件
    删除所有记录 truncate table 表名

改：update 表名 set 列名1=值1,列名2=值2... where 条件;


查：	select 列名
	from 表名
	where 条件
  	group by 分组
  	having 分组后的条件
	order by 字段1 规则,字段2 规则...
	limit 开始的索引,查询的条数

	列名的注意事项：
		1.可以用*代替所有字段
		2.结果去重(完全一样):distinct
		3.列之间可以运算
			补充：ifnull(参数1,参数2)：如果参数1的值为NULL，则替换为参数2的值
		4.其别名：as(可以省略)

	条件的注意事项：
		>,<,>=,<=,=,!=\<>
		between...and
		in(元素1，元素2...)
		is null,is not null
		&&/and,||/or,!/not
		like 
			_:匹配单个任意字符
			%:匹配多个任意字符
	
	排序的注意事项：
		规则：ASC 升序，默认的 / DESC 降序

	聚合函数：对结果的某列数据进行纵向计算。
		  count()/max()/min()/sum()/avg()
		  注：聚合函数计算时不考虑NULL(用ifnull函数解决)

	分组：讲查询结果按照某个字段进行分类。
		1.分组之后展示的字段：分组字段，聚合函数。
		2.where和having的区别：
			（1）where:先限定后分组。
			     having:先分组后限定。
			（2）where后不能跟聚合函数。having可以进行聚合函数判断。


5.约束
	（1）非空约束
		增：CTEATE TABLE 表名 (列名 数据类型 NOT NULL);
		删：ALTER TABLE 表名 MODIFY 列名 数据类型;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 NOT NULL;
	（2）唯一约束（可以有一个NULL）
		增：CTEATE TABLE 表名 (列名 数据类型 UNIQUE);
		删：ALTER TABLE 表名 DROP INDEX 列名;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 UNIQUE;
	（3）主键约束(非空，唯一)
		增：CTEATE TABLE 表名 (列名 数据类型 PRIMARY KEY);
		删：ALTER TABLE 表名 DROP PRIMARY KEY;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 PRIMARY KEY;
			自动增长：
				增：CTEATE TABLE 表名 (列名 数据类型 PRIMARY KEY AUTO_INCREMENT);
				删：ALTER TABLE 表名 MODIFY 列名 数据类型;
				改：ALTER TABLE 表名 MODIFY 列名 数据类型 AUTO_INCREMENT;			

	（4）外键约束：与其他表建立关联的列。
		增：CREATE TABLE 表名(...， CONSTRAINT 外键名 FOREIGN KEY (列名) REFERENCES 关联表名 (关联表主键名))
		删：ALTER TABLE 表名 DROP FOREIGN KEY 外键名。
		改：ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (列名) 
			REFERENCES 关联表名 (关联表主键名) [ON UPDATE CASCADE] [ON DELETE CASCADE]

6.数据库设计
	（1）多表关系
		一对一：任意一方添加唯一外键指向另一方主键。
		一对多：多方建立外键，指向一方的主键。
		多对多：创建中间表，包含两个字段，分别作为外键指向两张表的主键。
	（2）数据库三大范式
		第一范式：每一列的数据都是不可分割的。
		第二范式：表中的所有列都必须只和主键相关。
		第三范式：表中的所有列和主键直接相关而不是间接相关。
7.数据库管理
	（1）导入导出
		导出：mysqldump -u用户名 -p密码 数据库名>路径（注意加文件名）
		导入：创建数据库 --> use 数据库 --> source 文件路径

1.mysql安装
查看版本：mysql --version
启动服务：net start 服务名
停止服务：net stop 服务名

登录：	mysql [-hip地址] -u用户名 -p密码
	mysql [--host=ip地址] --user=用户名 --password=密码
登出：	quit/exit

sql通用语法：
1.分号结尾。 
2.不区分大小写,建议关键字大写
3.注释：-- 注释  # 注释（mysql特有） /* 注释 */  

2.库的增删改查
增：create database [if not exists] 库名 [character set 字符集];
删：drop database [if exists] 库名
改：alter database 库名 character set 字符集;
查：查询所有：show databases;	
    查询建库语句：show create database 库名;
使用：use 库名
      查看正在使用的库:select database()


3.表的增删改查
增：create table 表名(
	列名 数据类型,
	列名 数据类型...
    );
    数据类型：
	1.整数 int
	2.小数 double
	3.字符串 varchar
	4.日期 date   datetime   timestamp（时间戳）
     复制：create table 表名 like 旧表名
	
删：drop table [if exists] 表名
改：修改表名：alter table 表名 rename to 新表名;
    修改字符集：alter table 表名 character set 字符集;
    添加列：alter table 表名 add 列名 数据类型;
    删除列：alter table 表名 drop 列名
    修改列：alter table 表名 change 列名 新列名 新数据类型;
    	    alter table 表名 modify 列名 新数据类型;
查：show tables;
    查询表结构：desc 表名;


4.记录的增删改查
增：INSERT INTO 表名 VALUES (值1,值2...); 注：要写出表中所有列的值
    INSERT INTO 表名 (列1,列2...) VALUES (值1,值2...);
    批量添加：
    INSERT INTO student (列1,列2...) VALUES (记录1的值1,记录1的值2,记录1的值3),(记录2的值1,记录2的值2,记录2的值3)...;

删：delete from 表名 where 条件
    删除所有记录 truncate table 表名

改：update 表名 set 列名1=值1,列名2=值2... where 条件;


查：	select 列名
	from 表名
	where 条件
  	group by 分组
  	having 分组后的条件
	order by 字段1 规则,字段2 规则...
	limit 开始的索引,查询的条数

	列名的注意事项：
		1.可以用*代替所有字段
		2.结果去重(完全一样):distinct
		3.列之间可以运算
			补充：ifnull(参数1,参数2)：如果参数1的值为NULL，则替换为参数2的值
		4.其别名：as(可以省略)

	条件的注意事项：
		>,<,>=,<=,=,!=\<>
		between...and
		in(元素1，元素2...)
		is null,is not null
		&&/and,||/or,!/not
		like 
			_:匹配单个任意字符
			%:匹配多个任意字符
	
	排序的注意事项：
		规则：ASC 升序，默认的 / DESC 降序

	聚合函数：对结果的某列数据进行纵向计算。
		  count()/max()/min()/sum()/avg()
		  注：聚合函数计算时不考虑NULL(用ifnull函数解决)

	分组：讲查询结果按照某个字段进行分类。
		1.分组之后展示的字段：分组字段，聚合函数。
		2.where和having的区别：
			（1）where:先限定后分组。
			     having:先分组后限定。
			（2）where后不能跟聚合函数。having可以进行聚合函数判断。


5.约束
	（1）非空约束
		增：CTEATE TABLE 表名 (列名 数据类型 NOT NULL);
		删：ALTER TABLE 表名 MODIFY 列名 数据类型;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 NOT NULL;
	（2）唯一约束（可以有一个NULL）
		增：CTEATE TABLE 表名 (列名 数据类型 UNIQUE);
		删：ALTER TABLE 表名 DROP INDEX 列名;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 UNIQUE;
	（3）主键约束(非空，唯一)
		增：CTEATE TABLE 表名 (列名 数据类型 PRIMARY KEY);
		删：ALTER TABLE 表名 DROP PRIMARY KEY;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 PRIMARY KEY;
			自动增长：
				增：CTEATE TABLE 表名 (列名 数据类型 PRIMARY KEY AUTO_INCREMENT);
				删：ALTER TABLE 表名 MODIFY 列名 数据类型;
				改：ALTER TABLE 表名 MODIFY 列名 数据类型 AUTO_INCREMENT;			

	（4）外键约束：与其他表建立关联的列。
		增：CREATE TABLE 表名(...， CONSTRAINT 外键名 FOREIGN KEY (列名) REFERENCES 关联表名 (关联表主键名))
		删：ALTER TABLE 表名 DROP FOREIGN KEY 外键名。
		改：ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (列名) 
			REFERENCES 关联表名 (关联表主键名) [ON UPDATE CASCADE] [ON DELETE CASCADE]

6.数据库设计
	（1）多表关系
		一对一：任意一方添加唯一外键指向另一方主键。
		一对多：多方建立外键，指向一方的主键。
		多对多：创建中间表，包含两个字段，分别作为外键指向两张表的主键。
	（2）数据库三大范式
		第一范式：每一列的数据都是不可分割的。
		第二范式：表中的所有列都必须只和主键相关。
		第三范式：表中的所有列和主键直接相关而不是间接相关。
7.数据库管理
	（1）导入导出
		导出：mysqldump -u用户名 -p密码 数据库名>路径（注意加文件名）
		导入：创建数据库 --> use 数据库 --> source 文件路径



1.mysql安装
查看版本：mysql --version
启动服务：net start 服务名
停止服务：net stop 服务名

登录：	mysql [-hip地址] -u用户名 -p密码
	mysql [--host=ip地址] --user=用户名 --password=密码
登出：	quit/exit

sql通用语法：
1.分号结尾。 
2.不区分大小写,建议关键字大写
3.注释：-- 注释  # 注释（mysql特有） /* 注释 */  

2.库的增删改查
增：create database [if not exists] 库名 [character set 字符集];
删：drop database [if exists] 库名
改：alter database 库名 character set 字符集;
查：查询所有：show databases;	
    查询建库语句：show create database 库名;
使用：use 库名
      查看正在使用的库:select database()


3.表的增删改查
增：create table 表名(
	列名 数据类型,
	列名 数据类型...
    );
    数据类型：
	1.整数 int
	2.小数 double
	3.字符串 varchar
	4.日期 date   datetime   timestamp（时间戳）
     复制：create table 表名 like 旧表名
	
删：drop table [if exists] 表名
改：修改表名：alter table 表名 rename to 新表名;
    修改字符集：alter table 表名 character set 字符集;
    添加列：alter table 表名 add 列名 数据类型;
    删除列：alter table 表名 drop 列名
    修改列：alter table 表名 change 列名 新列名 新数据类型;
    	    alter table 表名 modify 列名 新数据类型;
查：show tables;
    查询表结构：desc 表名;


4.记录的增删改查
增：INSERT INTO 表名 VALUES (值1,值2...); 注：要写出表中所有列的值
    INSERT INTO 表名 (列1,列2...) VALUES (值1,值2...);
    批量添加：
    INSERT INTO student (列1,列2...) VALUES (记录1的值1,记录1的值2,记录1的值3),(记录2的值1,记录2的值2,记录2的值3)...;

删：delete from 表名 where 条件
    删除所有记录 truncate table 表名

改：update 表名 set 列名1=值1,列名2=值2... where 条件;


查：	select 列名
	from 表名
	where 条件
  	group by 分组
  	having 分组后的条件
	order by 字段1 规则,字段2 规则...
	limit 开始的索引,查询的条数

	列名的注意事项：
		1.可以用*代替所有字段
		2.结果去重(完全一样):distinct
		3.列之间可以运算
			补充：ifnull(参数1,参数2)：如果参数1的值为NULL，则替换为参数2的值
		4.其别名：as(可以省略)

	条件的注意事项：
		>,<,>=,<=,=,!=\<>
		between...and
		in(元素1，元素2...)
		is null,is not null
		&&/and,||/or,!/not
		like 
			_:匹配单个任意字符
			%:匹配多个任意字符
	
	排序的注意事项：
		规则：ASC 升序，默认的 / DESC 降序

	聚合函数：对结果的某列数据进行纵向计算。
		  count()/max()/min()/sum()/avg()
		  注：聚合函数计算时不考虑NULL(用ifnull函数解决)

	分组：讲查询结果按照某个字段进行分类。
		1.分组之后展示的字段：分组字段，聚合函数。
		2.where和having的区别：
			（1）where:先限定后分组。
			     having:先分组后限定。
			（2）where后不能跟聚合函数。having可以进行聚合函数判断。


5.约束
	（1）非空约束
		增：CTEATE TABLE 表名 (列名 数据类型 NOT NULL);
		删：ALTER TABLE 表名 MODIFY 列名 数据类型;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 NOT NULL;
	（2）唯一约束（可以有一个NULL）
		增：CTEATE TABLE 表名 (列名 数据类型 UNIQUE);
		删：ALTER TABLE 表名 DROP INDEX 列名;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 UNIQUE;
	（3）主键约束(非空，唯一)
		增：CTEATE TABLE 表名 (列名 数据类型 PRIMARY KEY);
		删：ALTER TABLE 表名 DROP PRIMARY KEY;
		改：ALTER TABLE 表名 MODIFY 列名 数据类型 PRIMARY KEY;
			自动增长：
				增：CTEATE TABLE 表名 (列名 数据类型 PRIMARY KEY AUTO_INCREMENT);
				删：ALTER TABLE 表名 MODIFY 列名 数据类型;
				改：ALTER TABLE 表名 MODIFY 列名 数据类型 AUTO_INCREMENT;			

	（4）外键约束：与其他表建立关联的列。
		增：CREATE TABLE 表名(...， CONSTRAINT 外键名 FOREIGN KEY (列名) REFERENCES 关联表名 (关联表主键名))
		删：ALTER TABLE 表名 DROP FOREIGN KEY 外键名。
		改：ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (列名) 
			REFERENCES 关联表名 (关联表主键名) [ON UPDATE CASCADE] [ON DELETE CASCADE]

6.数据库设计
	（1）多表关系
		一对一：任意一方添加唯一外键指向另一方主键。
		一对多：多方建立外键，指向一方的主键。
		多对多：创建中间表，包含两个字段，分别作为外键指向两张表的主键。
	（2）数据库三大范式
		第一范式：每一列的数据都是不可分割的。
		第二范式：表中的所有列都必须只和主键相关。
		第三范式：表中的所有列和主键直接相关而不是间接相关。
7.数据库管理
	（1）导入导出
		导出：mysqldump -u用户名 -p密码 数据库名>路径（注意加文件名）
		导入：创建数据库 --> use 数据库 --> source 文件路径
	（2）数据库用户的管理
		增：CREATE USER '用户名'@'主机' IDENTIFIED BY '密码';（%表示任意主机）
		删：DROP USER '用户名'@'主机'
		改：UPDATE USER SET PASSWORD = PASSWORD('新密码') WHERE USER = '用户名';（需要重启服务） 
		    SET PASSWORD FOR '用户名'@'主机'=PASSWORD('新密码');（不需要重启服务）
		查：SELECT * FROM USER;
		权限管理：
			增：GRANT INSERT ON 库名.表名 TO '用户名'@'主机';
			    GRANT ALL ON *.* TO '用户名'@'主机';（增加所有权限）
			删：REVOKE INSERT ON 库名.表名 FROM '用户名'@'主机';
			查：SHOW GRANTS FOR '用户名'@'主机';

8.多表查询
	（1）内连接查询
		隐式：select 字段列表 from 表名列表 where 条件;
		显式：select 字段列表 from 表名1 [inner] join 表名2 on 条件;
	（2）外连接查询
		select 字段列表 from 表名1 left/right [outer] join 表名2 on 条件;
		左外连接表1结果会全部显示，右外连接表2结果会全部显示。
	（3）子查询：查询中嵌套查询
		单行单列：子查询作为结果，用运算符（>,<,=....）判断。
		多行单列：子查询作为结果，用in判断。
		多行多列：子查询作为虚拟表参与查询。

	查询的技巧:（1）需要哪个列就找哪个表。
		   （2）哪个表都没有这个列，那就造一个表。
 		   （3）表可以自连接。
	
9.事务（一系列操作，要么同时成功，要么同时失败）
	（1）开启事务 START TRANSACTION 
	（2）回归 ROLLBACK
	（3）提交 COMMIT

	查询提交方式：SELECT @@AUTOCOMMIT;(1:自动提交 0:手动提交)
	改变提交方式：SET @@AUTOCOMMIT = 0/1;
	事务的四大特征：原子性、持久性、隔离性、一致性。

	数据库隔离级别：
	（1）read uncommited:读未提交（产生脏读、虚读、幻读）
	（2）read commited:读已提交(产生虚读、幻读)
	（3）repeatable read:可重复读(产生幻读，mysql默认)
	（4）Serializable:串行化（解决所有问题）
	级别越安全，效率越低。
	查询隔离级别：select @@tx_isolation;
	修改隔离级别：set global transaction isolation level 隔离级别;(需要重启数据库)