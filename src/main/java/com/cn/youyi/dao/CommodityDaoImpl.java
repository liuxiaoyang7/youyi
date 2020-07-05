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
        String hql = "FROM Commodity c WHERE c.rexiao > 0 and c.popularity > 0 ORDER BY c.rexiao desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setMaxResults(3);
        return q.list();
    }

    @Override
    public List<Commodity> getAllReCommodity() {
        String hql = "FROM Commodity c WHERE c.popularity > 0 ORDER BY c.rexiao desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public List<Commodity> getNewCommodity() {
        String hql = "FROM Commodity c WHERE c.popularity > 0 ORDER BY c.xinping desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        //查询当前前三条数据
        q.setMaxResults(3);
        return q.list();
    }

    @Override
    public List<Commodity> getAllNewCommodity() {
        String hql = "FROM Commodity c WHERE c.popularity > 0 ORDER BY c.xinping desc";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public List<Commodity> getAllCommodity() {
        String hql = "from Commodity as c where c.popularity > 0";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setMaxResults(3);
        return q.list();
    }

    @Override
    public List<Commodity> getAlllCommodity() {
        String hql = "from Commodity as c WHERE c.popularity > 0";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        return q.list();
    }

    @Override
    public Commodity getCommodityByCid(int cid) {
        return (Commodity) sessionFactory.getCurrentSession().get(Commodity.class, cid);
    }

    @Override
    public List<Commodity> getCommodityByVariety(String variety, int gid) {
        String hql = "FROM Commodity as c WHERE c.variety = ? and c.gid = ? and c.popularity > 0";
        List commodities = sessionFactory.getCurrentSession().createQuery(hql)//
                .setParameter(0, variety)//
                .setParameter(1, gid)
                .list();
        return commodities;
    }

    @Override
    public int updateKucun(int cid, int kucun) {
        Query q = sessionFactory.getCurrentSession().createQuery("update Commodity c set c.popularity = ? where c.cid = ?")
                .setParameter(0, kucun)
                .setParameter(1, cid);
        return q.executeUpdate();
    }

    @Override
    public int updateRenqi(int cid, int renqi) {
        Query q = sessionFactory.getCurrentSession().createQuery("update Commodity c set c.rexiao = ? where c.cid = ?")
                .setParameter(0, renqi)
                .setParameter(1, cid);
        return q.executeUpdate();
    }

    @Override
    public void addCommidity(Commodity commodity) {
        sessionFactory.getCurrentSession().saveOrUpdate(commodity);
    }

    @Override
    public int Total() {
        String hql="select count(*) from Commodity";//此处的Product是对象
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int count=((Long) query.setCacheable(true).uniqueResult()).intValue();//此处用Long类型进行转换
        return count;
    }

}
