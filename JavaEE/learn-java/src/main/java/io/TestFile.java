package io;

import java.io.File;

/**
 * 测试文件相关操作
 */
public class TestFile {
    public static void main(String[] args) {
        File f = new File("D://hjf/PDF Book");
        dfs(f, 0);
    }

    private static void dfs(File file, int prefix) {
        if(file.isDirectory()) {
            System.out.format("第%d级文件夹%s里包含文件：----\n", prefix, file.getName());
            File[] files = file.listFiles();
            for (File f : files) {
                dfs(f, prefix + 1);
            }
        } else {
            System.out.format("第%d级文件----%s\n", prefix, file.getName());
        }
    }



    
}
