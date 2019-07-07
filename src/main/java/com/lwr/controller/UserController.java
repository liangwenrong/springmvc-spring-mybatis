package com.lwr.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lwr.constant.ConstantName;
import com.lwr.entity.User;
import com.lwr.form.UserForm;
import com.lwr.service.UserService;
import com.lwr.utils.FileUtil;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        User user = (User)request.getSession().getAttribute(ConstantName.SESSION_USER);
        request.setAttribute("user", user);
        return "index";
    }
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request, HttpServletResponse response,UserForm form) {
        List<User> userList = userService.queryUserList(form);
        request.setAttribute("form", form);
        request.setAttribute("userList", userList);
        return "user/userList";
    }
    
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/login.jsp");
        return null;
    }
    
    @RequestMapping("/toUpload")
    public String toUpload() {
        return "upload/upload";
    }
    
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest mutipartReq) throws ServletException, IOException {
        List<MultipartFile> files = mutipartReq.getFiles("myFile");
//        MultipartFile file = mutipartReq.getFile("myFile");//获取集合中的第一个
        List<MultipartFile> files1 = mutipartReq.getFiles("myFile1");
        String forder = "F:/upload/";
        if(files.size() > 0 || files1.size() > 0) {//文件个数大于0
            File dir = new File(forder);
            if(!dir.exists()) {
                dir.mkdirs();
            }
        }
        for (MultipartFile multipartFile : files) {
            String fileName = multipartFile.getOriginalFilename();
            if(fileName!=null && !"".equals(fileName)) {//有文件名称证明不是空文件
                String name = fileName.substring(0, fileName.lastIndexOf("."));
                String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
                fileName = name + "_"+new Date().getTime() +suffix;
                try {
                    FileUtil.copy(multipartFile.getInputStream(), new File(forder+fileName));
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (MultipartFile multipartFile : files1) {
            String fileName = multipartFile.getOriginalFilename();
            if(fileName!=null && !"".equals(fileName)) {
                String name = fileName.substring(0, fileName.lastIndexOf("."));
                String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
                fileName = name + "_"+new Date().getTime() +suffix;
                try {
                    FileUtil.copy(multipartFile.getInputStream(), new File(forder+fileName));
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("msg", "上传成功");
        request.getRequestDispatcher("/error.jsp").forward(request, response);
        return null;
    }

}
