package com.easy.controller;


import com.easy.bean.Product;
import com.easy.service.ProductServiceDao;
import com.easy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品controller
 */
@RestController
public class ProductController {
    @Autowired
    ProductServiceDao productServiceDao;

    /**
     * 查询商品,模糊查询
     */
    @GetMapping("/product")
    public ResultData list(Product product) {
        List<Product> list = productServiceDao.list(product);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", list);
        return rd;
    }
    @GetMapping("/product/{id}")
    public ResultData get(@PathVariable int id) {
        Product product = productServiceDao.get(id);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", product);
        return rd;
    }

    /**
     * 添加商品
     */
    @PostMapping("product")
    public ResultData save(@RequestBody Product product) {
        int save = productServiceDao.save(product);
        ResultData rd;
        if (save>0) {
            rd = new ResultData(200, "success");
        }else {
            rd=new ResultData(202,"fail");
        }
        return rd;
    }

    /**
     * 修改商品信息
     */
    @PutMapping("product")
    public ResultData edit(@RequestBody Product product) {
        int edit = productServiceDao.edit(product);
        ResultData rd;
        if (edit > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    /**
     * 删除商品信息
     */
    @DeleteMapping("product/{id}")
    public ResultData delete(@PathVariable int id) {
        int delete = productServiceDao.delete(id);
        ResultData rd;
        if (delete > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
}
