package com.wadedwyane.www.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "key_university")
public class KeyUniversity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "高校名称", nullable = false)
    private String universityName;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "president_id", referencedColumnName = "id", nullable = false)
    private UniversityPresident universityPresident;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "university", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Department> departments;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REMOVE, CascadeType.DETACH})
    @JoinTable(name = "keyuniversity_teacher", joinColumns = {@JoinColumn(name = "k_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "t_id", referencedColumnName = "id")})
    private List<Teacher> teachers;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public UniversityPresident getUniversityPresident() {
        return universityPresident;
    }

    public void setUniversityPresident(UniversityPresident universityPresident) {
        this.universityPresident = universityPresident;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
