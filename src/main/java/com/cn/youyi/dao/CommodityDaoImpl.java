package com.cn.youyi.dao;

import com.cn.youyi.entity.Commodity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommodityDaoImpl implements CommodityDao  {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Commodity> getReCommodity() {
        String hql = "FROM Commodity c WHERE c.rexiao>0 ORDER BY c.rexiao desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setMaxResults(3);
        return q.list();
    }

    @Override
    public List<Commodity> getAllReCommodity() {
        String hql = "FROM Commodity c ORDER BY c.rexiao desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public List<Commodity> getNewCommodity() {
        String hql = "FROM Commodity c ORDER BY c.xinping desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        //查询当前前三条数据
        q.setMaxResults(3);
        return q.list();
    }

    @Override
    public List<Commodity> getAllNewCommodity() {
        String hql = "FROM Commodity c ORDER BY c.xinping desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public List<Commodity> getAllCommodity() {
        String hql = "from Commodity";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setMaxResults(3);
        return q.list();
    }

    @Override
    public List<Commodity> getAlllCommodity() {
        String hql = "from Commodity";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public Commodity getCommodityByCid(int cid) {
        return (Commodity) sessionFactory.getCurrentSession().get(Commodity.class, cid);
    }

    @Override
    public List<Commodity> getCommodityByVariety(String variety, int gid) {
        String hql = "FROM Commodity as c WHERE c.variety = ? and c.gid = ? ";
        List commodities = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, variety)//
                .setParameter(1, gid)
                .list();
        return commodities;
    }

}
