package com.easy.service.impl;

import com.easy.bean.Shopping;
import com.easy.dao.ShoppingDao;
import com.easy.dao.UserDao;
import com.easy.service.ShoppingServiceDao;
import com.easy.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingService implements ShoppingServiceDao {
    @Autowired
    ShoppingDao shoppingDao;

    @Autowired
    UserDao userDao;

    @Override
    public int save(Shopping shopping, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> stringObjectMap = JWTUtil.decodeJWT(token);
        String username = (String) stringObjectMap.get("username");
        shopping.setUser_id(userDao.getUserid(username));
        int count = shoppingDao.getCount(shopping);
        int save=0;
        if (count < 10) {
            Shopping isExist = shoppingDao.isExist(shopping);
            if (isExist != null) {
                shopping.setCount(shopping.getCount() + isExist.getCount());
                save = shoppingDao.updateCount(shopping);
            } else {
                save = shoppingDao.save(shopping);
            }
        }
        return save;
    }

    @Override
    public List<Shopping> list(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> stringObjectMap = JWTUtil.decodeJWT(token);
        String username = (String) stringObjectMap.get("username");
        List<Shopping> list = shoppingDao.list(userDao.getUserid(username));
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProduct().getProductImg() != null) {
                    for (int j = 0; j < list.get(i).getProduct().getProductImg().size(); j++) {
                        list.get(i).getProduct().getProductImg().get(j).setImgUrl("http://localhost/static/img/" + list.get(i).getProduct().getProductImg().get(j).getImgUrl());
                    }
                }
            }
        }
        return list;
    }

    @Override
    public int delete(int product_id, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> stringObjectMap = JWTUtil.decodeJWT(token);
        String username = (String) stringObjectMap.get("username");
        int user_id = userDao.getUserid(username);
        return shoppingDao.delete(user_id, product_id);
    }
}
