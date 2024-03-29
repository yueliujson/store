package com.easy.dao;

import com.easy.bean.ProductImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductImgDao {
    ProductImg get(int id);

    List<ProductImg> list(ProductImg productImg);

    int delete(int id);

    int save(@Param("item") ProductImg[] item);
}
