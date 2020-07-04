package com.cn.youyi.service;

import com.cn.youyi.dao.OrderDao;
import com.cn.youyi.entity.Oorder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public void addOrder(Oorder order) {
        orderDao.addOrder(order);
    }

    @Override
    public List<Oorder> getOrderByUid(int uid) {
        return orderDao.getOrderByUid(uid);
    }
}
