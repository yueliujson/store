package com.easy.dao;

import com.easy.bean.OrderForm;
import com.easy.bean.OrderFormDir;
import com.easy.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderFormDao {
    int save(OrderForm orderForm) ;

    OrderForm get(int id);

    List<OrderForm> list(Integer user_id);

    int edit(OrderForm orderForm);

    int delete(int id);

    List<OrderForm> getList(@Param("orderForm") OrderForm orderForm,@Param("pageInfo") PageInfo pageInfo);

    List<OrderForm> getListPer(@Param("orderForm") OrderForm orderForm,@Param("pageInfo") PageInfo pageInfo,@Param("user_id") int user_id);

    void saveOrderFormDir(OrderFormDir orderFormDir);

    int count(OrderForm orderForm);
}
