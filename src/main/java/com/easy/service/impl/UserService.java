package com.easy.service.impl;

import com.easy.bean.User;
import com.easy.controller.UserController;
import com.easy.dao.UserDao;
import com.easy.filter.LoginFilter;
import com.easy.service.UserServiceDao;
import com.easy.utils.JWTUtil;
import com.easy.utils.MD5;
import com.easy.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserServiceDao {
    @Autowired
    UserDao userDao;
//注册
    @Override
    public int save(User user) {
        Date date = UserController.time.get(user.getEmail());
        if (new Date().getTime() - date.getTime() < 1000 * 60) {
            if (userDao.isExist(user)==0) {
                user.setUserpass(MD5.MD5Hex(user.getUserpass()));
                return userDao.save(user);
            }
        }
        return 0;
    }
//一次性注册多个
    @Override
    public int saveUsers(List<User> user) {
        int save = userDao.saveUsers(user);
        return save;
    }

    @Override
    public int count(User user) {
        return userDao.count(user);
    }
//退出
    @Override
    public boolean exit(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> map = JWTUtil.decodeJWT(token);
        String username = (String) map.get("username");
        //清除登录记录
        boolean remove = LoginFilter.list.remove(username);
        return remove;
    }

    @Override
    public int edit(User userA, HttpServletRequest request) {
        String newPass = userA.getNewPass();
        String password = userA.getUserpass();
        String token = request.getHeader("token");
        Map<String, Object> map = JWTUtil.decodeJWT(token);
        String username = (String) map.get("username");
        User user = userDao.login(username);
        int edit = 0;
        if (user != null) {
            if (MD5.equals(password, user.getUserpass())) {
                String s = MD5.MD5Hex(newPass);
                edit = userDao.editPass(s, user.getUser_id());
            }
        }
        return edit;
    }
//最后一次登录的时间
    @Override
    public void setLastLoginTime(Integer user_id) {
        userDao.setLastLoginTime(user_id);
    }
//后台管理员添加用户

    /**
     * 默认密码 000000
     *
     */
    @Override
    public int adduser(User user) {
        String password = MD5.MD5Hex("000000");
        user.setUserpass(password);
        int save=0;
        if (userDao.isExist(user)==0) {
            save=userDao.adduser(user);
        }
        return save;
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }
//模糊查询
    @Override
    public List<User> list(User item, PageInfo pageInfo) {
        return userDao.list(item, pageInfo);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int edit(User user) {
        return userDao.edit(user);
    }


    public User login(String username, String password) {
        User user = userDao.login(username);
        if (user != null) {
            if (!MD5.equals(password, user.getUserpass())) {
                return null;
            }
        }
        return user;
    }
}
