package com.wadedwyane.www.entity.secondary;

import javax.persistence.*;

@Entity
@Table(name = "good")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "goodName", nullable = false)
    public String goodName;


    public Good() {

    }

    public Good(String name, String goodName) {
        this.name = name;
        this.goodName = goodName;
    }

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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
