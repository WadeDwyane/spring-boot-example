package com.wadedwyane.www.entity;

import java.io.Serializable;

public class Student implements Serializable {

    private Long id;

    private String name;

    private String age;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id : " + id + " , name : " + name + " , age : " + age;
    }
}
