package cn.itcast.reflect3;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) throws Exception {
        ArrayList<String> al = new ArrayList<>();
        al.add("你好");
        al.add("我好");
        al.add("他也好");
        al.add("大家好");
        //将程序提到运行时---> 指的字节码阶段!!!
        Class alClass = al.getClass();
        Method addMethod = alClass.getMethod("add", Object.class);
        addMethod.invoke(al,new Object());
        System.out.println(al);


    }
}
