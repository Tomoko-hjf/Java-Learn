package com.learn.mybatis.entity;

/**
 * 包装对象，用于测试传入参数包含自定义POJO类型的查询
 */
public class QueryVO {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVO{" +
                "user=" + user +
                '}';
    }
}
