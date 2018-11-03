### 第一题：练习今日的代码

### 第二题：分析以下需求并实现
1. 功能描述:给定月份，输出对应的季节
2. 要求:
(1)定义一个月份，例如：int month = 5;
(2)输出该月份对应的季节
    3,4,5春季
    6,7,8夏季
    9,10,11秋季
    12,1,2冬季
(3)演示格式如下:
    定义的月份:5
    控制台输出:5月份是春季
```java
public class Test2{
    public static void main(String[] args){
        Scnner sc = new Scnner(System.in);
        int season = sc.nextInt();
        switch(season){
            case 3:
            case 4:
            case 5:
                System.out.println(season + "月份是春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(season + "月份是夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(season + "月份是秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println(season +"月份是冬天");
                break;
            default:
                System.out.println(season + "沒有這個月份");
                break;
        }
    }
}
```

### 第三题：分析以下需求并实现
1. 打印1到100之内的整数，但数字中包含9的要跳过
2. 每行输出5个满足条件的数，之间用空格分隔
3. 如：1 2 3 4 5 
```java
public class Test3{
    public static void test1(){
        int count = 0;
        for(int i = 1;i <= 100;i++){
            int ge = i % 10;
            int shi = i / 10 % 10;
            if((ge == 9) || (shi == 9)){
                continue;
            }
            count ++;
            if(count % 5 == 0){
                System.out.println()
            }
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args){
        test1();
    }
}
```
### 第四题：分析以下需求并实现
```java
public class Test11 {
    public static void main(String[] args) {
        for(int x=1; x<=10; x++) {
            if(x%3==0) {
                //()在此处填写代码
                break;//1
                continue;//2
                System.out.println("Java基礎班");//3
            }
            System.out.println("Java基础班");
        }
    }
}
```
问题:
1. 想在控制台输出2次:"Java基础班"   括号()里面应该填写什么?
2. 想在控制台输出7次:"Java基础班"   括号()里面应该填写什么?
3. 想在控制台输出13次:"Java基础班"   括号()里面应该填写什么?

### 第五题：分析以下需求并实现
1. 使用嵌套循环完成99乘法表的打印
    1*1=1
    1*2=2	2*2=4
    1*3=3	2*3=6	3*3=9
    ...
```java
public class Test5{
    public static void test(){
        for(int i = 1;i < 10;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(j + "*" + i + "=" +  i * j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        test();
    }
}
```
