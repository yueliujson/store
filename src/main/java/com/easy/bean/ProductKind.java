package com.easy.bean;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 产品分类
 */
@Data
public class ProductKind {
    /**产品id*/
    private Integer id;
    /**产品名*/
    private String name;
    /**介绍*/
    private String info;
    /**父级*/
    private Integer parent_id;
    /**上下架*/
    private Integer state;
    /**创建时间*/
    private Timestamp createTime;
    /**创建者*/
    private String creator;
    /**最后修改时间*/
    private Timestamp lastEditTime;
    /**是否删除*/
    private Integer isDel;
    /**子类*/
    private List<ProductKind> productKind;
    /**具体*/
    private List<Product> products;
}
