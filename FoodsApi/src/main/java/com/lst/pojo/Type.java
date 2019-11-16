package com.lst.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue
    private Integer tid;
    private String tname;

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE,mappedBy = "type")
    private List<Foods> foodsList;


    public Type() {
    }

    public Type(String tname, List<Foods> foodsList) {
        this.tname = tname;
        this.foodsList = foodsList;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }
}
