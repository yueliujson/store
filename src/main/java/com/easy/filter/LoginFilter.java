package com.easy.filter;

import com.easy.utils.JWTUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = {"/user","/orderForm","/address"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
    public static List<String> list = new ArrayList<>();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp= (HttpServletResponse) response;
        String token = req.getHeader("token");
        if (token != null) {
            Map<String, Object> stringObjectMap = JWTUtil.decodeJWT(token);
            String username = (String) stringObjectMap.get("username");
            boolean flag=true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(username)) {
                    flag = false;
                    chain.doFilter(req, response);
                }
            }
            if(flag) {
                req.getRequestDispatcher("/exception").forward(req,resp);
            }
        }else {
            req.getRequestDispatcher("/exception").forward(req,resp);
        }
    }
}
