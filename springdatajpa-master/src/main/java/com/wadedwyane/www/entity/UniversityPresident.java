package com.wadedwyane.www.entity;

import javax.persistence.*;

@Entity
@Table(name = "university_president")
public class UniversityPresident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "姓名", nullable = false)
    private String name;

    @Column(name = "性别")
    private String sex;

    @Column(name = "年龄")
    private int age;

    @Column(name = "学历")
    private String degree;

    @Transient
    private String partTime;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPartTime() {
        return partTime;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }
}
