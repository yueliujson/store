package com.easy.service.impl;

import com.easy.bean.ProductKind;
import com.easy.dao.ProductKindDao;
import com.easy.service.ProductKindServiceDao;
import com.easy.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductKindService implements ProductKindServiceDao {
    @Autowired
    ProductKindDao productKindDao;

    @Override
    public ProductKind get(int id) {
        return productKindDao.get(id);
    }

    @Override
    public List<ProductKind> list(ProductKind item,PageInfo pageInfo) {
        return productKindDao.list(item,pageInfo);
    }

    @Override
    public int delete(int id) {
        return productKindDao.delete(id);
    }

    @Override
    public int edit(ProductKind item) {
        System.out.println(item);
        return productKindDao.edit(item);
    }

    @Override
    public int save(ProductKind item) {
        return productKindDao.save(item);
    }

    @Override
    public List<ProductKind> getChild(int id, PageInfo pageInfo) {
        return productKindDao.getChildList(id,pageInfo);
    }

    @Override
    public int count(ProductKind productKind) {
        return productKindDao.count(productKind);
    }

}
