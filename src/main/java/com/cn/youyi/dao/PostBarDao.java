package com.cn.youyi.dao;

import com.cn.youyi.entity.Postbar;
import org.hibernate.Session;

import java.util.List;

public interface PostBarDao {
    public Session getSession();

    //根据吧id获取吧的信息
    public Postbar getBarById(int pbid);

    //查询所有的吧
    public List<Postbar> getAllPostBar();
}
