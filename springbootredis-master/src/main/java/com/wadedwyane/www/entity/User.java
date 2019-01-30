package com.wadedwyane.www.entity;

import java.io.Serializable;

public class User implements Serializable {

    private String name;

    private int age;

    private int sex;

    private int score;

    private String describe;

    private String remark;

    public User(String name, int age, int sex, int score, String describe, String remark) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
        this.describe = describe;
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age='" + age + '\'' + ", sex='" + sex + '\'' + ", score='"
                + score + '\'' + ", describe='" + describe + '\'' + ", remark='" + remark + '\'' + '}';
    }
}
