package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * 测试流相关方法
 */
public class TestStream {
    public static void main(String[] args) {
        splitFile();
    }

    public static void splitFile() {
        //每个文件的大小
        int eachSize = 100 * 1024;
        File srcFile = new File("C:/Users/lvws/Desktop/何健飞前期工作材料/171004103+何健飞+基于Python的智能聚类软件开发.doc");
        if(0 == srcFile.length()) {
            throw new RuntimeException("文件长度为0，不可拆分");
        }
        byte[] fileContent = new byte[(int) srcFile.length()];
        try {
            FileInputStream fis = new FileInputStream(srcFile);
            fis.read(fileContent);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int fileNumber;
        //计算拆分得到的文件数量
        if(0 == fileContent.length % eachSize) fileNumber = (int) (fileContent.length / eachSize);
        else fileNumber = (int) (fileContent.length / eachSize) + 1;
        //新建一个文件夹
        File newfile = new File(srcFile.getParent(), "新建文件夹");
        //创建文件夹
        if(!newfile.exists()) newfile.mkdirs();
        //获取该文件夹的名称
        String endFile = newfile.getAbsolutePath();
        //依次写入拆分文件中
        for(int i = 0; i < fileNumber; i ++) {
            String srcFileName = srcFile.getName();
            //修改文件名称
            String eachFileName = srcFileName.substring(0, srcFileName.lastIndexOf('.')) + '-' + i + srcFileName.substring(srcFileName.lastIndexOf('.'), srcFileName.length());
            //新建文件时会自动创建
            File eachFile  = new File(endFile, eachFileName);
            byte[] eachContent;
            if(i != fileNumber - 1) {
                //利用Arrays快速复制
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
            } else {
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);
            }
            //写入输出流中。放入try块中会自动关闭流
            try (FileOutputStream fos = new FileOutputStream(eachFile)) {
                fos.write(eachContent);
                System.out.printf("输出子文件%s，其大小是%d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
