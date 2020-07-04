package com.cn.youyi.dao;

import com.cn.youyi.entity.Commodity;
import org.hibernate.Session;

import java.util.List;

public interface CommodityDao {
    public Session getSession();

    //热销商品(前三)
    public List<Commodity> getReCommodity();

    //新品上架(前三)
    public List<Commodity> getNewCommodity();

    //获得全部商品(前三)
    public List<Commodity> getAllCommodity();

    //热销商品
    public List<Commodity> getAllReCommodity();

    //新品上架
    public List<Commodity> getAllNewCommodity();

    //获得全部商品
    public List<Commodity> getAlllCommodity();

    //根据商品id查询商品
    public Commodity getCommodityByCid(int cid);

    //根据分类查询商品
    public List<Commodity> getCommodityByVariety(String variety, int gid);

}
