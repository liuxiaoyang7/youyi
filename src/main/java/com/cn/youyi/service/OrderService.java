package com.cn.youyi.service;

import com.cn.youyi.entity.Oorder;

import java.util.List;

public interface OrderService {

    //新增订单
    public void addOrder(Oorder order);

    //根据uid查询当前订单
    public List<Oorder> getOrderByUid(int uid);
}
