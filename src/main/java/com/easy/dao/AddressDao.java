package com.easy.dao;

import com.easy.bean.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressDao {
    int save(Address address);

    Address get(int id);

    int delete(int id);

    List<Address> list(Integer user_id);
}
