package com.nxy.web.dao;

import com.nxy.web.App;
import com.nxy.web.dao.StudentDao;
import com.nxy.web.entiy.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by snailnan on 2016/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestDao {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void testStudent(){
        Student book = studentDao.findBookById(1L);
        System.out.println(book.toString());
    }
    @Transactional(propagation = Propagation.MANDATORY)
    @Test
    public void testInsert(){
        Student student = new Student();
        student.setName("hello world");
        student.setAge(100);
        Long n = studentDao.insertStudent(student);
        System.out.println(n);
        student.setId(3L);
        System.out.println(studentDao.insertStudent(student));

    }
}
