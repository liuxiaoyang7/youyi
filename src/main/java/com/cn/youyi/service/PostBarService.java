package com.cn.youyi.service;

import com.cn.youyi.entity.Postbar;

import java.util.List;

public interface PostBarService {

    //根据吧id获取吧的信息
    public Postbar getBarById(int pbid);


    //查询所有的吧
    public List<Postbar> getAllPostBar();
}
