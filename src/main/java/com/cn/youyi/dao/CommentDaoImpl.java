package com.cn.youyi.dao;

import com.cn.youyi.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addComment(Comment comment) {
        sessionFactory.getCurrentSession().saveOrUpdate(comment);
    }

    @Override
    public List<Comment> getByUid(int uid) {
        String hql = "FROM Comment as c WHERE c.uid = ? ORDER BY c.comtime desc";
        List comments = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, uid)//
                .list();
        return comments;
    }

    @Override
    public List<Comment> getByPid(int pid) {
        String hql = "FROM Comment as c WHERE c.pid = ? ORDER BY c.comtime desc";
        List comments = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, pid)//
                .list();
        return comments;
    }
}
