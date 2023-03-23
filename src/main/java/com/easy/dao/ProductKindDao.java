package com.easy.dao;

import com.easy.bean.ProductKind;
import com.easy.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductKindDao {
    ProductKind get(int id);

    List<ProductKind> list(@Param("item") ProductKind item,@Param("page") PageInfo page);

    int delete(int id);

    int edit(ProductKind item);

    int save(ProductKind item);

    List<ProductKind> getChildList(@Param("id") int id,@Param("page") PageInfo page);

    int count(ProductKind productKind);

    void deleteChild(int id);
}
