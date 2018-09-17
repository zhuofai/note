package cn.itcast.day10.缓冲流;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    BufferedOutputStream(new FileOutputStream("路径"))

 */
public class Demo01缓冲字节输出流 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("32_day10\\a.txt"));
        bos.write("我爱Java".getBytes());
        bos.close();
    }
}
