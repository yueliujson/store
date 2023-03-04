package com.easy.controller;

import com.easy.bean.Address;
import com.easy.service.AddressServiceDao;
import com.easy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    AddressServiceDao addressServiceDao;

    /**
     * 储存地址
     */
    @PostMapping("/address")
    public ResultData save(@RequestBody Address address){
        int save=addressServiceDao.save(address);
        ResultData rd;
        if (save>0) {
            rd = new ResultData(200, "success");
        }else {
            rd=new ResultData(202,"fail");
        }
        return rd;
    }

    /**
     * 根据用户id获取地址
     */
    @GetMapping("/address/{id}")
    public ResultData get(@PathVariable int id){
        Address address=addressServiceDao.get(id);
        ResultData rd = new ResultData(200, "success");
        rd.put("data",address);
        return rd;
    }

    @DeleteMapping("/address/{id}")
    public ResultData delete(@PathVariable int id){
        int delete=addressServiceDao.delete(id);
        ResultData rd;
        if (delete>0) {
            rd = new ResultData(200, "success");
        }else {
            rd=new ResultData(202,"fail");
        }
        return rd;
    }
}
