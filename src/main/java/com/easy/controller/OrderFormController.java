package com.easy.controller;

import com.easy.bean.OrderForm;
import com.easy.service.OrderFormServiceDao;
import com.easy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
