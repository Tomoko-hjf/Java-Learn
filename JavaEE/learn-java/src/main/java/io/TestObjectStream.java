package io;

import entity.Hero;

import java.io.*;

/**
 * 测试对象流
 */
public class TestObjectStream {
    public static void main(String[] args) {
        saveObject();
    }

    public static void saveObject() {
        //创建对象
        Hero hero = new Hero();
        hero.setName("何健飞");
        hero.setId(1);
        //创建File文件
        File file = new File("d:/hjf/data.txt");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //创建对象输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            //向文件中写入对象
            objectOutputStream.writeObject(hero);
            //从文件中读取对象
            Hero hero2 = (Hero)objectInputStream.readObject();
            System.out.println(hero2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
