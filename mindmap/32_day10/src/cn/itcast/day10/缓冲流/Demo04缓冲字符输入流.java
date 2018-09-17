package cn.itcast.day10.缓冲流;

import java.io.*;

/*
   BufferedReader(new FileReader("路径"))

   特有方法:
      readLine()一次读取一行
 */
public class Demo04缓冲字符输入流 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("32_day10\\b.txt"));

        //循环读
        String line = null;

        while((line=br.readLine())!=null){
            System.out.println(line);
        }

        br.close();
    }
}
