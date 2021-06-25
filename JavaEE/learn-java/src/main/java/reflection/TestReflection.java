package reflection;
import entity.Hero;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestReflection {

    public static void main(String[] args) {
        //传统的使用new的方式创建对象
        Hero h1 = new Hero();
        h1.setName("何健飞");
        System.out.println(h1);
        //使用反射方式创建对象
        try {
            String className = "entity.Hero";
            //根据类名加载
            Class pClass = Class.forName(className);
            //获取类构造器
            Constructor c = pClass.getConstructor();
            //利用构造器创建实例
            Hero h2 = (Hero) c.newInstance();
            h2.setName("何健飞2号");
            System.out.println(h2);

            Hero h3 = getHero();
            h3.setName("何健飞3号");
            System.out.println(h3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //利用反射访问属性

        //利用反射调用方法
        Hero hero4 = new Hero();
        try {
            //获取这个名字叫做setName，参数类型是String的方法
            Method m = hero4.getClass().getMethod("setName", String.class);
            //调用该方法
            m.invoke(hero4, "齐天大圣");
            System.out.println(hero4.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据配置文件生成对应类
     * @return 对应的实体类
     */
    public static Hero getHero() {
        File f = new File("D:/hjf/web/learn-java/res/hero.config");
        //可以自动关闭流
        try (FileReader fr = new FileReader(f)) {
            String className = null;
            //读取字符数组
            char[] all = new char[(int) f.length()];
            fr.read(all);
            //根据字符数组构造字符串
            className = new String(all);
            System.out.println(className);
            Class clazz = Class.forName(className);
            Constructor c = clazz.getConstructor();
            return (Hero) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
