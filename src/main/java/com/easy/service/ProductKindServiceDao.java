package com.easy.service;

import com.easy.bean.ProductKind;
import com.easy.utils.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductKindServiceDao {
    List<ProductKind> list(ProductKind item,PageInfo pageInfo);

    ProductKind get(int id);

    int delete(int id);

    int edit(ProductKind item);

    int save(ProductKind item, HttpServletRequest request);

    List<ProductKind> getChild(int id, PageInfo pageInfo);

    int count(ProductKind productKind);
}
