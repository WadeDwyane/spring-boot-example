package com.wadedwyane.www.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@DynamicUpdate
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "姓名", nullable = false)
    private String name;

    @Column(name = "性别", nullable = false, length = 1)
    private String sex;

    @Column(name = "生日", nullable = true)
    private String birthday;

    @Column(name = "电话")
    private String phone;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, /*mappedBy = "employee", */cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH})
//    @JoinColumn(name = "p_id", referencedColumnName = "id")
    private List<PaperworkEntity> paperworkEntities;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REMOVE, CascadeType.DETACH})
    @JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private List<Project> projectList;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PaperworkEntity> getPaperworkEntities() {
        return paperworkEntities;
    }

    public void setPaperworkEntities(List<PaperworkEntity> paperworkEntities) {
        this.paperworkEntities = paperworkEntities;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
