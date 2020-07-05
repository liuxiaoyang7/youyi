package com.cn.youyi.dao;

import com.cn.youyi.entity.Post;
import org.hibernate.Session;

import java.util.List;

public interface PostDao {


    public Session getSession();

    //新增商家帖子
    public void addPost(Post post);

    //根据商品id查到该商品帖子
    public List<Post> getPostByCid(int cid);
}
