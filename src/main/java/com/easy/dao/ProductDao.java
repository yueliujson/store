package com.easy.dao;

import com.easy.bean.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    Product get(int id);

    List<Product> list(Product item);

    int delete(int id);

    int edit(Product item) ;

    int save(Product item);
}
