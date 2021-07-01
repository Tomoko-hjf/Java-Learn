package com.learn.mybatis;

import com.learn.mybatis.entity.QueryVO;
import com.learn.mybatis.entity.User;
import com.learn.mybatis.mapper.UserMapper;
import com.learn.mybatis.mapper.impl.UserMapperImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory;

    static Logger logger = Logger.getLogger(MybatisTest.class);

    //构造的时候就加载好日志配置
    public MybatisTest() {
        PropertyConfigurator.configure("D:/hjf/web/learn-mybatis/src/main/resources/log4j.properties");
    }

    @Before
    public void init() throws Exception {
        //创建builder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        logger.info("进入init方法");
        //通过builder对象加载xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {

    }

    @Test
    public void testFindUsersByName() throws Exception {
        //创建session对象
        try(SqlSession session = sqlSessionFactory.openSession()) {
            //通过sqlsession获取代理对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            //调用代理对象的对应方法
            List<User> users = userMapper.findUsersByName("hjf");
            logger.info(users);
        }
    }

    @Test
    public void testInsertUser() throws Exception {
        Date date = new Date();
        User user = new User("hjf", "hejianfei1998", 22, date, "测试插入功能");
        UserMapper userMapper = new UserMapperImpl(sqlSessionFactory);
        Integer res = userMapper.insertUser(user);
        logger.info(user);
        logger.info(res);
    }

    @Test
    public void testFindUserList() throws Exception {
        //创建session对象
        try(SqlSession session = sqlSessionFactory.openSession()) {
            //通过sqlsession获取代理对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            //创建包装对象
            QueryVO queryVO = new QueryVO();
            User user = new User("hjf", "hxr", 22, new Date(), "hahaha");
            queryVO.setUser(user);
            //调用代理对象的对应方法
            List<User> users = userMapper.findUserList(queryVO);
            logger.info(users);
        }

    }
}
