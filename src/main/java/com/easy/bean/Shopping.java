package com.easy.bean;

import lombok.Data;

/**
 * 购物车
 */
@Data
public class Shopping {
    /**用户id*/
    private Integer user_id;
    /**产品id*/
    private Integer product_id;
    /**产品数量*/
    private Integer count;
}
