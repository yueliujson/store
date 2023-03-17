package com.easy.dao;

import com.easy.bean.Shopping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingDao {
    int save(Shopping shopping);

    Shopping isExist(Shopping shopping);

    Integer updateCount(Shopping shopping);

    List<Shopping> list(Integer user_id);
}
