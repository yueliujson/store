package com.easy.service;

import com.easy.bean.Product;
import com.easy.utils.PageInfo;

import java.util.List;

public interface ProductServiceDao {
    List<Product> list(Product item, PageInfo pageInfo);

    Product get(int id);

    int delete(int id);

    int edit(Product item);

    int save(Product item);

    int count(Product product);

    int count(int id);

    List<Product> getParent(int id, PageInfo pageInfo);

    int editState(Product product);
}
