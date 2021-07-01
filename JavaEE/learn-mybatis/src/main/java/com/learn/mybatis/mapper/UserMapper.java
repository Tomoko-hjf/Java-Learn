package com.learn.mybatis.mapper;

import com.learn.mybatis.entity.QueryVO;
import com.learn.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface UserMapper {
    @Select(value = "select * from t_user where id = #{id}")
    User findUserById(int id) throws Exception;

    List<User> findUsersByName(String name) throws Exception;

    @Insert(value = "insert into t_user(name,password,age,birthday) values(#{name},#{password},#{age},#{birthday})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty =  "id", resultType = int.class, before = false)
    Integer insertUser(User user) throws Exception;

    List<User> findUserList(QueryVO queryVO) throws Exception;
}
