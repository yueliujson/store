package com.easy.dao;

import com.easy.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    int save(User user);

    boolean isExist(User user);

    User get(int id);

    List<User> list(User item);

    int delete(int id);

    int edit(User user);

    int saveUsers(@Param("user") List<User> user);
}
