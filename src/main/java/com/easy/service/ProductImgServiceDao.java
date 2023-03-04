package com.easy.service;

import com.easy.bean.ProductImg;

import java.util.List;

public interface ProductImgServiceDao {
    List<ProductImg> list(ProductImg item);

    ProductImg get(int id);

    int delete(int id);

    int edit(ProductImg item);

    int save(ProductImg item);
}
