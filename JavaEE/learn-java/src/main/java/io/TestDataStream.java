package io;

import java.io.*;

/**
 * 测试向文件中写入数据
 */
public class TestDataStream {
    public static void main(String[] args) {
        testWrite();
        testReader();
    }

    /**
     * 使用DataOutputStream向文件内写入内容
     */
    public static void testWrite() {
        File file = new File("d:/hjf/data.txt");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            //利用DataOutputStream包装FileOutputStream流
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)
        ) {
            //向文件中写入内容
            dataOutputStream.writeInt(666);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeUTF("何健飞yyds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用DataInputStream向文件内写入内容
     */
    public static void testReader() {
        File file = new File("d:/hjf/data.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream dataInputStream = new DataInputStream(fileInputStream)
        ) {
            //从文件中读取内容
            int a = dataInputStream.readInt();
            boolean b = dataInputStream.readBoolean();
            String c = dataInputStream.readUTF();
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
