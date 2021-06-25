package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 根据配置文件动态加载相应的类
 */
public class TestSpringReflection {
    public static void main(String[] args) {
        try {
            File springConfigFile = new File("D:/hjf/web/learn-java/res/spring.config");
            //读取属性配置文件
            Properties springConfig = new Properties();
            springConfig.load(new FileInputStream(springConfigFile));
            String className = (String) springConfig.getProperty("class");
            String methodName = (String) springConfig.getProperty("method");
            //加载类对象
            Class clazz = Class.forName(className);
            //加载方法
            Method m = clazz.getMethod(methodName);
            //获取构造器
            Constructor c = clazz.getConstructor();
            //构造实例
            Object service = c.newInstance();
            //调用方法
            m.invoke(service);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
