# 基础题

## 练习一：Map接口的特点

一、请简述Map 的特点。

>将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值。

## 练习二：Entry键值对对象

二、说出Entry键值对对象遍历Map集合的原理。

## 练习三：Map接口中的常用方法

三、请使用Map集合的方法完成添加元素，根据键删除，以及根据键获取值操作。

## 练习五：HashMap存储键是自定义对象值是String

五、请使用Map集合存储自定义数据类型Car做键，对应的价格做值。并使用keySet和entrySet两种方式遍历Map集合。

```java
public class TestCarMoney {
    public static void main(String[] args) {
        Car c = new Car("aiyou");
        Car c1 = new Car("bai");
        Car c2 = new Car("faladi");

        Map<Car,Integer> map = new HashMap<>();
        map.put(c,1000);
        map.put(c1,200);
        map.put(c2,5);

        for (Car ig :
            map.keySet()){
            System.out.println(map.get(ig));
        }

        Set<Map.Entry<Car, Integer>> entries = map.entrySet();
        for (Map.Entry<Car, Integer> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
```

## 练习六：Map集合的使用（一）

六、现在有一个map集合如下：
Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
要求：
1.遍历集合，并将序号与对应人名打印。
2.向该map集合中插入一个编码为5姓名为李晓红的信息
3.移除该map中的编号为1的信息
4.将map集合中编号为2的姓名信息修改为"周林"

```java
public class Test01 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey()
             + "= " + entry.getValue());
        }

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println(map.get(integer));
        }

        map.put(5,"李晓红");
        map.remove(1);
        System.out.println(map);
        map.replace(2,"周林");
        System.out.println(map);
    }
}

```

## 练习七：Map集合的使用（二）

七、有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。如{黑龙江省=哈尔滨, 浙江省=杭州, …}。

```java
public class Test02 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        String[] str = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] str1 = {"哈尔滨","杭州","南昌","广州","福州"};

        for (String s : str) {
            for (String s1 : str1) {
                map.put(s,s1);
            }
        }
        System.out.println(map);
    }
}
```

扩展题

## 练习八：Map集合的使用（三）

八、定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。

```java
public class Test03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abcdsf");
        list.add("bdkfjslfs");
        list.add("bdkfjslfs");
        list.add("bdkfjslfs");
        Map<Character,Integer> map = new HashMap<>();
        for (String s : list) {
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (map.containsKey(c)){
                    Integer i = map.get(c);
                    i++;
                    map.put(c,i);
                }else{
                    map.put(c,1);
                }
            }
        }
        System.out.println(map);
    }
}
```

## 练习九：Map集合的使用（四）

九、利用Map，完成下面的功能：
从命令行读入一个字符串，表示一个年份，输出该年的世界杯冠军是哪支球队。如果该 年没有举办世界杯，则输出：没有举办世界杯。
//tips:参阅Map接口containsKey(Object key)方法
十、在原有世界杯Map 的基础上，增加如下功能： 读入一支球队的名字，输出该球队夺冠的年份列表。 例如，读入“巴西”，应当输出 1958 1962 1970 1994 2002 读入“荷兰”，应当输出 没有获得过世界杯
//tips:参阅Map接口containsValue(Object value)方法
示例：
附：历届世界杯冠军
届数	举办年份	举办地点	冠军
第一届
1930年	乌拉圭	乌拉圭
第二届	1934年	意大利	意大利
第三届	1938年	法国	意大利
第四届	1950年	巴西	乌拉圭
第五届	1954年	瑞士	西德
第六届	1958年	瑞典	巴西
第七届	1962年	智利	巴西
第八届	1966年	英格兰	英格兰
第九届	1970年	墨西哥	巴西
第十届	1974年	前西德	西德
第十一届	1978年	阿根廷	阿根廷
第十二届	1982年	西班牙	意大利
第十三届	1986年	墨西哥	阿根廷
第十四届	1990年	意大利	西德
第十五届	1994年	美国	巴西
第十六届	1998年	法国	法国
第十七届	2002年	韩日	巴西
第十八届	2006年	德国	意大利
第十九届	2010年	南非	西班牙
第二十届	2014年	巴西	德国

```java
public class Test04 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1930年","乌拉圭");
        map.put("1934年","意大利");
        map.put("1938年","意大利");
        map.put("1950年","乌拉圭");
        map.put("1954年","西德");
        map.put("1962年","巴西");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries) {
            list.add(entry.getValue());
            list2.add(entry.getKey());
        }
        System.out.println(list);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<Integer> list1 = new ArrayList<>();
        int count = 0;
        for (String s : list) {
            if (str.equals(s))
                list1.add(count);
            count++;
        }
        System.out.println("list1 "+list1);
        for (Integer integer : list1) {
            System.out.println(list2.get(integer));
        }
    }
}

```