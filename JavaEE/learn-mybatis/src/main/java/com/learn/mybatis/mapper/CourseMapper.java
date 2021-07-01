package com.learn.mybatis.mapper;

import com.learn.mybatis.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Insert("INSERT INTO t_course (className, teacher) VALUES (#{className}, #{teacher})")
    int insertCourse(Course course);

    @Select("SELECT * FROM t_course WHERE teacher = #{teacher}")
    List<Course> findCourseByTeacher(String teacher);
}
