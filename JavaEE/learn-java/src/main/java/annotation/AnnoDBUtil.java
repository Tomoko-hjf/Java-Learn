package annotation;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 所谓注解，就是为本类多加了一些其他信息
 */
@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "hejianfei1998")
public class AnnoDBUtil {
    //初始块
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException, NoSuchMethodException, SecurityException {
        //获取注解对象
        JDBCConfig config = AnnoDBUtil.class.getAnnotation(JDBCConfig.class);
        //解析注解对象的属性
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();
        //获取数据库连接
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws NoSuchMethodException, SQLException {
        Connection c = getConnection();
        System.out.println(c);
    }
}
