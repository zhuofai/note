# day821Test

## 练习一：Object类equals方法

1. 简述String类中的equals方法与Object类中的equals方法的不同点。

>String类中的equals方法是用来判断两个对象的内容是否相同，而Object 类中的equals方法是用来判断两个对象是否是同一个对象，所谓同一个对象指的是内存中的同一块存储空间。

## 练习二：Object类的toString方法

1. 不运行代码，直接说出打印结果，并解释原因。

```java
public class ToStringTest{
    static int i= 1;
    public static void main(String args[]){
        System.out.println("love " + new ToStringTest());//love java
        ToStringTest a = new ToStringTest();
        a.i++;
        System.out.println("me " + a.i);//me 2
    }
    public String toString(){
        System.out.print("I ");//I
        return "java ";
    }
}/*I love java
me 2
原因：当执行代码的时候，首先加载静态变量，然后执行main方法，由于main方法内部第一行代码为输出语句，里面new了此类对象，当执行此行代码时会先创建了本类的对象，由于此类重写了toString方法，会先执行toString方法的打印输出，然后返回“java ”，再执行main方法第一行打印输出。在Java中“System.out.println(类对象名);”实际输出的是该对象的toString()方法返回的字符串，即括号中的内容等价于类对象名.toString(),toString方法的好处是在碰到println方法的时候会被自动调用，不用显示的写出来。
///~
```

## 练习三：Object类equals方法

1. 看下列程序，不运行说结果，写出答案后，并在IntelliJ IDEA中运行看看自己给的答案与运行结果是否正确，并分析原因。

```java
//(1)
String s1 = new String("abc");
String s2 = "abc";
System.out.println(s1 == s2);//false
System.out.println(s1.equals(s2));//true
//(2)
String s1 = "abc";
String s2 = "abc";
System.out.println(s1 == s2);//true
System.out.println(s1.equals(s2));//true
//(3)
String s1 = "a" + "b" + "c";
String s2 = "abc";
System.out.println(s1 == s2);//false
System.out.println(s1.equals(s2));//true
//(4)
String s1 = "ab";
String s2 = "abc";
String s3 = s1 + "c";
System.out.println(s3 == s2);//false
System.out.println(s3.equals(s2));//true
```

## 练习四：StringBuilder类与String类的区别

1. 简述StringBuilder类与String类的区别。

>答：String类的对象内容不可改变，所以每当进行字符串拼接时，总是会在内存中创建一个新的对象，所以经常改变内容的字符串最好不要用String，因为每次生成对象都会对系统性能产生影响.  
StringBuilder又称为可变字符序列，是JDK5.0中新增加的一个类，它是一个类似于String的字符串缓冲区，通过某些方法调用可以改变该序列的长度和内容。即它是一个容器，容器中可以装很多字符串，并且能够对其中的字符串进行各种操作。它的内部拥有一个数组用来存放字符串内容，进行字符串拼接时，直接在数组中加入新内容，StringBuilder会自动维护数组的扩容。

## 练习五：Date类的使用

1. 请用代码实现:获取当前的日期,并把这个日期转换为指定格式的字符串,如2088-08-08 08:08:08。

```java
public class Test{
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String format = sdf.format(d.getTime());
        System.out.println(format);
    }
}
```

## 练习六：DateFormat类方法的使用

1. 使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日。

```java
public class Test{
    public static void main(String[] args){
        String str = "2018-03-04";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse(str);
        String format = sdf.format(d)
        System.out.println(format);
    }
}
```

## 练习七：Calendar类方法的使用

1. 用程序判断2018年2月14日是星期几。

```java
public class Test{
    public static void main(String[] args){
        Calendar ca = Calendar.getInstance();
        ca.set(2018,2,14);
        Date d = ca.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("EE");
        System.out.println(sdf.format(d));
    }
}
```

扩展题

## 练习八：System类arraycopy方法的使用

1. 现有一个字符数组{'i','t','c','a','s','a'}，请使用System类中的arraycopy()方法在控制台输出“itcast”。（提示：将[1]号数组元素复制到最后位置并覆盖原有元素。）

```java
public class ArraycopyTest {
    public static void main(String[] args) {
        char[] cha ={'i','t','c','a','s','a'};
        //将cha数组中第2个元素，复制到目标数组最后一位数组上
        System.arraycopy(cha, 1, cha, 5, 1);
        //遍历目标数组，在控制台输出字符串
        for (int i = 0; i < cha.length; i++) {
            System.out.print(cha[i]);
        }
    }
}

```

## 练习九：StringBuilder类的使用

1. 请使用代码实现 分别使用String的+=和StringBuilder的append方法对字符串做100000次拼接，计算String拼接100000次花费时间与StringBuilder拼接100000次所花费时间并打印。

```java
public class Test{
    public static void main(String[] args){
        String str = "";
        StringBuilder sb = new StringBuilder("");
        long d1 = System.currentTimeMillis();
        for(int i = 0;i < 100000;i++){
            str += i;
        }
        long d2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        long d3 = System.currentTimeMillis();
        System.out.println("string" + (d2 - d1));
        System.out.println("sb" + (d3 - d2));
    }
}
```

## 练习十：StringBuilder类的使用（reverse()方法）

1. 分析以下需求，并用代码实现：
    * 定义数字字符串数组{"010","3223","666","7890987","123123"}；
    * 判断该数字字符串数组中的数字字符串是否是对称(第一个数字和最后一个数字相等，第二个数字和倒数第二个数字是相等的，依次类推)的，并逐个输出；
    * 如：010 是对称的，3223 是对称的，123123 不是对称的；
    * 最终打印该数组中对称字符串的个数。

注：判断对称可用reverse(),将此字符序列用其反转形式取代。

```java
public class Test{
    public static void main(String[] args){
        String[] str = {"010", "3223", "666", "7890987", "123123"};
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            boolean b = true;
            char[] arr = str[i].toCharArray();
            int n = arr.length;
            for (int j = 0; j < arr.length / 2; j++) {
                n--;
                if (arr[j] != arr[n]) {
                    b = false;
                    break;
                }
            }
            if (b) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```
