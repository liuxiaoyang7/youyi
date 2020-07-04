package com.cn.youyi.dao;

import com.cn.youyi.entity.Oorder;
import org.hibernate.Session;

import java.util.List;

public interface OrderDao {

    public Session getSession();

    //新增订单
    public void addOrder(Oorder order);

    //根据uid查询当前订单
    public List<Oorder> getOrderByUid(int uid);


}
