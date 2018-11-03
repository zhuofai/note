# Test

基础题
练习一：多线程开启
问题：
请描述Thread类中的start()方法与run()方法的区别。

> start()是开始该线程而run()方法时线程所要执行的

练习二：创建多线程
问题：
请描述创建线程的两种方式。

>继承Thread类,调用start方法,实现interface接口创建Thread对象,调用start方法

练习三：多线程练习
问题：
请编写程序，分别打印主线程的名称和子线程的名称。
要求使用两种方式实现：
第一种方式：继承Thread类。
第二种方法：实现Runnable接口。

```java
public class MyThread extends Thread{
	public void run(){
		System.out.println(MyThread.currentThread.getName());
	}
	public static void main(String[] args){
		Mythread t = new Mythread();
		t.start();
		System.out.println(Thread.currentThread.getName());
	}
}

public class MyThread1 implements Runnable{
	public void run(){
		System.out.println(MyThread.currentThread.getName());
	}
}
public class Test{
	public static void main(String args[]){
		Thread t = new Thread(new MyThread1);
		t.start;
		System.out.println(Thread.currentThread.getName());
	}
}
```

练习四：实现Runnable接口的优势
问题：
请描述实现Runnable接口比继承Thread类所具有的优势：

>耦合性降低.把单继承的缺点改掉

练习五：线程状态
问题：请描述在线程的生命周期中， 有几种状态呢 ?

> 开始   阻塞, 运行,等待,有限等待
扩展题
练习六：多线程练习
问题：
编写程序，在主线程中，循环输出“主线程执行”；在一条新线程中，循环输出“子线
程执行”

```java
public class Test{
	
	public static void main(String[] args){
		new Thread(){
		public void run(){
			while(true){
				System.out.println("子线程执行");
			}
			
		}.start();
		while(true){
			System.out.println("主线程执行");
		}
	}
	
}
```

练习七：多线程匿名内部类练习
问题：
编写程序，创建两个线程对象，一根线程循环输出“播放背景音乐”，另一根线程循环输出“显示画面”，要求线程实现Runnable接口，且使用匿名内部类实现

```java
public class Test{
	new Thread(new Runnable(){
		public void run(){
			while(true){
				System.out.println("播放背景音乐");
			}
		}
	}).start;
}
```

练习八：多线程练习
问题：
编写一个Java程序，要求在同一个类中除main线程外，再开启一个线程，2个线程都循环执行20次。

```java

```

练习九：多线程练习
问题：
请按要求编写多线程应用程序，模拟多个人通过一个山洞：
1.这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；
2.随机生成10个人，同时准备过此山洞，并且定义一个变量用于记录通过隧道的人数。显示每次通过山洞人的姓名，和通过顺序；
