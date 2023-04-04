package com.easy.controller;


import com.easy.bean.Product;
import com.easy.service.ProductServiceDao;
import com.easy.utils.PageInfo;
import com.easy.utils.ResultData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


// 商品

@RestController
public class ProductController {
    @Autowired
    ProductServiceDao productServiceDao;

//查询商品,模糊查询
    @GetMapping("/product")
    public ResultData list(Product product, PageInfo pageInfo) {
        List<Product> list = productServiceDao.list(product,pageInfo);
        int count=productServiceDao.count(product);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", list);
        rd.put("count",count);
        return rd;
    }
//通过id查
    @GetMapping("/product/{id}")
    public ResultData get(@PathVariable int id) {
        Product product = productServiceDao.get(id);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", product);
        return rd;
    }
//获取父类id
    @GetMapping("/productParent/{id}")
    public ResultData getParent(@PathVariable int id,@RequestBody PageInfo pageInfo) {
        System.out.println(pageInfo);
        List<Product> product = productServiceDao.getParent(id,pageInfo);
        int count=productServiceDao.count(id);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", product);
        rd.put("count",count);
        return rd;
    }

//添加商品
    @PostMapping("product")
    public ResultData save(@RequestBody Product product, HttpServletRequest request) {
        int save = productServiceDao.save(product,request);
        ResultData rd;
        if (save > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }


//修改商品信息
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
//改产品状态
    @PutMapping("product/state")
    public ResultData editState(@RequestBody Product product) {
        int edit = productServiceDao.editState(product);
        ResultData rd;
        if (edit > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }


//删除商品信息
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
