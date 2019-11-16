package com.lst.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "foods")
public class Foods {
     @Id
    @GeneratedValue
    private Integer id;
     private String name;
     private BigDecimal price;
     private Date borntime;

     @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "tid")
    private Type type;

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", borntime=" + borntime +
                ", type=" + type +
                '}';
    }

    public Foods() {
    }

    public Foods(String name, BigDecimal price, Date borntime, Type type) {
        this.name = name;
        this.price = price;
        this.borntime = borntime;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getBorntime() {
        return borntime;
    }

    public void setBorntime(Date borntime) {
        this.borntime = borntime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
