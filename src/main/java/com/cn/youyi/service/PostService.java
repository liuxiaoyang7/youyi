package com.cn.youyi.service;

import com.cn.youyi.entity.Post;
import com.cn.youyi.entity.Postbar;

import java.util.List;

public interface PostService {

    //新增商家帖子
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
