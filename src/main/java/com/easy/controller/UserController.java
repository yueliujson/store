package com.easy.controller;

import com.easy.bean.User;
import com.easy.filter.LoginFilter;
import com.easy.service.SendMailServiceDao;
import com.easy.service.UserServiceDao;
import com.easy.service.impl.SendMailServiceImpl;
import com.easy.utils.JWTUtil;
import com.easy.utils.PageInfo;
import com.easy.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 用户Controller

@RestController
public class UserController {
    @Autowired
    UserServiceDao userServiceDao;


    @RequestMapping("/exception")
    @ResponseBody
    public static ResultData exception() {
        return new ResultData(401, "fail");
    }
//登录
    @PostMapping("/login")
    public ResultData login(@RequestBody User userLogin) {
        String username = userLogin.getUsername();
        String password = userLogin.getUserpass();
        User user = userServiceDao.login(username, password);
        ResultData rd;
        if (user != null) {
            user.setUserpass("");
            Map<String, Object> map = new HashMap<>();
            map.put("username", username);
            String token = JWTUtil.createToken(map);
            rd = new ResultData(200, "success");
            LoginFilter.list.add(username);
            rd.put("token", token);
            rd.put("id",user.getUser_id());
            rd.put("name",user.getName());
            rd.put("state",user.getState());
            userServiceDao.setLastLoginTime(user.getUser_id());
        } else {
            rd = new ResultData(401, "fail");
        }
        return rd;
    }



    private Map<String,String> map=new HashMap<>();
    //定义一个储存时间的map
    public static Map<String, Date> time=new HashMap<>();
//发送验证码
    @GetMapping("/authCode/{email}")
    public ResultData code(@PathVariable String email){
        SendMailServiceDao sendMailServiceDao=new SendMailServiceImpl();
        String authCode="";
        for (int i = 0; i < 6; i++) {
            authCode+=(int)(Math.random()*10)+"";
        }
        map.put(email,authCode);
        time.put(email,new Date());
        try {
            sendMailServiceDao.sendQQEmail(email,authCode,"123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultData rd = new ResultData(200, "success");
        rd.put("authCode",authCode);
        return rd;
    }
//退出登录
    @GetMapping("/exit")
    public ResultData exit(HttpServletRequest request) {
        ResultData rd;
        userServiceDao.exit(request);
        rd = new ResultData(200, "success");
        return rd;
    }
//模糊查询
    @GetMapping("user")
    public ResultData list(User user, PageInfo pageInfo) {
        List<User> list = userServiceDao.list(user, pageInfo);
        int count = userServiceDao.count(user);
        ResultData rd = new ResultData(200, "success");
        rd.put("data", list);
        rd.put("count", count);
        return rd;
    }
//通过id查
    @GetMapping("user/{id}")
    public ResultData get(@PathVariable int id) {
        User user = userServiceDao.get(id);
        ResultData resultData = new ResultData(200, "success");
        resultData.put("data", user);
        return resultData;
    }
//软删除
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
//修改密码
    @PutMapping("user")
    public ResultData edit(@RequestBody User user, HttpServletRequest request) {
        int edit = userServiceDao.edit(user,request);
        ResultData rd;
        if (edit >= 1) {
            rd = new ResultData(200, "success");
        } else {
            rd = new ResultData(202, "fail");
        }
        return rd;
    }
//修改用户信息
    @PutMapping("usermessage")
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
//注册
    @PostMapping("/register")
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
//添加用户
    @PostMapping("/adduser")
    public ResultData adduser(@RequestBody User user) {
        int register = userServiceDao.adduser(user);
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
        int save = userServiceDao.saveUsers(user);
        ResultData rd;
        if (save > 0) {
            rd = new ResultData(200, "success");
            rd.put("data", "保存成功了" + save + "条");
        } else {
            rd = new ResultData(202, "fail");
        }
        rd.put("data", user);
        return rd;
    }
//判断是否登录
    @GetMapping("isLogin")
    public ResultData isLogin(HttpServletRequest request){
        String token = request.getHeader("token");
        if (token==null){
            return new ResultData(202,"fail");
        }
        Map<String, Object> map = JWTUtil.decodeJWT(token);
        String username = (String) map.get("username");
        ResultData rd = new ResultData(200, "success");
        rd.put("username",username);
        return rd;
    }
}
