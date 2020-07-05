package com.cn.youyi.controller;

import com.cn.youyi.entity.Post;
import com.cn.youyi.entity.User;
import com.cn.youyi.service.PostService;
import com.cn.youyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("post1")
public class PostController {
    @Resource
    PostService postService;
    @Resource
    UserService userService;

    //查看相关商品帖子
    @Transactional
    @RequestMapping(value = "getPostByCid/{cid}/{uid}")
    public String getPostByCid(@PathVariable int cid,@PathVariable int uid, Model model){
        List<Post> list = postService.getPostByCid(cid);
        System.out.println(list.get(0));
        Post post = list.get(0);
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
        model.addAttribute("dengji", dengji);
        model.addAttribute("postShow",post);
        model.addAttribute("user",user);
        return "PostDetail";
    }

    //查看相关商品帖子
    @Transactional
    @RequestMapping(value = "getPostByCid/{cid}")
    public String getPostByCid(@PathVariable int cid, Model model){
        return "login";
    }


}
