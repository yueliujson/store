package com.easy.bean;

import lombok.Data;

/**
 * 产品图片
 */
@Data
public class ProductImg {
    /**主键*/
    private Integer id;
    /**产品号*/
    private Integer product_id;
    /**图片链接地址*/
    private String imgUrl;
    /**排序*/
    private Integer sort;
}
