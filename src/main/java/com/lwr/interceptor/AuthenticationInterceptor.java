package com.lwr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.lwr.constant.ConstantName;
import com.lwr.entity.User;

/**
 * 登录验证拦截器
 * 或者继承HandlerInterceptorAdapter（spring3.2之后的支持异步请求的拦截器适配器）
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User)request.getSession().getAttribute(ConstantName.SESSION_USER);
        if(user !=null && !"".equals(user.getLoginId())) {
            return true;
        }
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/login.jsp");
        return false;
    }

}
