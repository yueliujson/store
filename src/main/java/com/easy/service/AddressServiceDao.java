package com.easy.service;

import com.easy.bean.Address;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AddressServiceDao {
    int save(Address address, HttpServletRequest request);

    Address get(int id);

    int delete(int id);

    List<Address> list(HttpServletRequest request);

    int edit(Address address, HttpServletRequest request);
}
