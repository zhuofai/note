# day813Test

## 70、请完成以下需求：

1. 定义“人类”Person，包含以下内容：
    * 空参构造、满参构造
    * 成员变量：名称name（String类型）
    * 年龄age（int类型）
    * 性别gender（String类型）
    * 生成以上成员变量的set/get方法
2. 定义测试类Test，完成以下要求：
    * 定义public static ArrayList\<Person> filter(ArrayList\<Person> list,String surname) {...}方法:遍历list集合，将list中姓surname的元素存入到另一个ArrayList\<Person> 中并返回
    * 在main方法内完成以下要求:
        * 根据以下内容创建并初始化3个Person对象
            * ("张三",17,"男")
            * ("李四",18,"女")
            * ("张三",17,"女")

3. 创建一个ArrayList\<Person> list，将上面的3个Person对象添加到list中，调用filter方法传入list和”张”，根据返回的list集合输出所有元素信息 示例如下：

```java
public class Person{
    private String name;
    private int age;
    private String gender;
    public Person(){}
    public Person(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
     public void setAge(int age){
        this.age = age;
    }
    public String getAge(){
        return this.age;
    }
     public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
}
public class Test{
    public static ArrayList<Person> filter(ArrayList<Person> list,String surname) {
        ArrayList<Person> list1 = new ArrayList<Person>();
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getName().startWith(surname)){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
    public static void main(String[] args){
        Person p1 = new Person("张三",17,"男");
        Person p2 = new Person("李四",18,"女");
        Person p3 = new Person("张三",17,"女");
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        ArrayList<Person> list1 = filter(list,"张");
         for(int i = 0;i < list1.size();i++){
             System.out.println(list1.get(i).getName + list1.get(i).getage() + list1.get(i).getGender());
        }
    }
}
```

## 71、请完成以下需求：

1. 自行车类:
    * 属性:轮子个数,轮子颜色
    * 行为:跑(输出语句模拟:”蹬着跑”,输出语句中要有自行车的属性)
2. 电动车类:
    * 属性:轮子个数,轮子颜色,电池(boolean类型:true代表有电,false代表没电)
    * 行为:跑(如果电池有电就骑着跑,如果电池没电只能蹬着跑)
    * 注意:骑着跑用输出语句模拟,蹬着跑需要调用自行车类的跑方法
3. 测试类:
    * 创建一个电动车对象,为电动车各项属性赋值,有4只轮子、颜色为黑色、电动车电池有电,调用跑方法
    * 修改电池属性，颜色为白色，,电池没电,再次调用跑方法

```java
public class Cycle{
    private int wheel;
    private String color;
    public Cycle(int wheel,String color){
        this.wheel = wheel;
        this.color = color;
    }
    public int getWheel(){
        return this.wheel;
    }
    public String getColor(){
        return this.color;
    }
    public void setWheel(int wheel){
        this.wheel = wheel;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void run(){
        System.out.println("跑");
    }
}
public class RunCycle extends Cycle{
    public RunCycle(int wheel,String color){
        super(wheel,color);
    }
    public void run(){
        System.out.println("蹬着跑");
    }
}
public class AutoCycle extends RunCycle{
    private boolean dianchi;
    public void setDianchi(boolean dianchi){
        this.dianchi = dianchi;
    }
    public boolean getDianchi (boolean dianchi) {
        return dianchi;
    }
    public AutoCycle(int wheel,String color,boolean dianchi){
        super(wheel,color);
        this.dianchi = dianchi;
    }
    public void run(){
        if(dianchi){
            System.out.println("骑着跑");
        }
        else{
            System.out.println("蹬着跑");
        }
    }
}
public class Test{
    public static void main(String[] args){
        AutoCycle au = new AutoCycle(2,"黑色",true);
        au.run();
        au.setDianchi(false);
        au.setColor("黑色");
        au.run();
    }
}
```

## 72、创建一个歌手类（Singer）：

1. 属性有：姓名（String）、性别（String）、年龄（int）；需要生成对应的set/get方法以及满参构造；
2. 定义一个演唱歌曲的方法，传入一个String类型的参数（歌曲名），输出：“歌手XXX正在演唱XXX歌曲”）
3. 要求：
    * 创建测试类Test：在main方法中创建1个Singer对象，利用满参构造进行赋值。
    * 控制台提示用户依次输入3首歌曲名称（String类型），利用随机函数从3首歌曲名称中随机抽取一首，调用歌手的演唱歌曲方法。示例：

```java
public class Singer{
    private String name;
    private String gender;
    private int age;
     public Singer(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
     public void setAge(int age){
        this.age = age;
    }
    public String getAge(){
        return this.age;
    }
     public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void sing(String ge){
        System.out.println(this.name + "在唱" + ge);
    }
}
public class Test{
    Singer sing = new Singer("张国荣","22","男");
    String[] str = {"无心睡眠","共同度过","蝶变"};
    Random rand = new Random();
    int r = rand.nextInt(3);
    System.out.println(sing.getName + "在唱" + str[r]);
}
```

## 73

1. 现在main方法中有一个数组int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
2. 要求如下：
    * 定义方法，将数组中的0使用1-10之间的随机数替换掉(使用新的随机数替换数组中值为0的元素)，并统计替换了多少个。
    * 调用上面定义的方法，替换掉0并统计结果
    * 对操作后的数组使用任意格式进行遍历，查看结果

```java
public class Test{
    public static void main(String[] args){
        Random rand = new Random();
        int count = 0;
        int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == 0){
                arr[i] = rand.nextInt();
                count ++;
            }
        }
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
```

预习多态内容，完成以下题目：

## 74、请完成以下需求：

* 定创建抽象类Payment，定义返回类型为double的抽象方法pay(double money);
* 创建两个子类AliPay，Cach；均继承自Payment，重写pay方法，根据以下要求返回实际付款金额
* 支付宝支付（AliPay）：打5折
* 现金支付（Cash）：没有任何优惠
* 定义Person类，定义静态方法buy，参数为String类型，返回值为Payment类型，方法中对参数进行判断，如果参数为”al”，则返回AliPay类型对象，如果参数为”ca”，则返回Cash类对象。
* 定义测试类，在main方法中，提示用户输入付款方式和金额，调用Person类的静态方法buy，获取到返回值后,再调用pay方法，输出最后付款钱数。

```java
public abstract class Payment{
    public abstract double pay(double money);

}
public class AliPay extends Payment{
    public double pay(double money){
        double mon = money / 2;
        return mon;
    }
}
public class Cach extends Payment{
    public double pay(double money){
        return money;
    }
}
public class Person{
    public static Payment buy(String str){
        if(str.equals("al")){
            return new AliPay();
        }
        else if(str.equals("ca")){
            return new Cash();
        }
    }
}
public class Test{
    public static void main(String[] args){
        System.out.println("请输入付款方式");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Payment pa = Person.buy(str);
        System.out.println("请输入金额");
        double money = sc.nextDouble();
        double mon = pa.pay(money);
        System.out.println("实付金额为" + mon);
    }
}
```