package com.easy.controller;

import com.easy.bean.ProductKind;
import com.easy.service.ProductKindServiceDao;
import com.easy.utils.PageInfo;
import com.easy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProductKindController {
    @Autowired
    ProductKindServiceDao productKindServiceDao;
//查
    @GetMapping("/productKind/{id}")
    public ResultData get(@PathVariable int id) {
        ProductKind productKind = productKindServiceDao.get(id);
        ResultData rd;
        if (productKind != null) {
            rd = new ResultData(200, "success");
            rd.put("data", productKind);
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
//模糊查询（集合）
    @GetMapping("/productKind")
    public ResultData list(ProductKind productKind,PageInfo pageInfo) {
        List<ProductKind> list = productKindServiceDao.list(productKind,pageInfo);
        ResultData rd = new ResultData(200, "success");
        int count=productKindServiceDao.count(productKind);
        rd.put("data", list);
        rd.put("count",count);
        return rd;
    }
//保存产品
    @PostMapping("productKind")
    public ResultData save(@RequestBody ProductKind productKind, HttpServletRequest request){
        int save = productKindServiceDao.save(productKind,request);
        ResultData rd;
        if (save>0) {
            rd = new ResultData(200, "success");
        }else {
            rd=new ResultData(202,"fail");
        }
        return rd;
    }
//修改
    @PutMapping("productKind")
    public ResultData edit(@RequestBody ProductKind productKind){
        int edit = productKindServiceDao.edit(productKind);
        ResultData rd;
        if (edit>0){
            rd=new ResultData(200,"success");
        }else {
            rd=new ResultData(202,"fail");
        }
        return rd;
    }

    @DeleteMapping("/productKind/{id}")
    public ResultData delete(@PathVariable int id){
        int delete = productKindServiceDao.delete(id);
        ResultData rd;
        if (delete>0){
            rd=new ResultData(200,"success");
        }else {
            rd=new ResultData(202,"fail");
        }
        return rd;
    }
}
