package com.nxy.test;

import com.nxy.web.entiy.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by snailnan on 2016/9/23.
 */
public class OptionalTest {

    @Test
    public void test(){
        Student  std = getNullStudent();
        Optional<Student> o = Optional.ofNullable(std);
        Assert.assertFalse(o.isPresent());
        o.orElse(getStudent());
        o.ifPresent((e)->{
            System.out.println(e.toString());
        });
    }
    public Student getNullStudent(){
        return null;
    }
    public Student getStudent(){
        return new Student(10,"hello");
    }
}
