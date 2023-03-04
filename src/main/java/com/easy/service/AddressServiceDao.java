package com.easy.service;

import com.easy.bean.Address;

public interface AddressServiceDao {
    int save(Address address);

    Address get(int id);

    int delete(int id);
}
