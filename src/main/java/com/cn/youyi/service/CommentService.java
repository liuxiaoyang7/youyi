package com.cn.youyi.service;

import com.cn.youyi.entity.Comment;

import java.util.List;

public interface CommentService {

    //新增评论
    public void addComment(Comment comment);

    //根据用户id查找评论
    public List<Comment> getByUid(int uid);

    //根据帖子id查找评论
    public List<Comment> getByPid(int pid);
}
