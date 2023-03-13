package com.easy.dao;

import com.easy.bean.Product;
import com.easy.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {
    Product get(int id);

    List<Product> list(@Param("item") Product item,@Param("pageInfo") PageInfo pageInfo);

    int delete(int id);

    int edit(Product item) ;

    int save(Product item);

    int count(Product product);

    List<Product> getParent(int id);

    int getCount(int id);
}
