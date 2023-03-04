package com.easy.service;

import com.easy.bean.Product;

import java.util.List;

public interface ProductServiceDao {
    List<Product> list(Product item);

    Product get(int id);

    int delete(int id);

    int edit(Product item);

    int save(Product item);

}
