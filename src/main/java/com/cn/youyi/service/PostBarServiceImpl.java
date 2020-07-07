package com.cn.youyi.service;

import com.cn.youyi.dao.PostBarDao;
import com.cn.youyi.entity.Postbar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("postBarService")
public class PostBarServiceImpl implements PostBarService {
    @Resource
    PostBarDao postBarDao;


    @Override
    public Postbar getBarById(int pbid) {
        return postBarDao.getBarById(pbid);
    }

    @Override
    public List<Postbar> getAllPostBar() {
        return postBarDao.getAllPostBar();
    }
}
