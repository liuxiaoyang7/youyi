package com.cn.youyi.service;

import com.cn.youyi.dao.OrderDao;
import com.cn.youyi.dao.UserDao;
import com.cn.youyi.entity.Oorder;
import com.cn.youyi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(int uid) {
        return userDao.getUserById(uid);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public List<User> getUserByIDcard(String IDcard) {
        return userDao.getUserByIDcard(IDcard);
    }

    @Override
    public int payYue(int yue, String name) {
        return  userDao.payYue(yue, name);
    }


}
