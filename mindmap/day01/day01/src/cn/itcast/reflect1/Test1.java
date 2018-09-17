package cn.itcast.reflect1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test1 {

    public static void main(String[] args) throws Exception {
       // JuiceMachine.zha(new Apple());
        //System.out.println(new Apple());
      //  JuiceMachine.zha(new Banana());
        //读取配置文件中的全类名
        BufferedReader reader = new BufferedReader(new FileReader("day01/a.txt"));
        String name = reader.readLine();
        //通过反射来创建对象
        //1.获取字节码
        Class aClass = Class.forName(name);
        Fruit o = (Fruit) aClass.newInstance();
        JuiceMachine.zha(o);

    }
}
