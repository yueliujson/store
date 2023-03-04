package com.easy.service;

import com.easy.bean.Address;

import java.util.List;

public interface AddressServiceDao {
    int save(Address address);

    Address get(int id);

    int delete(int id);

    List<Address> list(Integer user_id);
}
