package annotation;

import java.io.File;
import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * 使用Repeatable元注解实现自定义注解的重复使用
 */
public class FindFiles {
    //承载重复自定义注解的容器
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileTypes {
        FileType[] value();
    }

    //自定义注解，使用@Repeatable元注解表明可以重复使用
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(FileTypes.class)//重复使用元注解
    public @interface FileType {
        String value();
    }

    //重复使用自定义注解
    @FileType(value = ".java")
    @FileType(value = ".html")
    @FileType(value = ".css")
    @FileType(value = ".js")
    public void work() {
        try {
            //获取注解数组
            FileType[] fileTypes = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);

            System.out.println("将从如下后缀名的文件中查找");
            for(FileType fileType : fileTypes) {
                System.out.println(fileType.value());
            }
            System.out.println("查找过程略...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindFiles().work();
    }
}
