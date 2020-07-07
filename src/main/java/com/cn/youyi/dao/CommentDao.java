package com.cn.youyi.dao;


import com.cn.youyi.entity.Comment;
import org.hibernate.Session;

import java.util.List;

public interface CommentDao {
    public Session getSession();

    //新增评论
    public void addComment(Comment comment);

    //根据用户id查找评论
    public List<Comment> getByUid(int uid);

    //根据帖子id查找评论
    public List<Comment> getByPid(int pid);
}
