package com.learn.mybatis.entity;

import org.apache.ibatis.annotations.Insert;

import java.util.Date;

public class Course {
    private Integer id;
    private String className;
    private String teacher;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }

    public Course(String className, String teacher) {
        this.className = className;
        this.teacher = teacher;
    }
}
