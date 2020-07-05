package com.cn.youyi.dao;

import com.cn.youyi.entity.Oorder;
import com.cn.youyi.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPost(Post post) {
        sessionFactory.getCurrentSession().saveOrUpdate(post);
    }

    @Override
    public List<Post> getPostByCid(int cid) {
        String hql = "FROM Post as p WHERE p.cid = ? ";
        List posts = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, cid)//
                .list();
        return posts;
    }
}
