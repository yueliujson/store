package com.easy.controller;

import com.easy.bean.OrderForm;
import com.easy.bean.OrderFormDir;
import com.easy.bean.User;
import com.easy.service.OrderFormServiceDao;
import com.easy.utils.PageInfo;
import com.easy.utils.ResultData;
import com.easy.utils.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderFormController {
    @Autowired
    OrderFormServiceDao orderFormServiceDao;

    @PostMapping("/orderForm")
    public ResultData save(@RequestBody OrderForm orderForm) {
        int save = orderFormServiceDao.save(orderForm);
        ResultData rd;
        if (save > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    @GetMapping("/orderForm/{id}")
    public ResultData get(@PathVariable int id) {
        OrderForm orderForm = orderFormServiceDao.get(id);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", orderForm);
        return rd;
    }

    @GetMapping("/orderForm")
    public ResultData list(OrderForm orderForm, PageInfo pageInfo) {
        List<OrderForm> list ;
        list = orderFormServiceDao.getList(orderForm, pageInfo);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", list);
        return rd;
    }

    @PutMapping("/orderForm")
    public ResultData edit(@RequestBody OrderForm orderForm) {
        int edit = orderFormServiceDao.edit(orderForm);
        ResultData rd;
        if (edit > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    @DeleteMapping("/orderForm/{id}")
    public ResultData delete(@PathVariable int id) {
        int delete = orderFormServiceDao.delete(id);
        ResultData rd;
        if (delete > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }


}
