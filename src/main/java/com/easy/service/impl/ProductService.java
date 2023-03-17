package com.easy.service.impl;

import com.easy.bean.Product;
import com.easy.bean.ProductImg;
import com.easy.dao.ProductDao;
import com.easy.service.ProductServiceDao;
import com.easy.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品Service
 */
@Service
public class ProductService implements ProductServiceDao {

    @Autowired
    ProductDao productDao;

    /**
     * 根据id获取商品
     */
    @Override
    public Product get(int product_id) {
        return productDao.get(product_id);
    }

    /**
     * 模糊查询商品
     */
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
    public List<Product> getParent(int id) {
        List<Product> list = productDao.getParent(id);
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

    @Override
    public int editState(Product product) {
        return productDao.editState(product);
    }

    /**
     * 是否删除
     */
    @Override
    public int delete(int product_id) {
        return productDao.delete(product_id);
    }

    /**
     * 修改商品信息
     */
    @Override
    public int edit(Product item) {
        if (item.getState() != 0) {
            //如果不是下架，或者不是下架状态，商品信息不可修改
            return 0;
        }
        return productDao.edit(item);
    }

    /**
     * 添加商品
     */
    @Override
    public int save(Product item) {
        return productDao.save(item);
    }




}
