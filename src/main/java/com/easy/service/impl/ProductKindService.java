package com.easy.service.impl;

import com.easy.bean.ProductKind;
import com.easy.dao.ProductKindDao;
import com.easy.service.ProductKindServiceDao;
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
    public List<ProductKind> list(ProductKind item) {
        return productKindDao.list(item);
    }

    @Override
    public int delete(int id) {
        return productKindDao.delete(id);
    }

    @Override
    public int edit(ProductKind item) {
        return productKindDao.edit(item);
    }

    @Override
    public int save(ProductKind item) {
        return productKindDao.save(item);
    }

}
