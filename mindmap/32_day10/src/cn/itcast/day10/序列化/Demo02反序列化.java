package cn.itcast.day10.序列化;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/*
    问题:
       1.我们如果确定存进去的对象是多少个?-->循环次数无法确定

    解决:
       1.利用不确定次数的方式来循环读取对象-->EOFException(文件意外到达结尾异常)
 */
public class Demo02反序列化 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("32_day10\\person.txt"));
        //读取对象
        /*Person p1 = (Person) ois.readObject();
        Person p2 = (Person) ois.readObject();
        System.out.println(p1);
        System.out.println(p2);*/

        /*for (int i = 0; i < 2; i++) {
            Person p = (Person) ois.readObject();
            System.out.println(p);
        }*/

       /* Person p = null;
        while((p= (Person) ois.readObject())!=null){
            System.out.println(p);
        }*/

      /* while(true){
           Person p1 = (Person) ois.readObject();
           System.out.println(p1);
       }*/

        ArrayList<Person> list = (ArrayList<Person>) ois.readObject();
        for (Person person : list) {
            System.out.println(person);
        }
        ois.close();

    }
}
