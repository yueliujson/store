package com.easy.service.impl;

import com.easy.bean.OrderForm;
import com.easy.dao.OrderFormDao;
import com.easy.service.OrderFormServiceDao;
import com.easy.utils.SnowFlakeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
