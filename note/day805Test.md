# day805Test习题

## 30

1. 定义一个int类型的数组，内容为{6,2,9,15,1,5,20,7,18}，可通过键盘录入  
2. 将数组最大元素与最后一位元素进行交换，最小元素与第一位元素进行交换  
3. 遍历打印数组

```java
public class Test{
    public static void out(int[] arr){
         for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void change(int[] arr){
        int small = 0;
        int big = 0;
        int temp = arr[0];
        int temp1 = arr[1];
        for(int i = 1;i < arr.length;i++){
            if(temp >= arr[i]){
                temp = arr[i];
                small = i;
            }
            if(temp1 <= arr[i]){
                temp1 = arr[i]
                big = i;
            }
        }
        arr[big] = temp;
        arr[small] = temp1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new arr[9];
        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        change(arr);
        out(arr);
    }
}
```

## 31

1. 定义方法public static int getAvg(int[] arr)，获取数组中的平均数并返回
2. 在main方法内，定义数组{95, 92, 75, 56, 98, 71, 80, 58, 91, 91}，并调用getAvg方法获取平均分。然后遍历数组，统计高于平均分的分数有多少个。打印结果：高于平均分：80 的个数有 5 个。

```java
public class Test{
    public static int getAvg(int[] arr){
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];
        }
        int average = sum/arr.length;
        return average;
    }
    public static void main(String[] args){
        int[] arr = {95, 92, 75, 56, 98, 71, 80, 58, 91, 91};
        int average = getAvg(arr);
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > average){
                count++;
            }
        }
        System.out.println("高于平均分的有" + count + "个");
    }
}
```

## 32

1. 定义方法public static boolean isSXH(int num)，功能:判断数字num是否是水仙花数,如果是返回true,如果不是返回false。
2. 定义方法public static int getCount(),功能：借助isSXH方法，获取100到999以内水仙花个数，
3. 定义方法public static int[] getArr(int count)，根据参数创建int数组，获取100到999以内水仙花数，存入到数组并返回。
4. 在main方法中调用getArr方法，获取返回值，并遍历打印数组。

```java
public class Test{
    public static boolean isSXH(int num){
        int gewei = num % 10;
        int shiwei = num / 10 % 10;
        int qianwei = num / 100 % 10;
        int sum = gewei * gewei * gewei + shiwei * shiwei * shiwei + qianwei * qianwei * qianwei;
        if(sum == num){
            return true;
        }
        else{
            return false;
        }
    }
    public static int getCount(){
        int count = 0;
        for(int i = 100;i <= 999;i++){
            if(isSXH(i)){
                count++;
            }
        }
        return count;
    }
    public static int[] getArr(int count){
        int[] arr = new int[count];
        int n = 0;
        for(int i = 100;i <= 999;i++){
            if(isSXH(i)){
                arr[n] = i;
                n++;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = getArr(getCount());
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
```

## 33、

1. 定义方法public static boolean isSym(int[] arr)，判断数组中的元素值是否对称,对称返回true，不对称返回false；在main方法中，定义一个数组，并调用方法。
2. 打印结果：[1,2,3,4,3,2,1]是否对称：true

```java
public class Test{
    public static boolean isSym(int[] arr){
        boolean temp = false;
        if(arr.lengt % 2 == 0){
            for(int i = 0;i < arr.length/2;i++){
                if(arr[i] == arr[arr.length/2 + i]){
                    temp = true;
                }
                else{
                    temp = false;
                    break;
                }
            }
        }else{
             for(int i = 0;i < arr.length/2;i++){
                if(arr[i] == arr[arr.length/2 + i + 1]){
                    temp = true;
                }
                else{
                    temp = false;
                    break;
                }
            }
        }
        return temp;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,3,2,1};
        boolean t = isSym(arr);
        System.out.println(Arrays.toString(arr) + ": " + t);
    }
}
```

## 34、

1. 定义方法public static boolean equals(int[] arr1,int[] arr2)，比较两数组内容是否完全相同，相同返回true，不相同返回false。在main方法中，定义两个数组并调用方法比较两数组是否相同。打印结果：[11,22,33,44]与[11,22,33,44]是否相同：true

```java
public class Test{
    public static boolean wuqals(int[] arr1,int[] arr2){
        return Arrays.equals(arr1,arr2);
    }
    public static void main(String[] args){
        int[] arr1 = {11,22,33,44};
        int[] arr2 = {11,22,33,44};
        boolean w = wuqals(arr1,arr2);
        System.out.println("arr1和arr2" + w);
    }
}
```

## 35、

1. 定义方法public static int getCount(int[] arr,int num)，求出指定元素在数组中出现的次数.
2. 定义方法public static int getAllCount(int[] arr)，统计数组中出现次数为1的元素一共有多少个。(推荐-遍历数组，然后调用第一个方法，求出数组中每个元素在数组中出现的次数，如果只出现了一次，就统计)
3. 在main方法中定义数组，如int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};。然后调用getAllCount方法，统计只出现一次的元素有多少个。
4. 打印结果：数组中只出现一次的元素有2个

```java
public class Test{
    public static int getCount(int[] arr,int num){
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == num){
                count++;
            }
        }
        return count;
    }
    public static int getAllCount(int[] arr){
        int count = 0;
         for(int i = 0;i < arr.length;i++){
            if(1 == getCount(arr,arr[i])){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        System.out.println("数组中只出现一次的元素有"+getAllCount(arr)+"个");
    }
}
```

预习第6天内容，完成以下题目（预习题目不会做没关系，课程讲完再做）：

## 36、

1. 定义一个汽车类Car。汽车有颜色 String color,有轮子 int wheel。能在路上跑run(),能收听广播 listenRadio(),有有参构造,有无参构造,成员变量私有,有get,set方法。在测试类中分别使用无参构造和有参构造创建汽车对象并赋值，然后输出颜色和轮子，调用跑和收听广播的方法。

```java
public class Car{
    private String color;
    private int wheel;
    public void run(){
        System.out.println("I'm run()");
    }
    public void listenRadio(){
        System.out.println("I'm listenRadio()");
    }
    public Car(){}
    public Car(String color,int wheel){
        this.color = color;
        this.wheel = wheel;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getWheel(){
        return this.wheel;
    }
    public void setWheel(int wheel){
        this.wheel = wheel;
    }
}
public class Test{
    public static void main(String[] args){
        Car car = new Car();
        car.run();
        car.listenRadio();
        System.out.println( car.getCar());
        System.out.println( car.getWheel());


        Car car = new Car("red",4);
        car.run();
        car.listenRadio();
        System.out.println( car.getCar());
        System.out.println( car.getWheel());
    }
}
```

## 第1题

1. 定义一个int类型的一维数组，内容为{171,72,19,16,118,51,210,7,18}
2. 求出该数组中满足要求的元素和。要求：求和的元素的个位和十位不能包含7,并且只能为偶数。

```java
public class Test{
    public static int sum(int[] arr){
        int gewei = 0;
        int shiwei = 0;
        int s = 0;
        for(int i = 0;i < arr.length;i++){
            gewei = arr[i]%10;
            shiwei = ar[i]/10%10;
            if((arr[i]%2==0)&&(7 != gewei )&& (7 != shiwei)){
                s += arr[i];
            }
        }
        return s;
    }
    public static void main(String[] args){
        int[] arr = {171,72,19,16,118,51,210,7,18};
        System.out.println("满足要求的元素和为" + sum(arr));
    }
}
```

## 第2题

> 需求：数组元素查找(查找指定元素第一次在数组中出现的索引)
1. 给定数组int[] arr = {1,7,3,2,7,5};
2. 通过键盘录入一个整数，赋值给变量x
3. 定义一个方法，public static int getIndex(int[] arr,int num){...},
4. 在方法内部求arr中第一次出现num的位置，并将索引返回
5. 结果：请输入一个整数：7   数字 7 在数组中第一次出现的索引位置为 1

```java
public class Test{
    public static int getIndex(int[] arr,int num){
        int a = -1;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == num){
                a = i;
                break;
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] arr = {1,7,3,2,7,5};
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int a = getIndex(arr,x);
        if(a != -1){
            System.out.println("数字" + x + "在数组中第一次出现的索引位置为" + a);
        }
        else{
            System.out.println("数组中没有该元素");
        }
    }
}
```

## 第3题

1. 需求：定义一个变量,要求数据是四位的整数,现需要对数据进行加密,加密规则如下:
2. 每位数字都加上5,然后除以10的余数代替该数字,
3. 再将第一位和第四位交换,第二位和第三位交换,请把加密后的数据输出到控制台

```java
public class Test{
    public static void secreat(int[] arr){
        if(arr.length != 4){
            System.out.println("数据错误");
        }
        else{
            for(int i = 0;i < arr.length;i++){
                arr[i] += 5;
                arr[i] %= 10;
            }
            int temp = arr[0];
            arr[0] = arr[3];
            arr[3] = temp;
            temp = arr[1];
            arr[1] = arr[2];
            arr[2] = temp;
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i = 0 ;i < 4;i++){
            arr[i] = sc.nextInt();
        }
        secreate(arr);
         for(int i = 0 ;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
```

## 第4题

1. 需求：在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100的整数分(通过键盘录入)。
2. 选手的最后得分为：去掉一个最高分和一个最低分后 的4个评委平均值。请写代码实现。(不考虑小数部分)

```java
public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new arr[6];
        for(int i = 0;i < 6;i++){
            arr[i] = sc.nextInt();
            while(arr[i] < 0 || arr[i] > 100){
                System.out.println("输入错误请重新输入");
                arr[i] = sc.nextInt();
            }
        }
        int big = arr[0];
        int small = arr[0];
        int sum = 0;
        for(int i = 1;i < arr.length){
            if(big < arr[i]){
                big = arr[i];
            }
            if(small > arr[i]){
                small = arr[i];
            }
            sum += arr[i];
        }
        int average  = sum / 4;
        System.out.println("该选手最后得分为" + average);
    }
}
```