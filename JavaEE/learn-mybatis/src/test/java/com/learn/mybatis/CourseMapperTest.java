package com.learn.mybatis;

import com.learn.mybatis.entity.Course;
import com.learn.mybatis.entity.User;
import com.learn.mybatis.mapper.CourseMapper;
import com.learn.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class CourseMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    static Logger logger = Logger.getLogger(MybatisTest.class);

    //构造的时候就加载好日志配置
    public CourseMapperTest() {
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
    public void testInsertCourse() {
        Course course = new Course("chinese", "hjf");
        //创建session对象
        try(SqlSession session = sqlSessionFactory.openSession()) {
            //通过sqlsession获取代理对象
            CourseMapper courseMapper = session.getMapper(CourseMapper.class);
            //调用代理对象的对应方法
            int res = courseMapper.insertCourse(course);
            session.commit();
            logger.info(res);
        }
    }

    @Test
    public void testFindCourseByTeacher() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            //通过sqlsession获取代理对象
            CourseMapper courseMapper = session.getMapper(CourseMapper.class);
            //调用代理对象的对应方法
            List<Course> courses = courseMapper.findCourseByTeacher("hjf");
            session.commit();
            logger.info(courses);
        }
    }
}
