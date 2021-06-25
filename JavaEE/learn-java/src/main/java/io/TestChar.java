package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 测试字符相关流
 */
public class TestChar {
    public static void main(String[] args) {
//        String str = read();
//        encoding(str);
        String a = testInputStreamReader();

    }

    /**
     * 使用FileReader以字符形式读取文件
     * @return 文件中的内容
     */
    public static String read() {
        String res = null;
        //加载文件对象
        File file = new File("D:/hjf/test.txt");
        //将文件对象放入缓冲流中
        try(FileReader fileReader = new FileReader(file)) {
            char[] content = new char[(int)file.length()];
            fileReader.read(content);
            res = new String(content);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 将字符串进行加密
     * @param orgContent 原始内容
     * @return 加密后的内容
     */
    public static String encoding(String orgContent) {
        //进行加密
        StringBuilder str = new StringBuilder();
        for (char c : orgContent.toCharArray()) {
            if (c == 'z') str.append('a');
            else if(c == 'Z') str.append('A');
            //如果不强制转化的话输出来是数字而不是字符
            else str.append((char) (c + 1));
        }
        //通过FileWriter以字符的形式写入外部文件
        File file = new File("d:/hjf/res.txt");
        try(FileWriter fileWriter = new FileWriter(file)) {
            char[] cs = str.toString().toCharArray();
            fileWriter.write(cs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str.toString());
        return str.toString();
    }

    public static void showCode(String str) {
        String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16"};

    }

    /**
     * 使用InputStreamReader设置解码格式用来解析中文字符
     * @return
     */
    public static String testInputStreamReader() {
        File f = new File("d:/hjf/res.txt");
        //中文的操作系统默认编码格式一般是GBK
        System.out.println("默认编码格式：" + Charset.defaultCharset());
        //使用操作系统默认的编码格式解析字符
        try(FileReader fileReader = new FileReader(f)) {
            char[] cs = new char[(int)f.length()];
            fileReader.read(cs);
            System.out.printf("FileReader会使用默认的编码格式%s,识别出来的字符是：%n", Charset.defaultCharset());
            System.out.println(new String(cs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用InputStreamReader自定义解码格式(自定义为UTF-8)
        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8)) {
            char[] cs = new char[(int) f.length()];
            inputStreamReader.read(cs);
            System.out.printf("InputStreamReader指定编码方式为UTF-8，识别出来的字符是:%n");
            System.out.println(new String(cs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "over";
    }

    //使用UTF-8编码方式解析汉字，一个汉字占3个字节
    public static void testUTF8() {
        byte[] cs = {(byte)0xE5, (byte)0xB1, (byte)0x8C};
        try {
            String str = new String(cs, "UTF-8");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
