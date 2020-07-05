package com.cn.youyi.service;

import com.cn.youyi.dao.PostDao;
import com.cn.youyi.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("postService")
public class PostServiceImpl implements PostService {
    @Resource
    private PostDao postDao;

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public List<Post> getPostByCid(int cid) {
        return postDao.getPostByCid(cid);
    }
}
