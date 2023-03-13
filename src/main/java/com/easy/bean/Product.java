package com.easy.bean;

import com.easy.utils.TimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 产品详情
 */
public class Product {
    /**主键*/
    private Integer product_id;
    /**姓名*/
    private String name;
    /**现价*/
    private BigDecimal price;
    /**原价*/
    private BigDecimal old_price;
    /**介绍*/
    private String info;
    /**数量*/
    private Integer count;
    /**类型*/
    private Integer type_id;
    /**上下架*/
    private Byte state;
    /**是否删除*/
    private Byte isDel;
    /**创建时间*/
    private Timestamp createTime;
    /**创建者*/
    private String creator;
    /**最后一次修改的时间*/
    private Timestamp lastEditTime;
    /**产品图片*/
    private List<ProductImg> productImg;

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", old_price=" + old_price +
                ", info='" + info + '\'' +
                ", count=" + count +
                ", type_id=" + type_id +
                ", state=" + state +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", lastEditTime=" + lastEditTime +
                ", productImg=" + productImg +
                '}';
    }

    public Product() {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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

    public BigDecimal getOld_price() {
        return old_price;
    }

    public void setOld_price(BigDecimal old_price) {
        this.old_price = old_price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
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

    public List<ProductImg> getProductImg() {
        return productImg;
    }

    public void setProductImg(List<ProductImg> productImg) {
        this.productImg = productImg;
    }

    public Product(Integer product_id, String name, BigDecimal price, BigDecimal old_price, String info, Integer count, Integer type_id, Byte state, Byte isDel, Timestamp createTime, String creator, Timestamp lastEditTime, List<ProductImg> productImg) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.old_price = old_price;
        this.info = info;
        this.count = count;
        this.type_id = type_id;
        this.state = state;
        this.isDel = isDel;
        this.createTime = createTime;
        this.creator = creator;
        this.lastEditTime = lastEditTime;
        this.productImg = productImg;
    }


}
