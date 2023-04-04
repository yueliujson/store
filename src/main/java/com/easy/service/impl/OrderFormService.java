package com.easy.service.impl;

import com.easy.bean.OrderForm;
import com.easy.dao.OrderFormDao;
import com.easy.dao.UserDao;
import com.easy.service.OrderFormServiceDao;
import com.easy.utils.JWTUtil;
import com.easy.utils.PageInfo;
import com.easy.utils.SnowFlakeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class OrderFormService implements OrderFormServiceDao {
    private SnowFlakeUtils snowFlakeUtils = new SnowFlakeUtils(0, 0);
    @Autowired
    OrderFormDao orderFormDao;

    @Autowired
    UserDao userDao;

    @Override
//事务注解 关联表 如果出现异常 直接回滚
    @Transactional
    public int save(OrderForm orderForm) {
        orderForm.setOrder_id("c" + snowFlakeUtils.nextId());
        for (int i = 0; i < orderForm.getOrderFormDirs().size(); i++) {
            orderForm.getOrderFormDirs().get(i).setOrder_id(orderForm.getOrder_id());
            orderFormDao.saveOrderFormDir(orderForm.getOrderFormDirs().get(i));
        }
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

    @Override
    public List<OrderForm> getList(OrderForm orderForm, PageInfo pageInfo) {

        return orderFormDao.getList(orderForm, pageInfo);
    }

    @Override
    public List<OrderForm> getListPer(OrderForm orderForm, PageInfo pageInfo, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> stringObjectMap = JWTUtil.decodeJWT(token);
        String username = (String) stringObjectMap.get("username");
        int user_id = userDao.getUserid(username);
        return orderFormDao.getListPer(orderForm, pageInfo, user_id);
    }

    @Override
    public int count(OrderForm orderForm) {
        return orderFormDao.count(orderForm);
    }
}
