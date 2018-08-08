# 今日笔记

1. ++,--  
> 作用:给变量进行+1或者-1的操作
单独使用:前++和后++用法完全一样,开发过程中90%都是单独使用  
> 混合使用:前++ ---> 其原先的值先+1后的结果在参与其他运算 后++ --->其原先的值先参与运算,然后在进行+1的操作

1. ++,--

>里面隐含了强制类型转换!!!
例如:
byte myAge = 31;
System.out.println("2018年的时候我的年龄是"+myAge );
//myAge = myAge + 1;  
>//错误写法: 右边是int类型,装不进byte的容器中 myAge++;  
>//正确写法:因为底层会帮我们强制类型转换---> myAge = (byte)(myAge + 1);
System.out.println("2019年的时候我的年龄是"+myAge );

1. 赋值运算

>将右边的结果赋值给左边的变量!!!  =,+=,-=,*=,/=,%=
a+=10 ----> a = a + 10;  
> 注意:_扩展的赋值运算符隐含了强制类型转化_ 例如:byte b = 10;b+=5;//正确写法 ,原因底层帮我们做了强制类型转化 b = (byte)(b + 5);b = b + 5;//错误写法,右边的是int类型,左边是byte类型

1. 转型问题char short byte 之间进行运算时都会先转化成为int进行运算再返回值
1. 系统的优化  
    >变量byte,short,char,如果右边全部是常量,并且右边的结果没有操作左边的数据范围的话,系统出现常量优化机制
    1. 右边必须都是常量
    2. 右边的结果没有超过左边的范围

```java
byte b1 = 12;
byte b2 = 13;
int result = b1 + b2;//此时需要用int来提升类型
```

## 今日习题

### day02

### 第一题：练习今日的代码

### 第二题：分析以下需求并实现

1. 以下代码是否会有问题？为什么？

```java
//此代码没有问题,byte和int类型在操作的时候会把byte类型提升为int 接收
public class Test {
    public static void main(String[] args) {
        int i1 = 5;
        byte b1 = 4;
        int sum = i1+ b1;
        System.out.println(sum);
    }
}
```

### 第三题：分析以下需求并实现

1. 以下代码是否会有问题？为什么？

```java
//此代码有问题应该把byte sum改为用int接收i1+b1的sum
public class Test {
    public static void main(String[] args) {
        int i1 = 5;
        byte b1 = 4;
        byte sum = i1+ b1;
        System.out.println(sum);
    }
}
```

### 第四题：分析以下需求并实现

1. 以下代码是否会有问题？为什么？

```java
//此代码有问题应该把byte sum改为用int接收b1+5的sum
public class Test {
    public static void main(String[] args) {
        byte b1 = 5;
        byte sum = b1 + 5;
        System.out.println(sum);
    }
}
```

### 第五题：分析以下需求并实现

1. 查看以下代码，并写出结果

```java
public class Test {
    public static void main(String[] args) {
        int i1 = 5;
        boolean result = (i1++ > 5) && (++i1 > 4);
        System.out.println(result);
        System.out.println(i1);
    }
}//out:false
//6
```

### 第六题：分析以下需求并实现

1. 查看以下代码，并写出结果

```java
public class Test {
    public static void main(String[] args) {
        int i1 = 5;
        boolean result = (i1++ > 5) || (++i1 > 4);
        System.out.println(result);
        System.out.println(i1);
    }
}
//out:true
//7
```

### 第七题：分析以下需求并实现

1. 请使用三元运算符计算出两个整数中的最大值。例如：20 40     打印结果：40是最大值

```java
public static void main(String[] args){
    int a = 20;
    int b = 40;
    int c = a > b ? a : b;
    System.out.println(c+"是最大值");
}
```

### 第八题：分析以下需求并实现

1. 请使用三元运算符计算出三个整数中的最大值。  例如：20 40 30     打印结果：40是最大值

```java
public static void main(String[] args){
    int a = 20;
    int b = 30;
    int c = 40;
    int big = a > b ? a : b;
    big = big > c ? big : c;
    System.out.println(big+"是最大值");
}
```

### 第九题：分析以下需求并实现

1. 定义一个方法，方法名为：show()

>public static void show(){}

1. 在show()方法中输出以下几句话：
    我爱黑马
    我爱java
    我要好好学习

```java
public static void show(){
    System.out.println("我爱黑马");
    System.out.println("我爱java");
    System.out.println("我要好好学习");
}
```

1. 在主方法中调用show()方法并运行，输出内容

```java
public static void main(String[] args){
    show();
}
```

### 第十题：分析以下需求并实现

1. 定义一个方法，方法名为：show()

2. 在show()方法中输出以下几句话：
    我爱黑马
    我爱java
    我要好好学习
3. 再定义一个方法，方法名为：print()
4. 在print()方法中调用show()方法
5. 在主方法中调用print()方法并运行，输出内容

```java
public class Out{
    public static void show(){
        System.out.println("我爱黑马");
        System.out.println("我爱java");
        System.out.println("我要好好学习");
    }
    public static void print(){
        show()
    }
    public static void main(String[] args){
        print();
    }
}
```

## 附加题

### 第1题:分析以下需求，并用代码实现

1. 键盘录入一个三位整数数，请分别获取该三位数上每一位的数值
2. 例如：键盘录入的整数123的个位、十位、百位，分别是3、2、1
3. 打印格式:"数字123的个位是 3, 十位是 2, 百位是 1"

```java
public class inner{
    public static void main(String[] args){
        Scanner sc = new Scnner(System.in);
        int a = 0;
        int arr[] = new int [10];
        int i = 0;
        int temp = 0 ;
        int n = 0;
        for(int j = 0;j < 3 ;j++){
            a = sc.nextInt();
            temp = a;
            while(temp!=0){
                arr[i] = temp%10;
                temp /= 10;
                i++;
            }
            System.out.print("数字" + a );
            for(;i>0;i--){
                if(n == 0)
                    System.out.print("个位是" + arr[n]);
                if(n == 1)
                    System.out.print("十位是" + arr[n]);
                if(n == 2)
                    System.out.print("百位是" + arr[n]);
                if(n == 3)
                    System.out.print("千位是" + arr[n]);
                n++;
            }
            System.out.println();
            i = 0;
        }
    }
}
```

### 第2题：看程序说结果，请不要提前运行？

```java
public class Test03 {
    public static void main(String[] args) {
            int x = 4;
            int y = (--x)+(x--)+(x*10);
            System.out.println("x = " + x + ",y = " + y);
    }
}//out:x = 3 ,y = 26
```

### 第3题:分析以下需求，并用代码实现

1. 键盘录入一个学生成绩(int类型)
2. 判断该学生成绩是否及格
3. 打印格式：
    成绩>=60:打印"合格"
    成绩<60:打印"不合格"

```java
public class Student{
    public static void main(String[] args){
        Scnner sc = new Scnner(System.in);
        int st = sc.nextInt();
        if(st >= 60){
            System.out.println("合格");
        }
        else{
            System.out.println("不合格");
        }
    }
}
```

### 第4题:分析以下需求，并用代码实现

1. 键盘录入三个int类型的数字
2. 要求：
    (1)求出三个数中的最小值并打印
    (2)求出三个数的和并打印

```java
public class Input{
    public static void main(String[] args){
        Scnner sc = new Scnner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int small = a > b ? b : a;
        small = small > c ? c : small;
        System.out.println(small);
        int sum = a + b + c;
        System.out.println(sum);
    }
}
```