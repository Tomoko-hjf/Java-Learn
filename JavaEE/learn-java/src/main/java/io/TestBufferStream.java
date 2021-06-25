package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 测试缓冲流，避免频繁进行IO操作
 */
public class TestBufferStream {
    public static void main(String[] args) {
        testBufferReader();
        testBufferWriter();
        testBufferReader();
    }

    /**
     * 使用缓存字符输入流 BufferedReader 一次读取一行数据
     */
    public static void testBufferReader() {
        File file = new File("d:/hjf/res.txt");
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
             //使用BufferedReader对InputStreamReader进行包装，然后每次读取一行
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            //循环读取每一行
            while (true) {
                String line = bufferedReader.readLine();
                if(null == line) break;
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用BufferedWriter包装OutputStreamWriter进行写出
     */
    public static void testBufferWriter() {
        File file = new File("d:/hjf/res.txt");
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        ) {
            String s1 = "何健飞yyds";
            String s2 = "信科171班";
            bufferedWriter.write(s1);
            bufferedWriter.write(s2.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
