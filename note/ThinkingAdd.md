# Test

1. 当变量作为类的变量使用时,java才确保给定其默认值.然而上述确保初始化的方法并不适用于"局部"变量(即并非某个类的字段)
2. 要是类的数据成员(即字段)是基本类型,情况就会变得不同.类的每个基本数据成员都保证会有一个初始值.
3. 在类的内部,变量定义的先后顺序决定了初始化的顺序.即使变量定义散布于方法定义之间,它们仍旧会在任何方法(包括构造器)被调用之前得到初始化.
4. 类的加载初始化,只要不new对象,那么只是初始化它的字段.并不包括构造器的初始化.

```java
class Window{
    Window(int marker){
        System.out.println("Window(" + marker + ")");
    }
}
class House{
    Window w1= new Window(1);
    House(){
        //Show that we're in the constructor
        System.out.println("House()");
        w3 = new Window(33);
    }
    Window w2 = new Window(2);
    void f(){
        System.out.println("f()");

    }
    Window w3 = new Window(3);

}
public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}
```

```java
class Bowl{
    Bowl(int marker){
        System.out.println("Bowl(" + marker + ")");
    }
    void f1(int marker){
        System.out.println("f1(" + marker + ")");
    }
}
class Table{
    static Bowl bowl1 = new Bowl(1);
    Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker){
        System.out.println("f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}
class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard(){
        System.out.println("Cupboard");
        bowl4.f1(2);
    }
    void f3(int marker){
        System.out.println("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
```

1. int x = a.f();发送消息给对象,消息是f(),对象是a.
2. 如果使用"本地方法"的情况下,本地方法是一种在Java中调用非java代码的方式(也许会调用C的malloc()函数系列来分配存储空间),所以需要在finalize()中用本地方法调用它.
3. 在输出语句上会自动调用toString()方法

```java
class A{
    public A(){
        System.out.println("niahoA");
    }
}
class B{
    public B(){
        System.out.println("niahoB");
    }
}
public class Test extends A{
    private B b = new B();
    public Test(){
        System.out.println("niahoTest");
    }
    public static void main(String[] args) {
        new Test();
    }
}
/*
niahoA
niahoB
niahoTest
///~先初始化了基类然后在初始化子类，所以产生了下列的结果，初始化基类后然后初始化字段变量，然后在初始化Test（）的构造方法
```

1. 看到后面的构造器初始化顺序才明白过来
* 调用基类构造器，这个步骤会不断地反复递归下去，首先是构造这种层次结构的根，然后是下一层导出类，等等，知道最底层的导出类。
* 按声明顺序调用成员初始化方法。
* 调用导出类构造器的主体。

1. 总结来讲就是
* 先初始化基类中的静态成员派生类中的静态成员
* 然后是在new对象之前的一些输出语句
* 构造器初始化顺讯（先从基类初始化成员，再派生类初始化成员）
* 最后是导出类构造器主体