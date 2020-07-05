package com.cn.youyi.service;

import com.cn.youyi.entity.Commodity;
import com.cn.youyi.entity.Oorder;
import com.cn.youyi.entity.User;

import java.util.List;

public interface UserService {

    //新增用户
    public void addUser(User user );

    //根据用户id查找用户
    public User getUserById(int uid);

    //获取所有用户
    public List<User> getAllUser();

    //根据用户名字查找用户
    public  List<User> getUserByName(String name);

    //根据用户身份证查找用户
    public List<User> getUserByIDcard(String IDcard);

    //给当前账户充值余额
    public int payYue(int yue, String name);

    //修改当前用户的经验
    public int jinyan(int jinyan, String name);
}
