package com.easy.dao;

import com.easy.bean.OrderForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderFormDao {
    int save(OrderForm orderForm) ;

    OrderForm get(int id);

    List<OrderForm> list(Integer user_id);

    int edit(OrderForm orderForm);

    int delete(int id);
}
