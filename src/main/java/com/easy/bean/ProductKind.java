package com.easy.bean;

import com.easy.utils.TimeFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


// 产品分类

public class ProductKind {
//    产品id
    private Integer id;
//    产品名
    private String name;
//    介绍
    private String info;
//   父级
    private Integer parent_id;
//    上下架
    private Integer state;
//    创建时间
    private Timestamp createTime;
//    创建者
    private String creator;
//    最后修改时间
    private Timestamp lastEditTime;
//    是否删除
    private Integer isDel;
//    子类
    private List<ProductKind> productKind;
//    具体
    private List<Product> products;

    public ProductKind() {
    }

    public ProductKind(Integer id, String name, String info, Integer parent_id, Integer state, Timestamp createTime, String creator, Timestamp lastEditTime, Integer isDel, List<ProductKind> productKind, List<Product> products) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.parent_id = parent_id;
        this.state = state;
        this.createTime = createTime;
        this.creator = creator;
        this.lastEditTime = lastEditTime;
        this.isDel = isDel;
        this.productKind = productKind;
        this.products = products;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateTime() {
        return TimeFormat.getTime(createTime);
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastEditTime() {
        return TimeFormat.getTime(lastEditTime);
    }

    public void setLastEditTime(Timestamp lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public List<ProductKind> getProductKind() {
        return productKind;
    }

    public void setProductKind(List<ProductKind> productKind) {
        this.productKind = productKind;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
