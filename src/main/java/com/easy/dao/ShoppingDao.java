package com.easy.dao;

import com.easy.bean.Shopping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingDao {
    int save(Shopping shopping);

    Shopping isExist(Shopping shopping);

    Integer updateCount(Shopping shopping);

    List<Shopping> list(Integer user_id);

    int delete(@Param("user_id") int user_id, @Param("product_id") int product_id);

    int getCount(Shopping shopping);
}
