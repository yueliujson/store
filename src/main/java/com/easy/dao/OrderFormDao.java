package com.easy.dao;

import com.easy.bean.OrderForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderFormDao {
    int save(OrderForm orderForm) ;
}
