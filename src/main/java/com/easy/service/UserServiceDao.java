package com.easy.service;

import com.easy.bean.User;
import com.easy.utils.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserServiceDao {
    List<User> list(User item, PageInfo pageInfo);

    User login(String username, String password);

    User get(int id);

    int delete(int id);

    int edit(User user);

    int save(User user);

    int saveUsers(List<User> user);

    int count(User user);

    boolean exit(HttpServletRequest request);

    int edit(User user, HttpServletRequest request);
}
