package annotation.myhibernate;

import entity.Hero;

import java.lang.reflect.Method;

public class ParseHibernateAnnotation {
    public static void main(String[] args) {
        //获取Hero类
        Class<Hero> clazz = Hero.class;
        //判断Hero类是否使用@Entity注解
        MyEntity myEntity = (MyEntity) clazz.getAnnotation(MyEntity.class);
        if(null == myEntity) {
            System.out.println("Hero类没有使用@Entity注解");
        } else {
            System.out.println("Hero使用了@Entity注解");
            //获取关联的表
            MyTable myTable = (MyTable) clazz.getAnnotation(MyTable.class);
            String tableName = myTable.name();
            System.out.println("其对应的表名为：" + tableName);
            //获取该类的所有方法
            Method[] methods = clazz.getMethods();
            Method primaryKeyMethod = null;
            //遍历所有方法，根据是否使用@MyId注解找到主键
            for(Method m : methods) {
                MyId myId = m.getAnnotation(MyId.class);
                if(null != myId) {
                    primaryKeyMethod = m;
                    break;
                }
            }
            if (null != primaryKeyMethod) {
                System.out.println("找到主键： " + primaryKeyMethod.getName());
                //获取主键的自增策略
                MyGeneratedValue myGeneratedValue = primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
                System.out.println("其自增长策略是：" + myGeneratedValue.strategy());
                //获取主键相关联的表字段
                MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
                System.out.println("对应数据库中字段为：" + myColumn.value());
            }
            System.out.println("其他非主键属性分别对应的数据库字段如下");
            //获取其他方法所对应的字段
            for (Method m : methods) {
                if(m == primaryKeyMethod) continue;
                MyColumn myColumn = m.getAnnotation(MyColumn.class);
                if(null == myColumn) continue;
                System.out.format("属性：%s\t对应的数据库字段是：%s%n", m.getName(), myColumn.value());
            }
        }
    }
}
