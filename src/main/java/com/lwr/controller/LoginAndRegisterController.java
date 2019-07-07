package com.lwr.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwr.constant.ConstantName;
import com.lwr.entity.User;
import com.lwr.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginAndRegisterController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, User user)
            throws ServletException, IOException {
        if (StringUtils.isEmpty(user.getLoginId()) || StringUtils.isEmpty(user.getPassword())) {
            request.setAttribute("msg", "用户名和密码不能为空");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return null;
        }
        User loginUser = userService.getLoginUser(user);
        if (loginUser == null || StringUtils.isEmpty(user.getLoginId())) {
            request.setAttribute("msg", "账号或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return null;
        }
        request.getSession().setAttribute(ConstantName.SESSION_USER, loginUser);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/user/index");
        return null;
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register/register";
    }

    @RequestMapping("/saveRegister")
    public String saveRegister(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        if(!doCheck(user)) {
            request.setAttribute("msg", "注册失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return null;
        }
        try {
            user.setCreateDate(new Date());
            userService.addUser(user);
        }catch (Exception e) {
            request.setAttribute("msg", "注册失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return null;
        }
        request.setAttribute("msg", "注册成功，请重新登录");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return null;
    }

    private boolean doCheck(User user) {
        //check the user params
        return true;
    }

}
