# day806练习

## 第一题：练习今日的代码

## 第二题：分析以下需求并实现

手机类Phone
属性:
品牌brand
价格price
行为:
打电话call()
发短信sendMessage()
玩游戏playGame()
要求:
1.按照以上要求定义类,属性要私有,生成空参、有参构造，setter和getter方法
2.定义测试类,在main方法中创建该类的对象并给属性赋值(演示两种方法:setter方法和构造方法)
3.调用三个成员方法,打印格式如下:
正在使用价格为998元的小米品牌的手机打电话....
正在使用价格为998元的小米品牌的手机发短信....
正在使用价格为998元的小米品牌的手机玩游戏....

```Java
public class Phone{
	private String brand;
	private int price;
	public void call(){}
	public void sendMessage(){}
	public void playGame(){}
	public Phone(){}
	public Phone(String brand,int price){
		this.brand = brand;
		this.price = price;
	}
	public int getBrand(){
		return this.price;
	}
	public void setBrand(int price){
		this.price = price;
	}
	public String 
}
```

## 第三题：分析以下需求并实现

1.项目经理类Manager
属性：
姓名name
工号id
工资salary
奖金bonus
行为：
工作work()
2.程序员类Coder
属性：
姓名name
工号id
工资salary
行为：
工作work()
要求:
1.按照以上要求定义Manager类和Coder类,属性要私有,生成空参、有参构造，setter和getter方法
2.定义测试类,在main方法中创建该类的对象并给属性赋值(演示两种方法:setter方法和构造方法)
3.调用成员方法,打印格式如下:
工号为123基本工资为15000奖金为6000的项目经理正在努力的做着管理工作,分配任务,检查员工提交上来的代码.....
工号为135基本工资为10000的程序员正在努力的写着代码......

## 第四题：分析以下需求并实现

1.猫类Cat
属性:
毛的颜色color
品种breed
行为:
吃饭eat()
抓老鼠catchMouse()
2.狗类Dog
属性:
毛的颜色color
品种breed
行为:
吃饭()
看家lookHome()
要求:
1.按照以上要求定义Cat类和Dog类,属性要私有,生成空参、有参构造，setter和getter方法
2.定义测试类,在main方法中创建该类的对象并给属性赋值(演示两种方法:setter方法和构造方法)
3.调用成员方法,打印格式如下:
花色的波斯猫正在吃鱼.....
花色的波斯猫正在逮老鼠....
黑色的藏獒正在啃骨头.....
黑色的藏獒正在看家.....