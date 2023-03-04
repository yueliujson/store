package com.easy.dao;

import com.easy.bean.ProductKind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductKindDao {
    ProductKind get(int id);

    List<ProductKind> list(ProductKind item);

    int delete(int id);

    int edit(ProductKind item);

    int save(ProductKind item);
}
