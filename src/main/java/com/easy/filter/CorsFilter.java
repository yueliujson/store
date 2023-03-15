//package com.easy.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter
//public class CorsFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse resp= (HttpServletResponse) response;
//        resp.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST");
//        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        resp.setHeader("Access-Control-Max-Age", "86400");
//        chain.doFilter(request,resp);
//    }
//}
