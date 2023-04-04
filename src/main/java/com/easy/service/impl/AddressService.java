package com.easy.service.impl;

import com.easy.bean.Address;
import com.easy.dao.AddressDao;
import com.easy.dao.UserDao;
import com.easy.service.AddressServiceDao;
import com.easy.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class AddressService implements AddressServiceDao {
    @Autowired
    AddressDao addressDao;
    @Autowired
    UserDao userDao;
// 保存
    @Override
    public int save(Address address, HttpServletRequest request) {
        int user_id = getUser_id(request);
        address.setUser_id(user_id);
        List<Address> list = list(request);
        int save=0;
        if (list == null) {
            address.setState((byte) 1);
        }
        save=addressDao.save(address);
        return save;
    }

    @Override
    public Address get(int id) {
        return addressDao.get(id);
    }

    @Override
    public int delete(int id) {
        return addressDao.delete(id);
    }

    @Override
    public List<Address> list(HttpServletRequest request) {
        int user_id = getUser_id(request);
        return addressDao.list(user_id);
    }

    @Override
    public int edit(Address address, HttpServletRequest request) {
        if(address.getState()!=null){
            int user_id = getUser_id(request);
            addressDao.setDefaultNo(user_id);
            address.setState((byte)1);
        }
        return addressDao.edit(address);
    }

    private int getUser_id(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> stringObjectMap = JWTUtil.decodeJWT(token);
        String username = (String) stringObjectMap.get("username");
        int userid = userDao.getUserid(username);
        return userid;
    }
}
