package com.easy.service;

import com.easy.bean.Shopping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ShoppingServiceDao {
    int save(Shopping shopping, HttpServletRequest request);

    List<Shopping> list(HttpServletRequest request);
}
