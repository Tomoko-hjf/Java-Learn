package com.learn.mybatis.mapper.impl;

import com.learn.mybatis.entity.QueryVO;
import com.learn.mybatis.entity.User;
import com.learn.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    //全局只有一个SqlSessionFactory,需要用构造方法注入
    private SqlSessionFactory sqlSessionFactory;

    public UserMapperImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        User user = null;
        try(//通过会话工厂创建会话
            SqlSession session = sqlSessionFactory.openSession()) {
            //通过会话得到相应的映射器mapper对象
            UserMapper mapper = session.getMapper(UserMapper.class);
            //执行相应的方法
            user = mapper.findUserById(id);
        }
        return user;
    }

    @Override
    public List<User> findUsersByName(String name) throws Exception {
        List<User> users = null;
        try(SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            users = mapper.findUsersByName(name);
            session.commit();//提交事务
        }
        return users;
    }

    @Override
    public Integer insertUser(User user) throws Exception {
        Integer res = null;
        try(SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            res = mapper.insertUser(user);
            session.commit();//提交事务
        }
        return res;
    }

    @Override
    public List<User> findUserList(QueryVO queryVO) throws Exception {
        return null;
    }


}
