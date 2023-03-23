package com.easy.service.impl;

import com.easy.bean.ProductKind;
import com.easy.dao.ProductDao;
import com.easy.dao.ProductKindDao;
import com.easy.dao.UserDao;
import com.easy.service.ProductKindServiceDao;
import com.easy.utils.JWTUtil;
import com.easy.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class ProductKindService implements ProductKindServiceDao {
    @Autowired
    ProductKindDao productKindDao;
    @Autowired
    UserDao userDao;
    @Override
    public ProductKind get(int id) {
        return productKindDao.get(id);
    }

    @Override
    public List<ProductKind> list(ProductKind item,PageInfo pageInfo) {
        return productKindDao.list(item,pageInfo);
    }

    @Override
    @Transactional
    public int delete(int id) {
        productKindDao.deleteChild(id);
        return productKindDao.delete(id);
    }

    @Override
    public int edit(ProductKind item) {
        System.out.println(item);
        return productKindDao.edit(item);
    }

    @Override
    public int save(ProductKind item, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> map = JWTUtil.decodeJWT(token);
        String username = (String) map.get("username");
        String name=userDao.getName(username);
        item.setCreator(name);
        return productKindDao.save(item);
    }

    @Override
    public List<ProductKind> getChild(int id, PageInfo pageInfo) {
        return productKindDao.getChildList(id,pageInfo);
    }

    @Override
    public int count(ProductKind productKind) {
        return productKindDao.count(productKind);
    }

}
