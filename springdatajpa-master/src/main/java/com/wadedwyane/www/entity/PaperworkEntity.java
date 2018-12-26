package com.wadedwyane.www.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@Entity
@Table(name = "paperwork")
public class PaperworkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "名称", nullable = false)
    private String name;

    @Column(name = "获证事件")
    private String acquireTm;

    @Column(name = "颁发部门")
    private String certificationDept;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name = "e_id")
    private Employee employee;

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

    public String getAcquireTm() {
        return acquireTm;
    }

    public void setAcquireTm(String acquireTm) {
        this.acquireTm = acquireTm;
    }

    public String getCertificationDept() {
        return certificationDept;
    }

    public void setCertificationDept(String certificationDept) {
        this.certificationDept = certificationDept;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
