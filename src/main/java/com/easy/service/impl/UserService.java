package com.easy.service.impl;

import com.easy.bean.User;
import com.easy.dao.UserDao;
import com.easy.service.UserServiceDao;
import com.easy.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户Service
 */
@Service
public class UserService implements UserServiceDao {
    @Autowired
    UserDao userDao;

    @Override
    public int save(User user) {
        if (!userDao.isExist(user)) {
            user.setUserpass(MD5.MD5Hex(user.getUserpass()));
            return userDao.save(user);
        }
        return 0;
    }

    @Override
    public int saveUsers(List<User> user) {
        int save = userDao.saveUsers(user);
        return save;
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public List<User> list(User item) {
        return userDao.list(item);
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
        return null;
    }
}
