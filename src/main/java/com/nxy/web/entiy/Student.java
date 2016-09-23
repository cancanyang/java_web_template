package com.nxy.web.entiy;

/**
 * Created by snailnan on 2016/9/6.
 */
public class Student {
    private Long id;
    private String name;
    private Integer age;
    public Student(){};
    public Student(Integer age,String name){
        this.age  = age;
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
