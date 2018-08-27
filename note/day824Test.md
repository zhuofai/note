# dayTest824

## 练习一：List接口的特点

1. 请简述List接口的特点。

## 练习二：hashCode和equals方法

1. 请简述HashSet去除重复元素的原理。

>先比较hashCode是否一样,一样的话再比较equals方法.

## 练习三：数据结构

1. 简述常见的数据结构中元素的存取特点。

>链式和线性,通过这两个基本的数据结构衍生出来不同的数据结构.

## 练习四：Comparable和Comparator比较器

1. 简述Comparable和Comparator两个接口的区别。

>Comparable此接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，类的 compareTo 方法被称为它的自然比较方法。
>Comparator强行对某个对象 collection 进行整体排序 的比较函数。可以将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort），从而允许在排序顺序上实现精确控制。还可以使用 Comparator 来控制某些数据结构（如有序 set或有序映射）的顺序，或者为那些没有自然顺序的对象 collection 提供排序。

## 练习五：LinkedList方法的使用

1. 根据要求练习LinkedList方法：
* 基本方法：add, set, get, remove, clear, size等方法；
* 特有方法：addFirst, addLast, getFirst, getLast, removeFirst,removeLast, push, pop, clear等方法。

```java
public class Test{
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList();
        list.add("你好");
        list.add("我好");
        list.add("大家好");
        System.out.println(list);
        list.set(0,"zhuofai");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.remove());
        System.out.println(list);

        System.out.println(list.size());
        list.clear();
        System.out.println(list);

        list.addFirst("zhuofai");
        list.addFirst("xixi");
        list.addLast("xixi");
        System.out.println(list.getFirst());
        System.out.println(list);
    }
}
```

## 练习六：HashSet存储自定义类型

1. 定义人类，包含姓名和年龄属性。创建4个人存储到HashSet中，姓名和年龄相同的人看做同一人不存储。

```java
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    @Test
    public void Test() {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("zhuofai", 18));
        set.add(new Person("zhuofai", 18));
        set.add(new Person("xixi", 18));
        set.add(new Person("keke", 18));
        System.out.println(set);
        for (Person person : set) {
            System.out.println(person);
        }
    }
}
```

## 练习七：List集合元素替换

1. 向list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫。

```java
public class Test{
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("二丫");
        list.add("钱六");
        list.add("孙七");
        int count = 0;
        for (String s : list) {
            if (s.equals("二丫")){
                break;
            }
            count ++;
        }
        list.set(count,"王小丫");
        System.out.println(list);
    }
    }
}
```

## 练习八：LinkedHashSet基本使用

1. 使用LinkedHashSet存储以下元素："王昭君","王昭君","西施","杨玉环","貂蝉"。使用迭代器和增强for循环遍历LinkedHashSet。

```java
public class Test{
    public static void main(String[] args){
         LinkedHashSet<String> list = new LinkedHashSet<>();
        list.add("王昭君");
        list.add("王昭君");
        list.add("西施");
        list.add("杨玉环");
        list.add("貂蝉");
        for (String s : list) {
            System.out.println(s);
        }
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
```

## 练习九：Collections工具类使用

1. ArrayList集合中有如下内容： {33,11,77,55}，使用Collections.sort()对ArrayList集合中的数据进行排序，并打印出排序后的结果。

```java
public class Test{
    public static void main(String[] args){
        int[] arr = {33,11,77,55};

        List<Integer> integerList = Arrays.asList(33, 11, 77, 55);
        Collections.sort(integerList);
        System.out.println(integerList);
    }
}
```

扩展题

## 练习十：LinkedList使用

1. 已知数组存放一批QQ号码，QQ号码最长为11位，最短为5位String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}。将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，将list中所有元素分别用迭代器和增强for循环打印出来。

```java
public class Test{
    public static void main(String[] args){
      LinkedList<String> list = new LinkedList<>(Arrays.asList("12345","67891","12347809933","98765432102","67891","12347809933"));
        HashSet<String> set = new HashSet<>();
        for (String s : list) {
            set.add(s);
        }
        list.clear();
        for (String s : set) {
            list.add(s);
        }
        System.out.println(list);
    }
}
```

## 练习十一：LinkedHashSet的使用

1. 键盘录入一个字符串，去掉其中重复字符，打印出不同的那些字符，必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd。

```java
public class Test{
    public static void main(String[] args){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            set.add(c);
        }
        for (Character character : set) {
            System.out.print(character);
        }
    }
}
```