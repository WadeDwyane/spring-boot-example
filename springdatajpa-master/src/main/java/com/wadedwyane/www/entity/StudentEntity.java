package com.wadedwyane.www.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    private long id;

    @NotNull
    @Size(min = 5, max = 20)
    @Column(name = "姓名")
    private String name;

    @Column(name = "年龄")
    private int age;

    @Column(name = "性别")
    private int sex;

    @Column(name = "得分")
    private int score;

    @Column(name = "排名")
    private int rank;

    @Column(name = "备注")
    private String remark1;

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

}


