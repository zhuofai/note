# java基础题

>(小荣老师qq:2046856218，休息日有问题加qq提问，晚上10:00-11:00统一解答)
## 一、7.30

1. 声明两个int类型变量并赋值，然后求出两变量之和，在控制台打印输出结果。

```java
public class Test1{
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        int sum = a + b;
        System.out.println(sum);
    }
}
```

2. 已知一个整数为3251,分别取出每一位上的数字，并按照一定格式打印输出。如:"数字3251的个位是 1, 十位是 5, 百位是 2，千位是3"。

```java
public class Test2{
    public static void main(String[] args){
        int temp = 3251;
        int[] arr = new arr[4];
        int i = 0;
        while(temp!=0){
            arr[i] = temp%10;
            temp /= 10;
        }
        System.out.println("数字"+temp + "的个位数字为"+arr[0]+",十位是"+arr[1]+"百位是" + arr[2]+"千位是" + arr[3]);
    }
}
```

3. 定义三个int变量并赋值，求出三数中的最大值，在控制台打印出最大值。

```java
public class Test3{
    int a = 25;
    int b = 30;
    int c= 35;
    int big = a > b ? a : b;
    big = big > c ? big : c;
    System.out.println("最大值为"+ big);
}
```

4. 定义一个方法printString，在方法内部打印输出字符串“HelloWorld”，并在main方法内部调用该方法。

```java
public class Test4{
    public static void printString(){
        System.out.println("HelloWorld");
    }
    public static void main(String[] args){
        printString();
    }
}
```

5. 定义一个方法getSum，在方法内部声明两个int类型变量并赋值，求出两数之和并打印输出结果，并在main方法内部调用该方法。

```java
public class Test5{
    public static void getSum{
        int a = 1;
        int b = 2;
        int sum = a+ b;
        System.out.println(sum);
    }
    public static void main(String[] args){
        getSum();
    }
}
```

6. 定义一个方法isEquals，在方法内部声明两个int类型变量并赋值，比较这两个数据是否相等，相等打印true，不相等打印false，并在main方法内部调用该方法。

```java
public class Test6{
    public static void isEquals(){
        int a = 20;
        int b = 20;
        System.out.println(a==b);
    }
    public static void main(String[] args){
        isEquals();
    }
}
```

7. 定义一个方法getMin，在方法内部声明3个int类型变量并赋值，求出最小值，并打印输出到控制台，并在main方法内部调用该方法。

预习第3天内容，完成以下题目：

```java
public class Test7{
    public static void getMin(){
        int a = 1;
        int b = 2;
        int c = 3;
        int small = a > b ? b : a;
        small = small > c ? c : small;
        System.out.println(small);
    }
    public static void main(String[] args){
        getMin();
    }
}
```

8. 这次点招考试计划的分数线为23分(包含23)以上为通过,18-23分为待定,18分以下(不包含18)为不通过。定义一个成绩，并使用if语句来判断该成绩是否通过，将结果打印到控制台，如： 成绩为25分，通过。

```java
public class Test8{
    public static void judge(){
        int score = 20;
        if(score >= 23){
            System.out.println("通过");
        }
        else if(18 < score && score < 23){
            System.out.println("待定");
        }
        else{
            System.out.println("不通过");
        }
    }
    public static void main(String[] args){
            judge();
    }
}
```

9. 模拟遥控器调整音量。定义一个音量，如果值为1，那么打印输出“音量增大”；如果值为2，那么打印输出“音量减小”；如果值为3，那么打印输出“关机”；若值为其他数字，打印“抱歉，您给出的数字不合法”。（switch语句）

```java
public class Test9{
    public static void output(int a){
        switch(a){
            case 1:
                System.out.println("音量增大");
                break;
            case 2:
                System.out.println("音量减小");
                break;
            case 3:
                System.out.println("关机");
                break;
            default:
                System.out.println("抱歉,您给出的数字不合法");
        }
    }
    public static void main(String[] args){
        Scnner sc = new Scnner(System.in);
        int a = sc.nextInt();
        output(a);
    }
}
```

10. 使用for循环实现打印100次helloworld。

```java
public class Test10{
    public static void output(){
        for(int i = 0;i < 100;i++){
            System.out.println("helloworld");
        }
    }
    public static void main(String[] args){
        output();
    }
}
```

1. 使用while循环实现打印1到100之间的所有整数。

```java
public class Test11{
    public static void output(){
        int i = 1;
        while(i!=101){
            System.out.println(i);
            i++;
        }
    }
    public static void main(String[] args){
        output();
    }
}
```

