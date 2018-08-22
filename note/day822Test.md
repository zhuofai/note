# day821Test

## 练习一：集合框架

1. 请简述集合框架。

>集合框架从根类的Collection接口开始,List Set集合框架继承了Collection然后AbstractCollection是Collection接口的骨干实现.而List下面还有ArrayList LinkedList 而Set下面有TreeSet和LinekedHashSet和HashSet

## 练习二：Collection集合统计元素出现次数

1. 给定以下代码，请定义方法public static int listTest(Collection\<String> list,String s)统计集合中指定元素出现的次数，如"a":2,"b": 2,"c" :1, "xxx":0。

```java
public class Test{
    public static int listTest(Collection<String> list,String s){
        int count = 0;
        for(String s1 : list){
            if(s1.equals(s)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:"+listTest(list, "a"));
        System.out.println("b:"+listTest(list, "b"));
        System.out.println("c:"+listTest(list, "c"));
    }
}

```

## 练习三：Collection集合数组转集合

1. 定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，并返回。

```java
public class Test{
    public static ArrayList<Integer> change(int[]arr){
        ArrayList<Integer>list = new ArrayList<Integer>();
        for(int i = 0;i < arr.length;i++){
            list.add(arr[i]);
        }
        return list;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] arr = {1,2,3,4,56};
        list = change(arr);
    }
}
```

## 练习四：Collection集合集合转数组

1. 定义一个集合，并把集合(集合里面的元素是Integer)转成存有相同元素的数组，并将结果输出在控制台。（可以使用Object[]数组类型接收转换的数组）

```java
public class Test{
    public static  int[] change(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        int i = 0;
        for(Integer n : list){
            arr[i] = n;
            i++;
        }
        return arr;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int[] arr = new int[list.size()];
        arr = change(list);
        System.out.println(Arrays.toString(arr));
    }
}
```

## 练习五：Collection集合contains()方法使用

1. 定义一个方法listTest(ArrayList\<String> al, String s),要求使用contains()方法判断al集合里面是否包含s。

```java
public class Test{
    public boolean listTest(ArrayList<String> al, String s){
        return al.contains(s);
    }
}
```

## 练习六：Collection集合isEmpty()方法的使用

1. 定义一个方法listTest(ArrayList\<String> al), 要求使用isEmpty()判断al里面是否有元素。

```java
public class Test{
    public boolean listTest(ArrayList<String> al){
        return al.isEmpty();
    }
}
```

## 练习七：简述迭代器的实现原理

1. 请简述迭代器的实现原理

>首先指针指向-1hasnext()是否有下一个然后指针向前...

## 练习八：Collection集合返回首次出现索引

1. 定义一个方法listTest(ArrayList\<Integer> al, Integer s)，要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。

```java
public class Test{
    public int listTest(ArrayList<Integer> al, Integer s){
        return al.Indexof(s);
    }
}
```

扩展题

## 练习九：Collection集合练习

1. (复杂，并不难)定义一个学生类Student，包含三个属性姓名、年龄、性别，创建三个学生对象存入ArrayList集合中。
* A：遍历集合遍历输出。
* B：求出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。

```java
class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

public class Test3 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhuofai", 25, "男"));
        list.add(new Student("zhuo", 18, "男"));
        list.add(new Student("zhuofi", 21, "男"));
        int age = list.get(0).getAge();
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            if(age < list.get(i).getAge()){
                age = list.get(i).getAge();
                count = i;
            }
        }
        list.get(count).setName("小猪佩琪");
        System.out.println(list);
    }
}
```

## 练习十：Collection集合练习

1. 产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台。

```java
public class Test{
    public static void main(String[] args){
        Random rand = new Random(System.currentTimeMillis);
        int[] arr = new int[10];
        for(int i = 0;i < 10;i++){
            arr[i] = rand.nextInt(100)+1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){
            if(arr[i] >= 10){
                list.add(arr[i]);
            }
        }
        System.out.println(list);
    }
}
```

## 练习十二：泛型方法

1. 编写一个泛型方法，接收一个任意引用类型的数组，并反转数组中的所有元素

```java
public class Test{
    public <T> void reverse(T[] arr){
        T[] arr1 = arr;
        T n = arr.length;
        for(int i = 0;i < arr.length;i++){
            arr[i] = arr1[n-1];
            n--;
        }
    }
}
```
