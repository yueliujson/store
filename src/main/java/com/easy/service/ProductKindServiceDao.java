package com.easy.service;

import com.easy.bean.ProductKind;

import java.util.List;

public interface ProductKindServiceDao {
    List<ProductKind> list(ProductKind item);

    ProductKind get(int id);

    int delete(int id);

    int edit(ProductKind item);

    int save(ProductKind item);
}
