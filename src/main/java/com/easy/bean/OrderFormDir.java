package com.easy.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单详情
 */
@Data
public class OrderFormDir {
  /**主键*/
  private Integer id;
  /**订单号*/
  private Integer order_id;
  /**产品号*/
  private Integer product_id;
  /**数量*/
  private Integer count;
  /**价格*/
  private BigDecimal price;
}
