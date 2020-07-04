package com.cn.youyi.dao;

import com.cn.youyi.entity.Oorder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addOrder(Oorder order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);;
    }

    @Override
    public List<Oorder> getOrderByUid(int uid) {
        String hql = "FROM Oorder as o WHERE o.userid = ? ";
        List orders = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, uid)//
                .list();
        return orders;
    }


}
