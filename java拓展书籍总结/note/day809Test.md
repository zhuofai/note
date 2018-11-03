# day809Test

## 46、【代码题】

1. 定义一个无返回值的方法，传入一个int类型数组，求出该数组中的最大值、最小值和平均值并输出.
2. 在main方法中定义一个int类型的数组{ 8, 3, 6, 9, 14 }，调用上述方法进行测试。

```java
public class Test{
    public void out(int[] arr){
        int small = arr[0];
        int big = arr[0];
        int sum = 0;
        int average = 0;
        for(int i = 0;i < arr.length; i++){
            if(small > arr[i]){
                small = arr[i];
            }
            if(big < arr[i]){
                big = arr[i];
            }
            sum += arr[i];
        }
        average = sum / arr.length;
        System.out.println("该数组的最小值为" + small + "最大值为: " + big + "平均值为: " + average);
    }
    public static void main(String[] args){
        int[] arr = {8,3,6,9,14};
        out(arr);
    }
}
```

## 47、

1. 在ArrayList集合中存4个元素，分别“java”“php”“android”php”，请遍历集合，并把值为“php”的元素删除。

```java
public class Test{
    public static void remove1(ArrayList<String> arr){
        for(int i = 0;i < arr.size();i++){
            if(arr[i] == "php"){
                arr.remove(i);
                i--;
            }
        }
    }
    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<Stirng>("java","php","android","php");
        remove1(arr);
    }
}
```

## 48、

1. 定义Student标准类，创建3个学生对象，请把这个3个学生对象存储到数组中，并使用for循环遍历数组，获取得到每一个学生的姓名和年龄打印输出。

```java
public class Student{
    private int age;
    private String name;
    public Student(int age,String name){
        this.age = age;
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public String name(){
        return name;
    }
    pulic void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
}
public class Test{
    public static void main(String[] args){
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student(21,"Lee"));
        arr.add(new Student(22,"Fu"));
        arr.add(new Student(23,"zhu"));
        for(int i = 0; i < arr.size();i++){
            System.out.println(arr.get(i).getAge() + arr.get(i).getNmae());
        }
    }
}


```

## 49、

1. 定义User类，包含属性：name: String类型     age: int类型
2. 创建一个ArrayList集合对象list，集合内元素类型为User，实例化3个User对象，3个对象的属性分别为：”张三” 20， ”李四” 30，”王五” 40，将3个对象添加到list集合中，并使用for循环遍历集合，将集合中age属性大于30的元素属性在控制台打印出来。

```java
public class User{
    private String name;
    private int age;
    public User(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
}
public class Test{
    public static void main(String[] args){
        ArrayList<User> arr = new ArrayList<>();
        arr.add(new User("张三", 20));
        arr.add(new User("李四", 30));
        arr.add(new User("王五", 40));
        for(int i = 0; i < arr.size();i++){
            System.out.println(arr.get(i).getAge() + arr.get(i).getNmae());
        }
    }
}
```

## 50、

1. 定义"学员"类Stu,类中包含以下成员:成员属性: snum (学号)：int类型, score(成绩):double类型，属性使用private修饰为所有属性提供set/get方法。
2. 定义类：Test01,类中定义main()方法，依次完成以下要求:
    * 实例化3个Stu对象，3个对象的属性分别为：9001, 55.0、9002, 66.6、9003, 77.0
    * 创建一个ArrayList集合，分别将上面的3个Stu对象添加到集合中
    * 遍历集合，删除集合中元素的学号为9002的元素，并打印集合中剩余元素的学号和成绩

```java
public class Stu{
    private int snum;
    private double score;
    public Stu(int snum , double socre){
        this.snum = snum;
        this.score = score;
    }
    public int getSnum(){
        return snum;
    }
    public double getScore(){
        return Score;
    }
    public void setSnum(int snum){
        this.snum = snum;
    }
    public void setScore(double score){
        this.score  = score;
    }
}
public class Test{
    public static void main(String[] args){
        ArrayList<Stu> list = new ArrayList<Stu>();
        list.add(new Stu(9001,55.0));
        list.add(new Stu(9002,66.6));
        list.add(new Stu(9003,77.0));
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i).getSnum() + list.get(i).getScore());
        }
    }
}
```

## 51、

1. 定义"军人"类,Soldier,包含以下成员:成员属性: name (姓名)：String类型；age (年龄):int类型, like (爱好):String类型，属性使用private修饰。成员方法:
    * get/set方法
    * show()方法,打印对象所有属性的值;
2. 定义类：Test,类中定义main()方法，按以下要求编写代码:
    * 分别实例化三个Soldier对象，三个对象分别为："王小兵" ,25,”打篮球”、"李团长" ,35,”游泳”、"王军长" ,55,”踢足球”;
    * 创建一个ArrayList集合，这个集合里面存储的是Solider类型，分别将上面的三个Solider对象添加到集合中
3. 遍历这个集合，在遍历的过程中，如果这个集合里面中有对象的年龄大于40，那么将集合中这个对象的爱好改成”打高尔夫”，然后调用这个对象的show方法展示这个对象所有的属性信息

```java
public class Soldier{
    private String name;
    private int age;
    private String like;
    public Soldier(String name,int age,String like){
        this.name = name;
        this.age = age;
        this.like = like;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getLike(){
        return like;
    }
    public void setLike(String like){
        this.like = like;
    }
    public void show(){
        System.out.prinln(name + age + like);
    }
}
public class Test{
    public static void main(String[] args){
        Solider sol1 = new Solider("王小兵" ,25,"打篮球");
        Solider sol2 = new Solider("李团长" ,35,"游泳");
        Solider sol3 = new Solider("王军长" ,55,"踢足球");
        ArrayList<Solider> list = new ArrayList<>();
        list.add(sol1);
        list.add(sol2);
        list.add(sol3);
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getAge() > 40)
            {
                list.get(i).setLike("高尔夫");
            }
        }
        for(int i = 0;i < list.size();i++){
             list.get(i).show();
        }
    }
}
```

## 52、

1. 定义"学员"类Stu,类中包含以下成员:成员属性: name(姓名)：String类型, age(年龄):int类型,属性使用private修饰,为所有属性提供set/get方法
2. 定义类：Test,类中定义main()方法，依次完成以下要求:
    * 实例化2个Stu对象stu1和stu2，2个对象的属性分别为：”Jack”, 27、”Tom”,31
    * 创建一个ArrayList集合，分别将上面的2个Stu对象添加到集合中
    * 实例化1个Stu对象stu3，对应的属性为：”Rose”, 29
    * 将stu3替换集合中年龄属性大于stu3年龄的元素，全部替换完后，并将集合中所有元素在控制台打印输出

演示格式如下：

```java
public class Stu{
    private String name;
    private int age;
    public Stu(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
}
public class Test{
    public static void main(String[] args){
        Stu stu1 = new Stu("Jack",27);
        Stu stu2 = new Stu("Tom",31);
        Stu stu3 = new Str("Rose",29);
        ArrayList<Stu> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getAge() > stu3.getAge()){
                list.set(i,stu3);
            }
        }
        for(int i = 0;i < list.size();i++){
            System.out.println(list.getName()+list.getAge());
        }
    }
}
```

## 53、完成以下需求：

1. 定义“学生类”Student，包含以下内容：
    * 空参构造、满参构造
    * 成员变量： 名称name（String类型）
    * 年龄age（int类型）
    * 性别gender（String类型）
    * 生成以上成员变量的set/get方法
2. 定义测试类Test，完成以下要求：
    * 定义public static ArrayList\<Student> filter(ArrayList\<Student> list,String gender) {...}方法:遍历list集合，将list中性别是参数gender的元素存入到另一个ArrayList\<Student> 中并返回
    * 在main方法内完成以下要求:
    * 根据以下内容创建并初始化3个Student对象("张三",17,"男")("李四",18,"女")("王五",17,"男")
    * 创建一个ArrayList\<Student> list，将上面的3个Student对象添加到list中，调用filter方法传入list和”男”，根据返回的list集合输出所有元素信息

示例如下：

```java
public class Student{
    private String name;
    private int age;
    private String gender;
    public Stu(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public vodi setGender(String gender){
        this.gender = gender;
    }
}
public class Test{
    public static ArrayList<Student> filter(ArrayList<Student> list,String gender) {
        ArrayList<Student> list1 = new ArrayList<Student>();
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getGender() == gender){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
    public static void main(String[] args)[
        Student stu1 = new Student("张三",17,"男");
        Student stu2 = new Student("李四",18,"女");
        Student stu2 = new Student("王五",17,"男");
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        ArrayList<Student> list1 =  filter(list,"男");
        for(int i = 0;i < list1.size();i++){
            System.out.println(list1.get(i).getName() + list.get(i).getAge() + list.get(i).getGender());
        }
    ]
}
```

## 54、

1. 定义“电脑类”Computer包含空参构造、满参构造和以下成员变量：
    * 名称name（String类型）
    * 价格price（ double类型）
    * 类型type（String类型）
    * 生成以上成员变量的set/get方法
2. 定义测试类Test，完成以下要求：
    * 定义public static ArrayList\<Computer> filter(ArrayList\<Computer> list, String str) {....}方法:
    * 要求：遍历集合list，将电脑名称是以参数str结尾的元素存入另一个ArrayList\<Computer> 中并返回
    * 在main方法内完成以下要求:
        * 根据以下内容创建并初始化3个Computer对象("DELL",6799,"一体机")("MacAir", 7488,"颜值担当")("MIAir",4288,"轻薄笔记本")
        * 创建一个ArrayList\<Computer> list_cp，将上面的3个Computer对象添加到 list_cp中，调用filter方法传入list_cp和“Air”，根据返回的list集合输出电脑名称以“Air”结尾的所有元素信息
        示例如下：

```java
public class Computer{
    private String name;
    private double price;
    private String type;
    public Computer(String name,double price,String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }
    public void setNmae(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
public class Test{
    public static ArrayList<Computer> filter(ArrayList<Computer> list, String str) {
        ArrayList<Computer> list1 = new ArrayList<Computer>();
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getName().endsWith(str)){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
    public static void main(String[] args){
        Computer com1 = new Computer("DELL",6799,"一体机");
        Computer com2 = new Computer("MacAir", 7488,"颜值担当");
        Computer com3 = new Computer("MIAir",4288,"轻薄笔记本");
        ArrayList<Computer> list = new ArrayList<Computer>();
        list.add(com1);
        list.add(com2);
        list.add(com3);
        ArrayList<Computer> list1 = new ArrayList<Computer>();
        list1 = filter(list,"Air");
        for(int i = 0;i < list1.size();i++){
            System.out.println(list1.get(i).getName() + list1.get(i).getPrice() + list1.get(i).getType());
        }
    }
}
```

## 55、

1. 定义长度为10的数组，给数组每一个元素赋值，值是1-20的随机数。要求不能重复。接下来定义两个新数组，要求使用新数组1只装原数组中的奇数，要求新数组2只装原数组中的偶数。预习第8天内容，完成以下题目（预习题目不会做没关系，课程讲完再做）：字符串常用方法：

```java
public class Test{
    public static void main(String [] args){
        Random rand = new Random(47);
        byte[] arr = new byte[10];
        ArrayList<Integer> s = new ArrayList<Integer>();
        while(i < arr.length){
             int a = rand.nextInt();
            if(!s.contains(a)){
                s.add(a);
                arr[i] = (byte)a;
                i++;
            }
        }
        int ji = 0;
        int ou = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i]%2==0){
                ou++;
            }
            else{
                ji++;
            }
        }
        byte[] arr1 = new byte[ou];
        byte[] arr2 = new byte[ji];
        ji = 0;
        ou = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i]%2==0){
                arr1[ou] = arr[i];
                ou++;
            }
            else{
                arr2[ji] = arr[i];
                ji++;
            }
        }
        for (int j = 0; j < arr1.length; j++) {
            System.out.print(arr1[j]);
        }
        System.out.println();
        for (int j = 0; j < arr2.length; j++) {
            System.out.print(arr2[j]);
        }

    }
}
```

56、创建一个长度为3的字符串数组，数组内依次存储字符串：”it”、”hei”、”ma”。分别用while循环和for循环遍历数组并将数组中的元素打印在控制台上。

```java
public class Test{
    public static void main(String[] args){
        String[] str = {"it","hei","ma"};
        for(int i = 0;i < str.length;i++){
            System.out.println(str[i]);
        }
        int n = 0;
        while(n < str.length){
            System.out.println(str[n]);
            n++;
        }
    }
}
```

57、声明长度为3的字符串数组，分别为数组元素赋值，遍历数组，将数组中的每个小字符串拼接成一个大字符串，最终打印输出大字符串。

```java
public class Test{
    public static void main(String[] args){
        String[] str = new String[3];
        for(int i = 0;i < str.length;i++){
            str[i] = "123";
        }
        String str1= "";
        for(int i = 0;i < str.length;i++){
            str1+=str[i];
        }
        System.out.println(str1);
    }
}
```

58、在控制台输入一个帐号(String类型),密码(int类型),然后判断输入的帐号是否是Itcast,密码是否是1010，如果是则打印登录成功，不是则打印登录失败。

```java
public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String account = sc.next();
        int password = sc.nextInt();
        if(account.equals("Itcast")){
            if(password == 1010){
                System.out.println("登陆成功");
            }
        }
        else{
            System.out.println("登录失败");
        }
    }
}
```

59、定义一个方法getString，该方法可以接收一个char类型的数组，在方法内，遍历出数组的每一个元素，拼接成一个字符串，并返回。在main方法中，声明数组，调用getString方法，并打印出返回值。

```java
public class Test{
    public static String getString(char[] arr){
        String str = "";
        for(int i = 0;i < arr.length;i++){
            str += arr[i];
        }
        return str;
    }
    public static void main(String[] args){
        char[] arr = {'a','b','c','d'};
        String str = getString(arr);
        System.out.println(str);
    }
}
```

60、“不准使用字符串的toCharArray()方法”！！！自定义一个方法getCharArray，该方法可以将字符串转变成字符数组，并返回。在main方法中，从控制台录入一个字符串，调用getCharArray方法，并遍历打印输出返回的数组。

```java
public class Test{
    public static char[] getCharArray(String str){
        char[] arr = new char[str.length()];
        for(int i = 0;i < str.lengt();i++){
            arr[i] = str.charAt(i);
        }
        return arr;
    }
    public static void main(String[] args){
        String str = "Hello";
        char[] arr = getCharArray(str);
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
```