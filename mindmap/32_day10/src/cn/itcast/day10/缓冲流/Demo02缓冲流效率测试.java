package cn.itcast.day10.缓冲流;

import java.io.*;

public class Demo02缓冲流效率测试 {
    public static void main(String[] args) throws IOException {
        //调用method01方法测试普流通复制视频的效率
       // method01();

        //调用method02方法测试高效流复制视频的效率
        method02();
    }



    private static void method01() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\备课视频资料\\JavaSE高级双元视频\\10\\avi\\02_缓冲流的原理.avi");

        FileOutputStream fos = new FileOutputStream("D:\\copy.avi");

        byte[] bytes = new byte[1024*2];

        int len = 0;
        while((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        fos.close();
        fis.close();

        long end = System.currentTimeMillis();
        System.out.println(end-start);//2223
    }

    private static void method02() throws IOException{
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\备课视频资料\\JavaSE高级双元视频\\10\\avi\\02_缓冲流的原理.avi");

        FileOutputStream fos = new FileOutputStream("D:\\copy.avi");

        //创建高效流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] bytes = new byte[1024];

        int len = 0;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }

        bos.close();
        bis.close();

        long end = System.currentTimeMillis();
        System.out.println(end-start);//50
    }
}
