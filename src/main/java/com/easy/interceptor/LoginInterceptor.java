//package com.easy.interceptor;
//
//import com.easy.utils.JWTUtil;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 登录拦截器
// */
//public class LoginInterceptor implements HandlerInterceptor {
//    public static List<String> list = new ArrayList<>();
//
//    @Override
//    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
//
//        String token = req.getHeader("token");
//        if (token != null) {
//            Map<String, Object> stringObjectMap = JWTUtil.decodeJWT(token);
//            String username = (String) stringObjectMap.get("username");
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).equals(username)) {
//                    return true;
//                }
//            }
//        }
//        resp.setStatus(401);
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}
