package com.example.hua.normalusedemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ZengHongHua on 2018/12/14.
 */
@Entity
public class GoodsInfo {

    @Id
    private Long id;

    private String name;
    private double price;
    @Generated(hash = 1049592769)
    public GoodsInfo(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Generated(hash = 1227172248)
    public GoodsInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
