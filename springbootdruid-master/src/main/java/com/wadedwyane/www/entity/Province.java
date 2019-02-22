package com.wadedwyane.www.entity;


import javax.persistence.*;

@Entity
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int provinceId;
    private String provinceName;
    private String provinceIntroduce;

    public Province(int provinceId, String provinceName, String provinceIntroduce) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.provinceIntroduce = provinceIntroduce;
    }

    public Province(String provinceName, String provinceIntroduce) {
        this.provinceName = provinceName;
        this.provinceIntroduce = provinceIntroduce;
    }

    public Province() {
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceIntroduce() {
        return provinceIntroduce;
    }

    public void setProvinceIntroduce(String provinceIntroduce) {
        this.provinceIntroduce = provinceIntroduce;
    }
}
