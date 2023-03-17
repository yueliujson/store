package com.easy.controller;

import com.easy.bean.ProductKind;
import com.easy.bean.Shopping;
import com.easy.service.ShoppingServiceDao;
import com.easy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    ShoppingServiceDao shoppingServiceDao;

    @PostMapping("/shopping")
    public ResultData save(@RequestBody Shopping shopping, HttpServletRequest request){
        System.out.println(shopping);
        int save = shoppingServiceDao.save(shopping,request);
        ResultData rd;
        if (save > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    @GetMapping("/shopping")
    public ResultData list( HttpServletRequest request){
        List<Shopping> list = shoppingServiceDao.list(request);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", list);
        return rd;
    }

    @DeleteMapping("/shopping/{id}")
    public ResultData delete(@PathVariable int id,HttpServletRequest request){
        int delete=shoppingServiceDao.delete(id,request);
        ResultData rd;
        if (delete > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
}
