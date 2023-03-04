package com.easy.service;

import com.easy.bean.User;

import java.util.List;

public interface UserServiceDao {
    List<User> list(User item);

    User login(String username, String password);

    User get(int id);

    int delete(int id);

    int edit(User user);

    int save(User user);

    int saveUsers(List<User> user);
}
