package com.easy.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

//  订单详情

@Data
public class OrderFormDir {
//  主键
  private Integer id;
//  订单号
  private String order_id;
//  产品号
  private Integer product_id;
//  数量
  private Integer count;
//  价格
  private BigDecimal price;
//  商品名
  private String name;

  public OrderFormDir(Integer id, String order_id, Integer product_id, Integer count, BigDecimal price, String name) {
    this.id = id;
    this.order_id = order_id;
    this.product_id = product_id;
    this.count = count;
    this.price = price;
    this.name = name;
  }

  public OrderFormDir() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrder_id() {
    return order_id;
  }

  public void setOrder_id(String order_id) {
    this.order_id = order_id;
  }

  public Integer getProduct_id() {
    return product_id;
  }

  public void setProduct_id(Integer product_id) {
    this.product_id = product_id;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
