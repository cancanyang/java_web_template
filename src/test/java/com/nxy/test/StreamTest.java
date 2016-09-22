package com.nxy.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by snailnan on 2016/9/22.
 */
public class StreamTest {
    private Stream<String> s;
    private Stream<Student> stu;
    @Before
    public void before(){
        s = Stream.of("1","1","3","4");
        stu = Stream.of(new Student(1,"b"),new Student(2,"b"),new Student(3,"c"));
    }
    @Test
    public  void testDistinct(){
        out(s.distinct());
    }
    @Test
    public void testFilet(){
        Stream f = s.filter(e->e=="1");
        out(f);
    }
    @Test
    public void testMap(){
        Stream m = s.map(e-> new Integer(1));
        out(m);

    }
    @Test
    public void testFlatMap(){
        Stream f = stu.flatMap(e->
            Stream.of(e.getName()));
        out(f);
    }
    @Test
    public void testCollect(){
        stu.collect(Collectors.averagingDouble(e-> e.getAge()));
    }

    public void out(Stream s){
        s.forEach(e-> System.out.println(e.toString()));
    }
    class Student {
        private int age;
        private String name;

        public Student(int age,String name){
            this.age = age;
            this.name = name;
        }
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
