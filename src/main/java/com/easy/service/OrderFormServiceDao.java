package com.easy.service;

import com.easy.bean.OrderForm;
import com.easy.utils.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderFormServiceDao {
    int save(OrderForm orderForm);

    OrderForm get(int id);

    List<OrderForm> list(Integer user_id);

    int edit(OrderForm orderForm);

    int delete(int id);

    List<OrderForm> getList(OrderForm orderForm, PageInfo pageInfo);

    List<OrderForm> getListPer(OrderForm orderForm, PageInfo pageInfo, HttpServletRequest request);

    int count(OrderForm orderForm);

}
