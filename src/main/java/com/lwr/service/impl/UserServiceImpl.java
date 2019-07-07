package com.lwr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwr.dao.UserDao;
import com.lwr.entity.User;
import com.lwr.form.UserForm;
import com.lwr.service.UserService;
import com.lwr.utils.IdGenerateUtil;

//@Service不加参数，默认使用类名LoginServiceImpl首字母小写也就是loginServiceImpl作为bean名称
@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;

    @Override
    public User getLoginUser(User user) {
        List<User> loginUserList = userDao.getLoginUser(user.getLoginId(), user.getPassword());
        if (loginUserList != null && loginUserList.size() > 0) {
            User user2 = loginUserList.get(0);
            return user2;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        user.setId(IdGenerateUtil.generate().toString());
        userDao.addUser(user);
    }

    @Override
    public List<User> queryUserList(UserForm form) {
        return userDao.queryUserList(form);
    }

}
