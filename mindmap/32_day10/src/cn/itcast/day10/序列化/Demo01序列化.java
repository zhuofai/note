package cn.itcast.day10.序列化;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Demo01序列化 {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("32_day10\\person.txt"));

       /* oos.writeObject(new Person("苍苍",32));
        oos.writeObject(new Person("小步",30));*/

        ArrayList<Person> list = new ArrayList<>();
        Person p1 = new Person("苍苍", 32);
        Person p2 = new Person("小步",30);

        list.add(p1);
        list.add(p2);

        //将集合序列化到硬盘中
        oos.writeObject(list);

        oos.close();
    }
}
