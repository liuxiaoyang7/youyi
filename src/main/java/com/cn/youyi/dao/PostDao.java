package com.cn.youyi.dao;

import com.cn.youyi.entity.Post;
import com.cn.youyi.entity.User;
import org.hibernate.Session;

import java.util.List;

public interface PostDao {


    public Session getSession();

    //新增帖子
    public void addPost(Post post);

    //根据商品id查到该商品帖子
    public List<Post> getPostByCid(int cid);

    //根据贴子id查询到该帖子
    public Post getByPid(int pid);

    //根据用户ID查询到帖子
    public List<Post> getPostByUid(int uid);

    //查看所有的玩家帖子
    public List<Post> getAllPost(int ptid);
}
