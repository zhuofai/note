### 第一题：练习今日的代码

### 第二题：分析以下需求并实现
1. 定义方法，求出两个整数的和
2. 调用方法，输出结果
```java
public class Test2{
    public static void sum(int a,int b){
        int sum = a + b;
        System.out.println(sum);
    }
    public static void main(String[] args){
        sum(1,2);
    }
}
```
### 第三题：分析以下需求并实现
1. 定义方法，求出两个小数的和
2. 调用方法，输出结果
```java
public class Test3{
    public static void sum(double a,double b){
        double sum = a + b;
        System.out.println(sum);
    }
    public static void main(String[] args){
        sum(1.2,2.2);
    }
}
```

### 第四题：分析以下需求并实现
1. 定义方法，求出长方形的周长
2. 调用方法，输出结果
```java
public class Test4{
    public static void sum(int a,int b){
        int sum = 2 * (a + b);
        System.out.println(sum);
    }
    public static void main(String[] args){
        sum(1,2);
    }
}
```

### 第五题：分析以下需求并实现
1. 定义方法，求出长方形的面积
2. 调用方法，输出结果
```java
public class Test5{
    public static void sum(int a,int b){
        int sum = a * b;
        System.out.println(sum);
    }
    public static void main(String[] args){
        sum(1,2);
    }
}
```
### 第1题：分析以下需求，并用代码实现(每个小需求都需要封装成方法，并且使用重载方法)
1. 求两个数据之和(写两个方法，一个求两个整数之和，一个求两个小数之和)
2. 判断两个数据是否相等(写两个重载方法，一个判断两个整数是否相等，一个判断两个小数是否相等)
3. 获取两个数中较大的值(写两个重载方法，一个求两个整数中的较大值，一个求两个小数的较大值)
4. 获取两个数中较小的值(写两个重载方法，一个求两个整数中的较小值，一个求两个小数的较小值)
5. 否能用一个方法实现3和4的两个功能
```java
public class Test1{
    public static void sum1(int a,int b){
        int sum = a + b;
        System.out.println(sum);
    }
    public static void sum2(double a,double b){
        double sum = a + b;
        System.out.println(sum);
    }


    public static void uequals(int a,int b){
        boolean sum = a == b;
        System.out.println(sum);
    }
    public static void uequals(double a,double b){
        boolean sum = a == b;
        System.out.println(sum);
    }

    public static void big(int a,int b){
        int sum = 0;
        if(a>b){
            sum = a;
        }else{
            sum = b;
        }
        System.out.println(sum);
    }
    public static void big(double a,double b){
        double sum = 0;
        if(a>b){
            sum = a;
        }else{
            sum = b;
        }
        System.out.println(sum);
    }


    public static void small(int a,int b){
        int sum = 0;
        if(a>b){
            sum = b;
        }else{
            sum = a;
        }
        System.out.println(sum);
    }
    public static void small(double a,double b){
        double sum = 0;
        if(a>b){
            sum = b;
        }else{
            sum = a;
        }
        System.out.println(sum);
    }

    public static void zonghe(double a,double b,boolean c){
        double sum = 0;
        if(c){
            if(a>b){
                sum = a;
            }else{
                sum = b;
            }
            System.out.println("最大值" + sum);
        }else{
            if(a>b){
                sum = b;
            }else{
                sum = a;
            }
            System.out.println("最小值" + sum);
        }
    }
    public static void main(String[] args){
        sum(1,2);
    }
}
```
### 第2题：分析以下需求，并用代码实现
1. 键盘录入长方形的长和宽
    定义方法计算该长方形的周长,并在main方法中打印周长
2. 键盘录入长方形的长和宽
    定义方法计算该长方形的面积,并在main方法中打印面积
3. 键盘录入圆的半径
    定义方法计算该圆的周长,并在main方法中打印周长
4. 键盘录入圆的半径
    定义方法计算该圆的面积,并在main方法中打印面积
```java
public class Test2{
    public static double sum1(double a,double b){
        double count = 2 * (a + b);
        return count;
    }
    public static double sum2(double a,double b){
        double count = a * b;
        return count;
    }
    public static double sum3(double r){
        double count =2 * 3.14 * r;
        return count;
    }
    public static double sum4(double r){
        double count = 3.14 * r * r;
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double r = sc.nextDouble();
    }
}
```
### 第3题:	分析以下需求，并用代码实现
1. 键盘录入一个整数(正数或者负数都可以,但是符号位不算有效的数字位)
2. 定义一个方法,该方法的功能是计算该数字是几位数字,并将位数返回
3. 在main方法中打印该数字是几位数
4. 演示格式如下:
    (1)演示一:
        请输入一个整数:1234
        控制台输出:1234是4位数字
    (2)演示二:
        请输入一个整数:-34567
        控制台输出:-34567是5位数字
```java
public class Test3{
    public static int output(int a){
        int count = 0;
        while(a != 0){
            a /= 10;
            count++;
        }
        return count;
    }
    public static void main(String[]args){
        System.out.print("请输入一个整数:")
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(output("控制台输出"+ a + "是" + output() + "位数字"));
    }
}
```

	






