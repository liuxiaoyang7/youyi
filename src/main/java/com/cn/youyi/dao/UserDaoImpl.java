package com.cn.youyi.dao;

import com.cn.youyi.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserById(int uid) {
        return (User) sessionFactory.getCurrentSession().get(User.class, uid);
    }

    @Override
    public List<User> getAllUser() {
        String hql = "from User";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public List<User> getUserByName(String name) {
        String hql = "FROM User as u WHERE u.name = ? ";
        List users = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, name)//
                .list();
        return users;
    }

    @Override
    public List<User> getUserByIDcard(String IDcard) {
        String hql = "FROM User as u WHERE u.iDcard = ?";
        List list = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, IDcard)//
                .list();
        return list;
    }

    @Override
    public int payYue(int yue, String name) {
        Query q = sessionFactory.getCurrentSession().createQuery("update User u set u.yue = ? where u.name = ?")
                .setParameter(0, yue)
                .setParameter(1, name);
        return q.executeUpdate();
    }

    @Override
    public int jinyan(int jinyan, String name) {
        Query q = sessionFactory.getCurrentSession().createQuery("update User u set u.experience = ? where u.name = ?")
                .setParameter(0, jinyan)
                .setParameter(1, name);
        return q.executeUpdate();
    }
}
