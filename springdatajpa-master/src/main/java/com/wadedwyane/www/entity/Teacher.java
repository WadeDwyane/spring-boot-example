package com.wadedwyane.www.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    private String degree;

    private int studentCount;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REMOVE, CascadeType.DETACH})
    @JoinTable(name = "keyuniversity_teacher", joinColumns = {@JoinColumn(name = "t_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "u_id", referencedColumnName = "id")})
    private List<KeyUniversity> universities;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public List<KeyUniversity> getUniversities() {
        return universities;
    }

    public void setUniversities(List<KeyUniversity> universities) {
        this.universities = universities;
    }
}
