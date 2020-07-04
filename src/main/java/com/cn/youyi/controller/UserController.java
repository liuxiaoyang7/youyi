package com.cn.youyi.controller;


import com.alibaba.fastjson.JSONObject;
import com.cn.youyi.entity.Commodity;
import com.cn.youyi.entity.User;
import com.cn.youyi.service.CommodityService;
import com.cn.youyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    CommodityService commodityService;
    @Resource
    UserService userService;


    @Transactional
    @RequestMapping("selectUserByUid")
    public String SelecUserByUid(int uid, Model model){
        User user = userService.getUserById(uid);
        model.addAttribute("user", user);
        return "index";
    }

    @Transactional
    @RequestMapping("getAllUser")
    public String getAllUser(Model model){
        List<User> list = userService.getAllUser();
        model.addAttribute("list",list);
        return "index";
    }

    //通过ajax请求返回json字符串
    @ResponseBody
    @RequestMapping("registering")
    public String login(String name, int typeid, String IDcard){
        List<User> user = userService.getAllUser();
        int name_msg = 0;
        int IDcard_msg = 0;
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        for (User user1:user){
            boolean user2 = user1.getName().equals(name);
            //name_msg= 0 不存在该用户

            if (!user2){//如果不存在user2
                if (typeid!=1){//如果是商家注册
                    if (IDcard==null){
                        //"请填写身份证号"
                        IDcard_msg = 1;
                    }else if(IDcard.matches(regularExpression)){
                        if(IDcard==null){//逻辑有点问题，这里
                            //该身份证已经注册;
                            IDcard_msg = 2;
                        }else {
                            //有效身份证
                            IDcard_msg = 3;
                        }
                    }else {
                        //"请输入有效身份证";
                        IDcard_msg = 4;
                    }
                }else{
                    //pt用户无需填写
                    IDcard_msg = 5;
                }
            }else {
                //"用户名已经存在"
                name_msg = 2;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(name_msg);
        list.add(IDcard_msg);
        return JSONObject.toJSONString(list);
    }

    @Transactional
    @RequestMapping("register")
    public String register(User user, MultipartFile file){
        //获取文件的真实文件名
        String trueName = file.getOriginalFilename();
        //切割后缀, .需要转义
        String[] split = trueName.split("\\.");
        //获取文件的大小
        Long size = file.getSize();
        System.out.println("文件大小（字节）："+size);
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
        //头像真实名称
        user.setHeadphoto(saveName);
        //生成随机数uid
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        user.setUid(Integer.parseInt(fourRandom));
        user.setPhone(user.getPhone());
        user.setSex(user.getSex());
        user.setPassword(user.getPassword());
        user.setName(user.getName());
        user.setTypeid(user.getTypeid());
        user.setYue(0);

        //刚注册账号初始化经验
        user.setExperience(0);
        userService.addUser(user);
        return "redirect:/index";
    }

    //去到注册界面
    @Transactional
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }
    //去到登录界面
    @Transactional
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    //通过ajax请求返回json字符串
    @ResponseBody
    @RequestMapping("login")
    public String login(String name, String pwd){
        List list1 = userService.getUserByName(name);
        User user = (User) list1.get(0);
        String msg = "";
        String msg_pwd = "";
        if (user!=null){
            if (user.getName().equals(name)){
                msg = "正确";
            }
            if (user.getPassword().equals(pwd)){
                msg_pwd = "正确";
            }
        }else {
            msg = "用户名错误";
            msg_pwd = "密码错误";
        }

        ArrayList<String> list = new ArrayList<>();
        list.add(msg);
        list.add(msg_pwd);

        return JSONObject.toJSONString(list);
    }

    //登陆成功跳转到书籍展示页面
    @Transactional
    @RequestMapping("loginok")
    public String loginok(HttpSession session, String username, String pwd, Model model){
        if (username!=null && pwd!= null){
            List<User> users = userService.getUserByName(username);
            if (users!=null){
                User user = users.get(0);
                if (user.getName().equals(username) && user.getPassword().equals(pwd)){
//                    session.setAttribute("username", user.getName());
//                    session.setAttribute("userphoto", user.getHeadphoto());
                    session.setAttribute("user", user);
                    return "redirect:/index";
                }else {
                    model.addAttribute("msg_loginError","账号密码错误");
                    return "login";
                }
            }else {
                model.addAttribute("msg_loginError","用户不存在");
                return "login";
            }
        }else {
            model.addAttribute("msg_loginError","请输入账号密码");
            return "login";
        }
    }

    //注销登录
    @Transactional
    @RequestMapping("removeUser")
    public String removeUser(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/index";
    }

    @Transactional
    @RequestMapping("payYue")
    public String payYue(HttpSession session, String name,String Rname, int cid,int yue, Model model){
        User user = (User) userService.getUserByName(name).get(0);
        if (name.equals(Rname)){
            int Uyue = user.getYue() + yue;
            userService.payYue(Uyue, Rname);
            Commodity commodity = commodityService.getCommodityByCid(cid);
            model.addAttribute("commodity", commodity);
            model.addAttribute("user", user);
            return "commodityDetail";
        }else {
            model.addAttribute("user",user);
            return "Pay";
        }
    }
}
