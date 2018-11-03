# day05练习

## 笔记

动态初始化
数据类型[] 数组名 = new 数据类型[长度];  
数据类型:--->决定了数组能够存放什么样的数据  
[] :---->代表是一个数组  
数组名 :--->为数组起的名字,为了找到数组  
new:---> 向堆内存申请空间的关键字  
长度: --->数组中能够存放多少个数据  

特点:
我们程序员给定长度,由系统给定默认值!!!  
2. 静态初始化:  
完整的格式:  
数据类型[] 数组名 = new 数据类型[不能写长度!!!!]{元素1,元素2...};  
省略的格式:  
数据类型[] 数组名 = {元素1,元素2...};  
3. 内存划分  
    1.栈  
        作用:  
        1.存放局部变量 ----> 定义在方法里面,或者方法声明上(参数列表)的变量都是局部变量
    2. 所有的方法都在栈里面运行
    3. 堆:
    作用:
    存放new出来的东西
    特点:
1.都有地址值
2.都有默认值
整数: 0
小数:0.0
字符:'\u0000'
布尔:false
引用数据类型:null
3.方法区
作用:
1.存放字节码对象.class相关的信息
2.存放静态相关的东西static
4.本地方法栈 ---->系统相同
5.寄存器 --->cpu

5.获取数组的长度
格式:数组名.length

## 第一题：练习今日的代码

## 第二题：分析以下需求并实现

1. 看程序说结果，请不要提前运行

```java
public class Test03_01 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] temp1 = arr1;
        int[] temp2 = arr1;
        System.out.println("通过temp1取出数组值: ");
        for(int i = 0;i<temp1.length;i++) {
            System.out.print(temp1[i]+" ");
        }
        System.out.println();
        System.out.println("通过temp2取出数组值: ");
        for(int i = 0;i<temp2.length;i++) {
            System.out.print(temp2[i]+" ");
        }
        System.out.println();
        temp1[2] = 9;
        System.out.println("通过temp1取出数组值: ");
        for(int i = 0;i<temp1.length;i++) {
            System.out.print(temp1[i]+" ");
        }
        System.out.println();
        System.out.println("通过temp2取出数组值: ");
        for(int i = 0;i<temp2.length;i++) {
            System.out.print(temp2[i]+" ");
        }
        System.out.println();
    }
}/*out~
通过temp1取出数组值:
1 2 3 4 5
通过temp2取出数组值:
1 2 3 4 5
通过temp1取出数组值:
1 2 9 4 5
通过temp2取出数组值:
1 2 9 4 5
*/
```

## 三题：分析以下需求并实现

1. 看程序说结果，请不要提前运行

```java
public class Test03_02 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,6,7};
        int[] temp = arr1;
        System.out.println("通过temp取出arr1中的元素: ");
        for(int i = 0;i<temp.length;i++) {
            System.out.print(temp[i]+" ");
        }
        temp = arr2;
        System.out.println("通过temp取出arr2中的元素: ");
        for(int i = 0;i<temp.length;i++) {
            System.out.print(temp[i]+" ");
        }
    }
}/*out:
通过temp取出arr1中的元素:
1 2 3 4 5
通过temp取出arr2中的元素:
5 6 7
*/
```

## 第四题：分析以下需求并实现

1. 定义一个用于存放班级分数的数组
    int[] score = {80,90,85,90,78,88,89,93,98,75};
2. 求出班级不及格人数(分数低于60分的就是不及格)
3. 求出班级的平均分
4. 求出班级的总分数

```java
public class Test4{
    public static void out(int[] arr){
        int count = 0;
        int sum = 0;
        int average = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] < 60)
                count++;
            sum += arr[i];
        }
        average = sum / arr.length;
        System.out.println("班级不及格人数为" + count);
        System.out.println("班级平均分为: " + average);
        System.out.println("班级总分数为: " + sum);
    }
    public static void main(String[] args){
        int[] score = {80,90,85,90,78,88,89,93,98,75};
        out(score);
    }
}
```

```java
public class Test{
    public static void main(String[] args){
        int[] arr = {3,5,1,2,5,6,10};
        int small = 0;
        int big = 0;
        int temp = arr[0];
        int btemp = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(temp >= arr[i]){
                temp = arr[i];
                small = i;
            }
            if(btemp <= arr[i]){
                btemp = arr[i];
                big = i;
            }
        }
        arr[small] = btemp;
        arr[big] = temp;
    }
}
```