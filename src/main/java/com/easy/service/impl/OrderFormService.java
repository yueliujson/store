package com.easy.service.impl;

import com.easy.bean.OrderForm;
import com.easy.dao.OrderFormDao;
import com.easy.service.OrderFormServiceDao;
import com.easy.utils.SnowFlakeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFormService implements OrderFormServiceDao {
    private SnowFlakeUtils snowFlakeUtils = new SnowFlakeUtils(0, 0);
    @Autowired
    OrderFormDao orderFormDao;
    @Override
    public int save(OrderForm orderForm) {
        orderForm.setOrder_id("c" + snowFlakeUtils.nextId());
        return orderFormDao.save(orderForm);
    }

    @Override
    public OrderForm get(int id) {
        return orderFormDao.get(id);
    }

    @Override
    public List<OrderForm> list(Integer user_id) {
        return orderFormDao.list(user_id);
    }

    @Override
    public int edit(OrderForm orderForm) {
        return orderFormDao.edit(orderForm);
    }

    @Override
    public int delete(int id) {
        return orderFormDao.delete(id);
    }
}
