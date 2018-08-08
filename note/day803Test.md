23. 定义一个方法，该方法可以求出1到100之间所有偶数之和，并将和返回。在main方法中调用该方法，并在控制台打印出结果。
```java
public class Test{
    public static int sum(){
        int sum = 0;
        for(int i = 1;i <= 100; i++){
            if(i%2 == 0){
                sum += i;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(sum());
    }
}
```
24. 定义一个方法fun1，该方法可以求出1到100之间所有奇数的个数，并将个数返回。定义一个方法fun2,可以接收一个整数x，在方法内循环打印出1到x之间所有的偶数。在main方法中调用fun1()，得到结果，赋值给一个变量int count，继续调用fun2(),将count作为参数进行传递。
```java
public class Test{
    public static int fun1(){
        int count = 0;
        for(int i = 1;i <= 100; i++){
            if(i%2 != 0){
                sum ++;
            }
        }
        return count;
    }
     public static void fun2(int x){
        int count = 0;
        for(int i = 1;i <= x; i++){
            if(i%2 == 0){
                System.out.println(i + " ");
            }
        }
    }
    public static void main(String[] args){
        int count = fun1();
        fun2(count);
    }
}
```
25. a、定义方法public static boolean isSXH(int num)，功能:判断数字num是否是水仙花数,如果是返回true,如果不是返回false。在main方法中调用该方法，传入数字157，打印结果。(所谓的水仙花数是指一个三位数，其各位数字的立方和等于该数本身。)
b、求出100到999之间所有的水仙花数字（可以借助上一步中的方法进行判断），并每2个一行打印到控制台。最后打印出水仙花的总个数。 
预习第5天内容，完成以下题目（预习题目不会做没关系，课程讲完再做）：
```java
public class Test{
    public static boolean isSXH(int num){
        if(num>=100&&num<999){
            int gewei = num % 10;
            int shiwei = num/10%10;
            int qianwei = num/100%10;
            int sum = gewei*gewei*gewei + shiwei * shiwei * shiwei + qianwei* qianwei * qianwei;
            if(sum == num){
                return true;
            }else{
                return false;
            }
        }
        else{
            return false;
        }
        
    }
    public static void out(){
        int count = 0;
        for(int i = 100; i <= 999;i++){
            if(isSXH(i)){
                count++;
                System.out.println(i);
                if(count % 2 == 0){
                    System.out.println();
                }
            }
        }
        System.out.println("水仙花总个数为" + count);
    }
    public static void main(String[] args){
        out();
    }
}
```
26. 在main方法中，定义一个长度为5的int类型数组
(1)	通过键盘输入整数，为数组赋值
(2)	打印输出数组的长度
(3)	遍历输出每个元素
(4)	求出元素值为偶数的个数。
(5)	求出元素值为奇数的元素之和。
```java
public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[5];
        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("数组长度为"+arr.length);
        int count = 0;
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
            if(arr[i]%2 == 0){
                count ++;
            }
        }
        int jishu = arr.length - count;
        System.out.println("奇数有"+ jishu + "偶数为" + count);
    }
}
```
27. 求出数组{4,8,2,9}的最大值和最小值。
```java
public class Test{
    public static void main(String[] args){
        int[] arr = {4,8,2,9};
        int big = arr[0];
        int small = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(big >= arr[i]){
                big = big
            }else{
                big = arr[i];
            }
            if(small <= arr[i]){
                small = small;
            }else{
                small = arr[i];
            }
        }
        System.out.println("最大值为" + big + "最小值为" + small);
    }
}
```
28. 定义一个方法，功能是接收3个整数，然后将这三个整数存到数组中，最终把数组返回。在main方法中调用该方法，并声明数组变量用来接收方法的返回值，打印遍历数组。
```java
public class Test{
    public static int[] out(int a, int b ,int c){
        int[] arr = {a,b,c};
        return arr;
    }
    public static void main(String[] args){
        int[] arr = out(1,2,3);
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
```
29. 定义一个方法，接收一个int数组，返回一个int数组。在方法内新建一个数组，将传进来的数组中的元素装进去，但是要求奇数在左边偶数在右边。最后返回这个新数组。在main方法中调用该方法，获取返回值，并遍历输出数组元素
```java
public class Test{
    public static int[] out(int arr[]){
        int[] arr1 = new int[arr.length];
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i]%2 != 0){
                arr1[count++] = arr[i];
            }
        }
        for(int i = 0;i < arr.length;i++){
            if(arr[i]%2 == 0){
                arr1[count++] = arr[i];
            }
        }
        return arr1;
    }
    public static void main(String[]args){
        int[] arr= {1,2,3,4};
        int[] arr1 = out(arr);
        for(int i = 0;i < arr1.length;i++){
            System.out.println(arr1[i]);
        }
    }
}
```