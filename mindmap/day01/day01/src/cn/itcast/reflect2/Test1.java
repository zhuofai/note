package cn.itcast.reflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {

    public static void main(String[] args) throws Exception {
        //反射技术
        //1.获取字节码
        Class sp = Class.forName("cn.itcast.reflect2.SecretPerson");
        //2.获取构造函数对象
        Constructor constructor = sp.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        //3.通过构造来创建对象
        SecretPerson secretPerson = (SecretPerson) constructor.newInstance("小梅", 18);
        //4.修改他的名字--->小梅梅
        //5.通过字节码对象获取字段对象
        Field nameField = sp.getDeclaredField("name");
        nameField.setAccessible(true);
        //6.set(要被设置的对象,要被设置的值);
        nameField.set(secretPerson, "小梅梅");
        //7.调用整理文件的方法
        secretPerson.manageFile();
        //8.调用私有的方法
        Method method = sp.getDeclaredMethod("travelWithBoss",String.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(secretPerson,"林青霞","马尔代夫","欣赏落日");

    }
}
