package com.lwr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lwr.entity.User;
import com.lwr.form.UserForm;

public interface UserDao {
    
    public List<User> getLoginUser(@Param("loginId") String loginId,@Param("password") String password);

    public void addUser(User user);
    
    public List<User> queryUserList(@Param("form") UserForm form);
}
