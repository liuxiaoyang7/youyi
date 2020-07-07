package com.cn.youyi.service;

import com.cn.youyi.dao.CommentDao;
import com.cn.youyi.dao.CommodityDao;
import com.cn.youyi.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;


    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    @Override
    public List<Comment> getByUid(int uid) {
        return commentDao.getByUid(uid);
    }

    @Override
    public List<Comment> getByPid(int pid) {
        return commentDao.getByPid(pid);
    }
}
