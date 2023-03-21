package com.easy.controller;

import com.easy.bean.Address;
import com.easy.bean.User;
import com.easy.service.AddressServiceDao;
import com.easy.utils.ResultData;
import com.easy.utils.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressServiceDao addressServiceDao;

    /**
     * 储存地址
     */
    @PostMapping("/address")
    public ResultData save(@RequestBody Address address,HttpServletRequest request) {
        int save = addressServiceDao.save(address,request);
        ResultData rd;
        if (save > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    /**
     * 根据id获取地址
     */
    @GetMapping("/address/{id}")
    public ResultData get(@PathVariable int id) {
        Address address = addressServiceDao.get(id);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", address);
        return rd;
    }

    /**
     * 根据用户id获取地址
     */
    @GetMapping("/address")
    public ResultData list(HttpServletRequest request) {
        List<Address> list = addressServiceDao.list(request);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", list);
        return rd;
    }

    /**
     * 删除
     */
    @DeleteMapping("/address/{id}")
    public ResultData delete(@PathVariable int id) {
        int delete = addressServiceDao.delete(id);
        ResultData rd;
        if (delete > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    /**
     * 修改
     */
    @PutMapping("/address")
    public ResultData edit(@RequestBody Address address) {
        int edit = addressServiceDao.edit(address);
        ResultData rd;
        if (edit > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
}
