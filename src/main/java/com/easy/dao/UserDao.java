package com.easy.dao;

import com.easy.bean.User;
import com.easy.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    int save(User user);

    boolean isExist(User user);

    User get(int id);

    List<User> list(@Param("user") User user,@Param("page") PageInfo page);

    int delete(int id);

    int edit(User user);

    int saveUsers(@Param("user") List<User> user);

    int count(User user);

    int getUserid(String username);

    User login(String username);

    int editPass(@Param("newPass") String newPass,@Param("user_id") Integer user_id);

    void setLastLoginTime(Integer user_id);
}
