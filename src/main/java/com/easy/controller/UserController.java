package com.easy.controller;

import com.easy.bean.User;
import com.easy.service.UserServiceDao;
import com.easy.utils.JWTUtil;
import com.easy.utils.PageInfo;
import com.easy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Controller
 */
@RestController
public class UserController {
    @Autowired
    UserServiceDao userServiceDao;

    @PostMapping("/login")
    public ResultData login(String username, String password) {
        User user = userServiceDao.login(username, password);
        ResultData rd;
        if (user!=null) {
            Map<String,Object> map=new HashMap();
            map.put("username",username);
            String token = JWTUtil.createToken(map);
            rd = new ResultData(200, "success");
            rd.put("data", token);
        }else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    @GetMapping("user")
    public ResultData list(User user, PageInfo pageInfo) {
        List<User> list = userServiceDao.list(user,pageInfo);
        int count=userServiceDao.count(user);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", list);
        rd.put("count",count);
        return rd;
    }

    @GetMapping("user/{id}")
    public ResultData get(@PathVariable int id) {
        User user = userServiceDao.get(id);
        ResultData resultData = new ResultData(200, "success");
        resultData.put("data", user);
        return resultData;
    }

    @DeleteMapping("user/{id}")
    public ResultData delete(@PathVariable int id) {
        int delete = userServiceDao.delete(id);
        ResultData rd;
        if (delete >= 1) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    @PutMapping("user")
    public ResultData edit(@RequestBody User user) {
        int edit = userServiceDao.edit(user);
        ResultData rd;
        if (edit >= 1) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }

    @PostMapping("/user")
    public ResultData save(@RequestBody User user) {
        int register = userServiceDao.save(user);
        ResultData rd;
        if (register > 0) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        rd.put("data", user);
        return rd;
    }


    @PostMapping("/users")
    public ResultData save(@RequestBody List<User> user) {
        int save=userServiceDao.saveUsers(user);
        ResultData rd;
        if (save > 0) {
            rd = new ResultData(200, "success");
            rd.put("data","保存成功了"+save+"条");
        } else {
            rd = new ResultData(202, "fail");
        }
        rd.put("data", user);
        return rd;
    }
}
