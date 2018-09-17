package cn.itcast.reflect;

import java.lang.reflect.Field;

public class Test1 {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        System.out.println(person);
        //暴力反射
        //1.获取字节码
        Class pClass = person.getClass();
        //2.通过字节码对象来获取获取name字段对象
        Field nameFiled = pClass.getDeclaredField("name");
        //暴力反射,忽略安全检测
        nameFiled.setAccessible(true);
        nameFiled.set(person, "如花");
        //3.通过字节码对象来获取获取age字段对象
        Field ageFiled = pClass.getDeclaredField("age");
        //暴力反射,忽略安全检测
        ageFiled.setAccessible(true);
        ageFiled.set(person, 60);

        System.out.println(person);



    }
}
