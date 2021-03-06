package com.cn.youyi.service;

import com.cn.youyi.entity.Commodity;

import java.util.List;

public interface CommodityService {

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

    //更新库存
    public int updateKucun(int cid, int kucun);

    //更新人气
    public int updateRenqi(int cid, int renqi);

    //发布新的商品
    public void addCommidity(Commodity commodity);

    //查询商品总数
    public int Total();
}
