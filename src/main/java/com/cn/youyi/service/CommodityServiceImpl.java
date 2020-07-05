package com.cn.youyi.service;

import com.cn.youyi.dao.CommodityDao;
import com.cn.youyi.entity.Commodity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("CommodityService")
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityDao commodityDao;


    @Override
    public List<Commodity> getReCommodity() {
        return commodityDao.getReCommodity();
    }

    @Override
    public List<Commodity> getNewCommodity() {
        return commodityDao.getNewCommodity();
    }

    @Override
    public List<Commodity> getAllCommodity() {
        return commodityDao.getAllCommodity();
    }

    @Override
    public List<Commodity> getAllReCommodity() {
        return commodityDao.getAllReCommodity();
    }

    @Override
    public List<Commodity> getAllNewCommodity() {
        return commodityDao.getAllNewCommodity();
    }

    @Override
    public List<Commodity> getAlllCommodity() {
        return commodityDao.getAlllCommodity();
    }

    @Override
    public Commodity getCommodityByCid(int cid) {
        return commodityDao.getCommodityByCid(cid);
    }

    @Override
    public List<Commodity> getCommodityByVariety(String variety, int gid) {
        return commodityDao.getCommodityByVariety(variety, gid);
    }

    @Override
    public int updateKucun(int cid, int kucun) {
        return commodityDao.updateKucun(cid, kucun);
    }

    @Override
    public int updateRenqi(int cid, int renqi) {
        return commodityDao.updateRenqi(cid, renqi);
    }

    @Override
    public void addCommidity(Commodity commodity) {
        commodityDao.addCommidity(commodity);
    }

    @Override
    public int Total() {
        return commodityDao.Total();
    }
}