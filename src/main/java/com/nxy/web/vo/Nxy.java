package com.nxy.web.vo;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * Created by snailnan on 2016/9/1.
 */
//@Component
public class Nxy implements Serializable{

    private static final long serialVersionUID = 5158885230294143385L;
    @Value("${nxy.age}")
    private Integer age ;

    @Value("${nxy.name}")
    private String name;

    public  Nxy(){}

    public Nxy(Integer age ,String name){
        this.age = age;
        this.name = name;

    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
        return "Nxy{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
