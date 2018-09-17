package cn.itcast.day10.缓冲流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
   BufferedWriter(new FileWriter("路径"))

   特有方法:
      newLine()换行
 */
public class Demo03缓冲字符输出流 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("32_day10\\b.txt"));

        for (int i = 0; i < 5; i++) {
            bw.write("小步和苍苍一起玩儿");
            bw.newLine();
        }
        bw.close();
    }
}
