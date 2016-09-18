package com.nxy.web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.nxy.web.entiy.Student;

/**
 * Created by snailnan on 2016/9/5.
 */
@Mapper
public interface StudentDao {


    @Select("select * from students where id = #{id}")
    Student findBookById(@Param("id") Long id);

    @Insert("insert into students (name,age) values (#{s.name},#{s.age}) ")
    long insertStudent(@Param("s") Student s);
}
