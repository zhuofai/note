12. 将1到100之间不能被3整除的数字累加求和并打印结果。求出1到5之间所有整数之和并打印结果。求出1到5之间所有奇数之和并打印结果。求出1到5之间所有偶数的个数并打印结果。

```java
public class Test12{
    public static void sum1(){
        int temp = 0;
        for(int i = 1;i <= 100 ;i++){
            if(i%3 != 0){
                temp += i;
            }
        }
        System.out.println("结果为" + temp);
    }
     public static void sum2(){
        int temp = 0;
        for(int i = 1;i <= 5 ;i++){
                temp += i;
        }
        System.out.println("结果为" + temp);
    }
     public static void sum3(){
        int temp = 0;
        for(int i = 1;i <= 5 ;i++){
            if(i%2 != 0){
                temp += i;
            }
        }
        System.out.println("结果为" + temp);
    }
     public static void sum4(){
        int temp = 0;
        for(int i = 1;i <= 5 ;i++){
            if(i%2 == 0){
                temp += i;
            }
        }
        System.out.println("结果为" + temp);
    }
    public static void main(String[] args){
        sum1();
        sum2();
        sum3();
        sum4();
    }
}
```
13. 求1~100以内(包含1和100)能同时被3，5整除的数的和，并将求出的和打印到控制台上
```java
public class Test13{
    public static void sum(){
        int temp = 0;
        for(int i = 1;i <= 100;i++){
            if((i%3 == 0)&&(i%5 == 0)){
                temp += i;
            }
        }
        System.out.println("结果为" + temp);
    }
    public static void main(String[] args){
        sum();
    }
}
```
14. 获取1~20之间（包含1和20）个位数为3的倍数的“数字”，并在控制台打印输出所有“数字”和“数字的个数”(本试题中0视为3的倍数)。
PS：不能用主观判断去实现题目，如【if(num == 0 || num == 3 || num == 6 ……)】这样的代码是不符合题目要求的。演示格式如下：
![](./notepicture/day801-TestImg.png)
```java
public class Test14{
    public static void sum(){
        int count = 0;
        System.out.println("1~20之间个位数为3的倍数的数字有");
        for(int i = 1;i <= 20;i++){
            if(i%10%3 == 0){
                System.out.print(i + "  ");
                count ++;
            }
        }
        System.out.println("1~20之间个位数为3的倍数的数字有" + count + "个");
    }
    public static void main(String[] args){
        sum();
    }
}
```
15. 统计并获取10-100之间(包含10和100)个位与十位都为奇数的数字，并将数字和个数都打印到控制台上。
>PS：需要先获取到范围内每个数字个位和十位上的数，在按照条件进行判断。
```java
public class Test15{
    public static void sum(){
        int count = 0;
        System.out.println("10-100之间(包含10和100)个位与十位都为奇数的数字");
        for(int i = 10;i <= 100;i++){
            if((i%10%2 != 0)&&(i/10%10%2 != 0)){
                System.out.print(i + "  ");
                count ++;
            }
        }
        System.out.println("10-100之间(包含10和100)个位与十位都为奇数的数字有" + count + "个");
    }
    public static void main(String[] args){
        sum();
    }
}
```
16. main方法中定义3个变量：int a = 5, b = 3, c = 8;并依次完成以下
1).利用if语句求出a、b、c中最大的数并打印到控制台上；
2).利用三元运算符求出a、b、c中最小的数并打印到控制台上；
预习第4天内容，完成以下题目：
```java
public class Test16{
    public static void main(String[] args){
        int a = 5,b = 3,c = 8;
        int big = a;
        if(b >= big){
            big = b;
        }
        if(c >= big){
            big = c;
        }
        System.out.println("最大的数字为" + big);

        int small = a;
        small = small >= b ? b : small;
        small = small >= c ? c : small;
        System.out.println("最小的数字为" + small);
    }
   
}
```
17. 定义一个方法，功能是计算1到100所有整数和，并打印输出。在main方法中调用该方法。（无参数无返回值）
```java
public class Test17{
    public static void sum(){
        int temp = 0;
        for(int i = 1;i <= 100;i++){
                temp += i;
        }
        System.out.println("结果为" + temp);
    }
    public static void main(String[] args){
        sum();
    }
}
```
18. 定义一个方法printHW，功能是打印100次“hello world”。在main方法中调用printHW方法。（无参数无返回值）
```java
public class Test18{
    public static void printHW(){
        int temp = 0;
        for(int i = 1;i <= 100;i++){
           System.out.println("hello world");
        }
    }
    public static void main(String[] args){
        printHW();
    }
}
```
19. 定义一个方法，它可以统计1到100之间不能被3整除的数字的个数，并把个数返回。在main方法中调用该方法，并打印出结果。（无参数有返回值）
```java
public class Test19{
    public static void sum(){
        int count = 0;
        for(int i = 1;i <= 100;i++){
            if(i%3 != 0){
               count ++;
            }
        }
         System.out.println("1到100之间不能被3整除的数字的个数" + count);
        
    }
    public static void main(String[] args){
        sum();
    }
}
```
20. 定义一个方法,可以接收1个整数n，在方法内循环打印n次“传智播客”。在main方法中调用该方法。（有参数无返回值）
```java
public class Test20{
    public static void sum(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1;i <= n;i++){
            System.out.println("传智播客");
        }
    }
    public static void main(String[] args){
        sum();
    }
}
```
21. 定义一个方法，功能是接收两个整数，并计算两数和，把结果返回。在main方法中调用该方法，并在控制台打印求和的结果。（有参数有返回值）
```java
public class Test21{
    public static int sum(){
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int s = a + b;
       return s;
    }
    public static void main(String[] args){
        System.out.println("和为" + sum());
    }
}
```
22. 定义一个方法，功能是接收3个整数，求出三数中的最大值，并把结果返回。在main方法中调用该方法，并在控制台打印出最大值。（有参数有返回值）
```java
public class Test22{
    public static int sum(){
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int c = sc.nextInt();
       int big = a >= b ? a : b;
       big = big >= c ? big : c;
       return big;
    }
    public static void main(String[] args){
        System.out.println("最大值为" + sum());
    }
}
```
## 附加题
### 第1题：分析以下需求，并用代码实现：
1. 键盘录入一个整数给变量x，输出对应的变量y的值
2. x值和y值的对应关系如下：
    x<0 y=-1
    x=0 y=0
    x>0 y=1
3. 如果用户输入的x的值为2，程序运行后打印格式"x=2,y=1"
```java
public class Test1{
    public static void out(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y;
        if(x<0){
            y = -1;
        }else if(x == 0){
            y = 0;
        }else{
           y = 1;
        }
        System.out.println("x=" + x + "," + "y=" + y);
    }
    public static void main(String[] args){
        out();
    }
}
```

### 第2题：分析以下需求，并用代码实现：
1. 根据工龄(整数)给员工涨工资(整数),工龄和基本工资通过键盘录入
2. 涨工资的条件如下：
    [10-15)     +5000
    [5-10)      +2500
    [3~5)       +1000
    [1~3)       +500
    [0~1)       +200
3. 如果用户输入的工龄为10，基本工资为3000，程序运行后打印格式"您目前工作了10年，基本工资为 3000元, 应涨工资 5000元,涨后工资 8000元"
```java
public class Test2{
    public static void out(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int basic = 3000;
        int temp = 0;
        if(a>=0&&a<1){
            temp = 200;
            System.out.println("您目前工作了"+ a + "年，基本工资为 3000元, 应涨工资"+ temp + "元,涨后工资" +(temp+basic)  +"元");
        }else if(a>=1&&a<3){
             temp = 500;
            System.out.println("您目前工作了"+ a + "年，基本工资为 3000元, 应涨工资"+ temp + "元,涨后工资" +(temp+basic)  +"元");
        }else if(a>=3&&a<5){
             temp = 1000;
            System.out.println("您目前工作了"+ a + "年，基本工资为 3000元, 应涨工资"+ temp + "元,涨后工资" +(temp+basic)  +"元");
        }else if(a>=5&&a<10){
             temp = 2500;
            System.out.println("您目前工作了"+ a + "年，基本工资为 3000元, 应涨工资"+ temp + "元,涨后工资" +(temp+basic)  +"元");
        }else if(a>=10&&a<15){
             temp = 5000;
            System.out.println("您目前工作了"+ a + "年，基本工资为 3000元, 应涨工资"+ temp + "元,涨后工资" +(temp+basic)  +"元");
        }else{
            System.out.println("输入错误请重新输入您的工龄");
        }
    }
    public static void main(String[] args){
        out();
    }
}
```
### 第3题:分析以下需求，并用代码实现：
1. 按照从大到小的顺序输出四位数中的个位+百位=十位+千位(3553,2332,1166,8228,3773)的数字及个数
2. 每行输出5个满足条件的数，之间用空格分隔
3. 如：9999 9988 9977 9966 9955 	
```java
public class Test3{
    public static void out(){
        int count = 0;
        for(int i = 1000;i<= 9999;i++){
            int gewei = i%10;
            int shiwei = i/10%10;
            int baiwei = i/100%10;
            int qianwei = i/1000;
            if((gewei+baiwei)==(shiwei+qianwei)){
                System.out.print(i + " ");
                count ++;
                if(count%5==0){
                    System.out.println();
                }
            }
           
        }
    }
    public static void main(String[] args){
        out();
    }
}
```
### 第4题:分析以下需求，并用代码实现：
1. 键盘录入学生成绩(整数类型),如果录入的成绩为-1表示录入结束
2. 打印输出录入的学生成绩的平均值
```java
public class Test4{
    public static void average(){
        Scanner sc = new Scanner(System.in);
        int aver = 0;
        int count = 0;
        while(true){
            int grade = sc.nextInt();
            if(grade == -1){
                break;
            }
            aver += grade;
            count++;
        }
        if(count == 0){
            System.out.println("未录入成绩");
        }
        else{
            aver = aver / count;
            System.out.println("学生成绩的平均值为" + aver);
        }
       
    }
    public static void main(String[] args){
        average();
    }
}
```

