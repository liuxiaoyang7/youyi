package com.cn.youyi.dao;

import com.cn.youyi.entity.Postbar;
import com.cn.youyi.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostBarDaoImpl implements PostBarDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Postbar getBarById(int pbid) {
        return (Postbar) sessionFactory.getCurrentSession().get(Postbar.class, pbid);
    }

    @Override
    public List<Postbar> getAllPostBar() {
        String hql = "from Postbar";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }
}
