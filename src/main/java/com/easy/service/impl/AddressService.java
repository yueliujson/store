package com.easy.service.impl;

import com.easy.bean.Address;
import com.easy.dao.AddressDao;
import com.easy.service.AddressServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements AddressServiceDao {
    @Autowired
    AddressDao addressDao;
    @Override
    public int save(Address address) {
        int save=addressDao.save(address);
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
    public List<Address> list(Integer user_id) {
        return addressDao.list(user_id);
    }

    @Override
    public int edit(Address address) {
        return addressDao.edit(address);
    }

}
