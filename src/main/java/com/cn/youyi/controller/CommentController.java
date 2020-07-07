package com.cn.youyi.controller;


import com.alibaba.fastjson.JSON;
import com.cn.youyi.entity.Comment;
import com.cn.youyi.entity.Post;
import com.cn.youyi.entity.User;
import com.cn.youyi.service.CommentService;
import com.cn.youyi.service.PostService;
import com.cn.youyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentService commentService;
    @Resource
    PostService postService;
    @Resource
    UserService userService;

    //增加用户评论
    @RequestMapping("addComment")
    public String addComment(HttpSession session, Model model, Comment comment, Integer cid, Integer pid, Integer uid){
        //新增加评论
        User user3 = (User) session.getAttribute("user");
        //获取当前时间
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setComcontent(comment.getComcontent());
        comment.setComtime(Timestamp.valueOf(sdf.format(d)));
        comment.setPid(pid);
        comment.setUid(user3.getUid());
        comment.setAgainCmid(1);
        commentService.addComment(comment);

        if (cid==null){
            Post post = postService.getByPid(pid);
            model.addAttribute("postShow",post);
        }else {
            List<Post> list = postService.getPostByCid(cid);
            Post post = list.get(0);
            model.addAttribute("postShow",post);
        }

        if (pid==null){
            List<Post> list = postService.getPostByCid(cid);
            Post post = list.get(0);
            model.addAttribute("postShow",post);
        }else {
            Post post = postService.getByPid(pid);
            model.addAttribute("postShow",post);
        }
        User user = userService.getUserById(uid);
        String dengji = "暂无等级";
        if (user.getExperience()>=2000){
            dengji = "海王";
        }else if(user.getExperience()>=1500&&user.getExperience()<2000){
            dengji = "鲨鱼";
        }else if(user.getExperience()>=1000&&user.getExperience()<1500){
            dengji = "渔夫";
        }else if(user.getExperience()>=500&&user.getExperience()<1000){
            dengji = "五级小虾米";
        }else if(user.getExperience()>=300&&user.getExperience()<500){
            dengji = "四级小虾米";
        }else if(user.getExperience()>=200&&user.getExperience()<300){
            dengji = "三级小虾米";
        }else if(user.getExperience()>=100&&user.getExperience()<200){
            dengji = "二级小虾米";
        }else if(user.getExperience()>=10&&user.getExperience()<100){
            dengji = "一级小虾米";
        }else {
            dengji = "暂无等级";
        }
        //帖子被评论增加10经验
        int jinyan = user.getExperience()+10;
        userService.jinyan(jinyan, user.getName());

        model.addAttribute("dengji", dengji);
        model.addAttribute("user",user);
        return "PostDetail";
    }

    //返回用户评论的JSON数据
    //Json数据包括 评价该帖子的用户头像，名称，评价内容，时间
    @ResponseBody
    @RequestMapping("jsonComment")
    public String JsonComment(Integer pid1){//2
        int i=0;
        int j = 0;
        //获取该pid的评论
        if (commentService.getByPid(pid1)!=null) {
            List<Comment> list = commentService.getByPid(pid1);//读取到帖子id2的5条数据，找到了5条评论对象
            List<String> list3 = new ArrayList<>();
//            //该列表储存该帖子评论的用户id
//            List<Integer> list1 = new ArrayList<>();
//            //该列表储存该帖子评论的用户 用户名，头像，评价内容，时间
//            List<String> list3 = new ArrayList<>();
//            for (Comment comment : list) { //循环所有的评论，找到相应的用户id
//                list1.add(comment.getUid());
//            }
//            System.out.println("=================================1 1247 1247 1247 1247"+list1);
//            for (i = 0; i < list1.size(); i++) { //循环所有找到的用户id,
//                User user1 = userService.getUserById(list1.get(i)); //根据list1里面的用户ID找到每一个用户（可能有相同的）
//                list3.add(user1.getName()); //依次将找到的用户名放进list3
//                list3.add(user1.getHeadphoto()); //依次将找到的用户头像放进list3
//                List<Comment> list4 = commentService.getByUid(user1.getUid()); //根据用户id获取对应用户发言的内容
//                if(i>0){ //当i的索引大于1的时候，如果当前查询用户与上一次查询账户不一致，j重置为0
//                    if (list1.get(i).equals(list1.get(i-1))){
//                    }else {
//                        j = 0;
//                    }
//                }
//                if (list.get(j).getPid()==pid1){
//                    list3.add(list4.get(j).getComcontent());  //1发表的内容
//                    list3.add(String.valueOf(list4.get(j).getComtime()));  //1发表的时间
//                    list3.add(String.valueOf(pid1));
//                    j = j + 1;
//                }else {}
//            }

            for (Comment comment : list) { //循环所有的评论，找到相应的用户id
                User user = userService.getUserById(comment.getUid());
                list3.add(user.getHeadphoto());
                list3.add(user.getName());
                list3.add(comment.getComcontent());
                list3.add(String.valueOf(comment.getComtime()));
                list3.add(String.valueOf(pid1));
            }
            System.out.println("===============长度"+list3.size());
            System.out.println("===============lis3"+list3);
            for (int l = 0; l< list3.size(); l=l+5){
                System.out.println("======pid"+list3.get(l+4));
            }
            return JSON.toJSONString(list3);
        }else{
            return "暂无评论，等你的发言";
        }
    }
}
