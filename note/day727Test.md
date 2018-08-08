# day01

## 第一题：练习今日的代码

## 第二题：分析以下需求并实现

1. 请画图实现十进制数字88转成二进制后的结果  
2. 请画图实现二进制数字10100转成十进制后的结果

![二进制与与十进制的转换](../notepicture/day727-二进制与十进制的转换运算.png)

## 第三题：分析以下需求并实现

1. 请写出JDK、JRE、JVM的作用

>JVM:java虚拟机,简称JVM,试运行所有java程序的假想计算机.是java程序的运行环境,是java最具吸引力的特性之一,我们编写的java代码,都运行在JVM之上.  
JRE(Java Runtime Environment)是java程序的运行时环境,包含JVM和运行时所需要的核心类库  
JDK(Java Development Kit)是java程序开发工具包,包含JRE和开发人员使用的工具.

1. 请写出JDK、JRE、JVM三者的包含关系

![jdkjre](../notepicture/day727-JDK&JRE&JVM关系示意图.png)

1. 请说出java跨平台的原理

>因为Java程序编译之后的代码不是能被硬件系统直接运行的代码，而是一种“中间码”——字节码。然后不同的硬件平台上安装有不同的Java虚拟机(JVM)，由JVM来把字节码再“翻译”成所对应的硬件平台能够执行的代码。因此对于Java编程者来说，不需要考虑硬件平台是什么。所以Java可以跨平台。
因为它有虚拟机（JVM），JAVA程序不是直接在电脑上运行的，是在虚拟机上进行的，每个系统平台都是有自己的虚拟机（JVM），所以JAVA语言能跨平台。

## 第四题：分析以下需求并实现

1. 请完整编写HelloWorld入门案例

```java
public class Test{
public static void main(String[] args){
System.out.println("Hello World");
}
}
```

## 第五题：分析以下需求并实现

1. 请写出注释的作用

>注释:就是对代码的解释和说明,其目的就是让人们能够更加轻松地了解代码.为代码添加注释,是十分必须要的,他不影响程序的编译和运行.

1. 请写出注释的分类

>单行注释以//开头 换行结束
多行注释以/\*开头  以*/结束

## 第六题：分析以下需求并实现

1. 请写出什么是关键字

>被java賦予了特殊含義的單詞

1. 请写出关键字的特征  
1. 全部小写或者@
1. 高级编辑特殊颜色

1. 请列举几个常见的关键字

>int byte short float true char default public void  

## 第七题：分析以下需求并实现

1. 请写出什么是标识符

>标识符:是指在程序中,我们定义内容.比如类的名字,方法的名字和变量的名字等等,都是标识符.

1. 请写出标识符的组成规则和注意事项

>标识符可以包含英文字母26个.0-9数字.$(美元符号)和_(下划线)  

## 第八题：分析以下需求并实现

1. 请输出以下常量

>"I LOVE JAVA"  66  88.88  'a'  true false

```java
public class Test08 {
public static void main(String[] args) {
System.out.println("I LOVE YOU");
System.out.println(66);
System.out.println(88.88);
System.out.println('a');
System.out.println(true);
System.out.println(false);
}
}
```

## 第九题：分析以下需求并实现

1. 请写出基本数据类型的四类八种

>整数byteshort intlong小数floatdouble字符char布尔 boolean  

## 第十题：分析以下需求并实现  

1. 请定义并输出以下变量

>//数据类型 变量名 = 初始化值;
String s = "I LOVE JAVA";  
int i = 66;  
double d = 88.88;  
char c = 'a';  
boolean flag1 = true;  
boolean flag2 = false;  

```java
public class Test10{
public static void main(String[] args){
String s = "I LOVE JAVA";  
int i = 66;  
double d = 88.88;  
char c = 'a';  
boolean flag1 = true;  
boolean flag2 = false;  
System.out.println(s);
System.out.println(i);
System.out.println(d);
System.out.println(c);
System.out.println(flag1);
System.out.println(flag2);
}
}
```