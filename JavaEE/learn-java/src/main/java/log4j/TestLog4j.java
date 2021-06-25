package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
    //将类对象传入日志对象中
    static Logger logger = Logger.getLogger(TestLog4j.class);

    public static void main(String[] args) throws InterruptedException{
        //BasicConfigurator.configure();
        //从配置文件中加载log4j的配置
        PropertyConfigurator.configure("D:\\hjf\\web\\learn-java\\src\\main\\resources\\log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        Thread.sleep(1000);
        logger.warn("警告信息");
    }
}
