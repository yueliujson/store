package com.easy.service;

import com.easy.bean.OrderForm;

import java.util.List;

public interface OrderFormServiceDao {
    int save(OrderForm orderForm);

    OrderForm get(int id);

    List<OrderForm> list(Integer user_id);

    int edit(OrderForm orderForm);

    int delete(int id);
}
