package com.cn.youyi.controller;

import com.cn.youyi.entity.Post;
import com.cn.youyi.entity.Postbar;
import com.cn.youyi.entity.User;
import com.cn.youyi.service.PostBarService;
import com.cn.youyi.service.PostService;
import com.cn.youyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("post1")
public class PostController {
    @Resource
    PostService postService;
    @Resource
    UserService userService;
    @Resource
    PostBarService postBarService;

    //查看相关商品帖子
    @Transactional
    @RequestMapping(value = "getPostByCid/{cid}/{uid}")
    public String getPostByCid(@PathVariable Integer cid,@PathVariable Integer uid, Model model){
        List<Post> list = postService.getPostByCid(cid);
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

    //去发布帖子页面
    @Transactional
    @RequestMapping("ToaddPost")
    public String toAddPost(){
        return "fabuPost";
    }

    //发布帖子界面
    @Transactional
    @RequestMapping("addPost")
    public String addPost(Post post, Model model, MultipartFile file){
        //获取文件的真实文件名
        String trueName = file.getOriginalFilename();
        //切割后缀, .需要转义
        String[] split = trueName.split("\\.");
        //获取文件的大小
        Long size = file.getSize();
        //需要把file文件存储到本地磁盘上
        String DIR = "E:/idea/IntelliJ IDEA 2019.3.3/workspace/youyi/youyi/src/main/webapp/statics/image/";
        //保存的时候不能保存真实文件名，可以使用一种机制生成唯一的文件名
        //UUID类是用来获取32位的固定长度的随机字符串，每次获取到的字符串永远不会重复。
        String saveName = UUID.randomUUID().toString()+"."+split[1];        //创建要保存的文件
        File newFile = new File(DIR+saveName);
        //把临时文件file转储到newFile上
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        post.setPimg(saveName);
        post.setPcontent(post.getPcontent());

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        post.setPublishtime(Timestamp.valueOf(sdf.format(d)));
        post.setUid(post.getUid());
        //PtID为1为商家帖
        post.setPtid(post.getPtid());
        post.setPbid(post.getPbid());
        postService.addPost(post);
        return "redirect:/index";
    }

    //查看所有玩家发布的帖子界面
    @Transactional
    @RequestMapping("getAllPost/{ptid}")
    public String getAllPost(Model model, @PathVariable int ptid){
        //找到所有的帖子
        List<Post> posts = postService.getAllPost(ptid);
        //找到所有的吧
        List<Postbar> postbars = postBarService.getAllPostBar();
        //找到所有的玩家用户
        List<User> users = userService.getUserBytyoeid(1);

        model.addAttribute("postbars", postbars);
        model.addAttribute("users", users);
        model.addAttribute("posts", posts);
        return "AllPost";
    }

    //查看相关玩家帖子
    @Transactional
    @RequestMapping(value = "getPostBypid/{pid}")
    public String getPostBypid(@PathVariable int pid, Model model){
        return "login";
    }

    //查看相关玩家帖子
    @Transactional
    @RequestMapping(value = "getPostBypid/{pid}/{uid}")
    public String getPostBypid(@PathVariable Integer pid,@PathVariable Integer uid, Model model){
        Post post = postService.getByPid(pid);
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

    //查询玩家自己的帖子
    @Transactional
    @RequestMapping(value = "getPostByUid/{uid}")
    public String getPostByUid(@PathVariable int uid, Model model){
        List<Post> posts = postService.getPostByUid(uid);
        //找到所有的吧
        List<Postbar> postbars = postBarService.getAllPostBar();
        //找到所有的玩家用户
        List<User> users = userService.getUserBytyoeid(1);

        model.addAttribute("postbars", postbars);
        model.addAttribute("users", users);
        model.addAttribute("posts", posts);
        return "AllPost";
    }
}
