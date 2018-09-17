package cn.itcast.reflect3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

public class Test {

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        //1.获取字节码
        Class stuClass = student.getClass();
       /* BufferedReader reader = new BufferedReader(new FileReader("day01/b.txt"));
        String line = null;

        while ((line = reader.readLine())!=null){
            //name=lisi
            *//*String[] split = line.split("=");

            if (split[0].equals("name")) {
                student.setName(split[1]);
            }*//*
            String[] split = line.split("=");

            Field filed = stuClass.getDeclaredField(split[0]);
            filed.setAccessible(true);
            //开始给student的字段设置值
            filed.set(student, split[1]);
        }*/

        Properties properties = new Properties();
        properties.load(new FileReader("day01/b.txt"));
        Set<String> keys = properties.stringPropertyNames();
        for (String filedName : keys) {
            Field field = stuClass.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(student, properties.getProperty(filedName));
        }
        System.out.println(student);
    }
}
