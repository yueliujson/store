package com.easy.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 产品详情
 */
@Data
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
}
