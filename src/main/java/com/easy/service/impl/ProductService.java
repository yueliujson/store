package com.easy.service.impl;

import com.easy.bean.Product;
import com.easy.bean.ProductImg;
import com.easy.dao.ProductDao;
import com.easy.dao.UserDao;
import com.easy.service.ProductServiceDao;
import com.easy.utils.JWTUtil;
import com.easy.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

//商品
@Service
public class ProductService implements ProductServiceDao {

    @Autowired
    ProductDao productDao;
    @Autowired
    UserDao userDao;

//根据产品id获取商品
    @Override
    public Product get(int product_id) {
        return productDao.get(product_id);
    }


//模糊查询商品
    @Override
    public List<Product> list(Product item, PageInfo pageInfo) {
        List<Product> list = productDao.list(item,pageInfo);
        return picturePath(list);
    }

    @Override
    public int count(Product product) {
        return productDao.count(product);
    }

    @Override
    public int count(int id) {
        return productDao.getCount(id);
    }

    @Override
    public List<Product> getParent(int id, PageInfo pageInfo) {
        List<Product> list = productDao.getParent(id,pageInfo);
        return picturePath(list);
    }

    private List<Product> picturePath(List<Product> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                List<ProductImg> productImg = list.get(i).getProductImg();
                if (productImg!=null){
                    for (int j = 0; j < productImg.size(); j++) {
                        productImg.get(j).setImgUrl("http://localhost/static/img/"+productImg.get(j).getImgUrl());
                    }
                }
            }
        }
        return list;
    }
//该状态
    @Override
    public int editState(Product product) {
        return productDao.editState(product);
    }

    @Override
    public int delete(int product_id) {
        return productDao.delete(product_id);
    }

 //修改商品信息
    @Override
    public int edit(Product item) {
        if (item.getState() != 0) {
            //如果不是下架，或者不是下架状态，商品信息不可修改
            return 0;
        }
        return productDao.edit(item);
    }


//添加商品
    @Override
    public int save(Product item, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> map = JWTUtil.decodeJWT(token);
        String username = (String) map.get("username");
        String name=userDao.getName(username);
        item.setCreator(name);
        return productDao.save(item);
    }




}
