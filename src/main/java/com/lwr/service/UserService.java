package com.lwr.service;

import java.util.List;

import com.lwr.entity.User;
import com.lwr.form.UserForm;

public interface UserService {
    public User getLoginUser(User user);

    public void addUser(User user);

    public List<User> queryUserList(UserForm form);
}
