package com.cn.youyi.controller;

import com.cn.youyi.entity.Commodity;
import com.cn.youyi.entity.Oorder;
import com.cn.youyi.entity.Post;
import com.cn.youyi.entity.User;
import com.cn.youyi.service.CommodityService;
import com.cn.youyi.service.OrderService;
import com.cn.youyi.service.PostService;
import com.cn.youyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class CommodityController {
    @Resource
    OrderService orderService;
    @Resource
    CommodityService commodityService;
    @Resource
    UserService userService;
    @Resource
    PostService postService;


    //获取最新,人气，全部商品(前三)
    @Transactional
    @RequestMapping(value = "/index")
    public String show(Model model, String name){
        List<Commodity> listR = commodityService.getReCommodity();
        List<Commodity> listN = commodityService.getNewCommodity();
        List<Commodity> listA = commodityService.getAllCommodity();
        if(name==null){
        }else{
            model.addAttribute("name", name);
        }
        model.addAttribute("listR",listR);
        model.addAttribute("listN",listN);
        model.addAttribute("listA",listA);
        return "index";
    }

    //获取人气(全部)
    @Transactional
    @RequestMapping(value = "/showRq")
    public String showRq(Model model){
        List<Commodity> listR = commodityService.getAllReCommodity();
        model.addAttribute("listR",listR);
        return "renqi";
    }

    //获取最新(全部)
    @Transactional
    @RequestMapping(value = "/showNew")
    public String showNew(Model model){
        List<Commodity> listN = commodityService.getAllNewCommodity();
        model.addAttribute("listN",listN);
        return "showNew";
    }

    //获取全部商品(全部)
    @Transactional
    @RequestMapping(value = "/showAll")
    public String showAll(Model model){
        List<Commodity> listA = commodityService.getAlllCommodity();
        model.addAttribute("listA",listA);
        return "shouwAll";
    }

    //根据id查询商品
    @Transactional
    @RequestMapping(value = "/Commodity/{cid}")
    public String CommodityByCid(@PathVariable int cid, Model model){
        Commodity commodity = commodityService.getCommodityByCid(cid);
        model.addAttribute("commodity",commodity);
        return "commodityDetail";
    }

    //根据商品分类查询商品
    @Transactional
    @RequestMapping(value = "/CommodityVG")
    public String CommodityByVariety(String variety,int gid, Model model){
        List<Commodity> listV = commodityService.getCommodityByVariety(variety, gid);
        if(listV==null){}else {
            model.addAttribute("listV", listV);
            return "varietyCom";
        }
        return null;
    }

    //返回登录页面
    @Transactional
    @RequestMapping(value = "/buyCommodity/{cid}")
    public String buyCommodity(HttpSession session,@PathVariable int cid,  Model model){
            return "login";
    }

    //购买商品
    @Transactional
    @RequestMapping(value = "/buyCommodity/{cid}/{name}")
    public String buyCommodity(HttpSession session,@PathVariable int cid, @PathVariable String name,  Model model){
            User user = (User) userService.getUserByName(name).get(0);
            Commodity commodity = commodityService.getCommodityByCid(cid);
            if (user.getYue()<commodity.getPrice()){
                model.addAttribute("user",user);
                model.addAttribute("cid", cid);
                return "Pay";
            }else {
                int yue = (int) (user.getYue()-commodity.getPrice());
                userService.payYue(yue, user.getName());
                Oorder order = new Oorder();
                order.setUserid(user.getUid());
                order.setCid(cid);
                //订单状态为一表示已经购买
                order.setOrderState(1);
                //获取当前时间
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                order.setBuyTime(Timestamp.valueOf(sdf.format(d)));
                orderService.addOrder(order);
                //减少库存
                int kucun = commodity.getPopularity()-1;
                commodityService.updateKucun(cid, kucun);
                //增加人气
                int renqi = commodity.getRexiao()+1;
                commodityService.updateRenqi(cid, renqi);
                //买东西增加10经验
                int jinyan = user.getExperience()+10;
                userService.jinyan(jinyan, user.getName());
                //被买的商家增加经验
                if (userService.getUserById(commodity.getUid())!=null){ //防止自己刷经验
                    User user1 = userService.getUserById(commodity.getUid());
                    if (user1.getTypeid()==2){
                        int jinyan1 = user1.getExperience()+10;
                        userService.jinyan(jinyan1, user1.getName());
                    }else {}
                }else {}

                return "redirect:/index";
            }
    }

    //发布
    @Transactional
    @RequestMapping(value = "/ToaddCommidity")
    public String ToaddCommdity(){
        return "fabushop";
    }

    //发布
    @Transactional
    @RequestMapping(value = "/addCommidity")
    public String addCommdity(HttpSession session, Commodity commodity, MultipartFile file){
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
        //图片随机字符串名称
        commodity.setCimg(saveName);
        User user = (User) session.getAttribute("user");
        commodity.setUid(user.getUid());
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        commodity.setXinping(Timestamp.valueOf(sdf.format(d)));
        String format = new BigDecimal(String.valueOf(commodity.getPrice())).toString();
        float rr = Float.valueOf(format);
        commodity.setPrice((double) rr);
        commodity.setIntroduce(commodity.getIntroduce());
        commodity.setPopularity(commodity.getPopularity());
        commodity.setTitile(commodity.getTitile());
        commodity.setVariety(commodity.getVariety());
        commodity.setRexiao(0);
//        int total = commodityService.Total() + 1;
//        commodity.setCid(total);
        commodityService.addCommidity(commodity);

        //生成商品帖
        Post post = new Post();
        post.setPcontent(commodity.getTitile()+commodity.getIntroduce());
        post.setPimg(saveName);
        post.setPublishtime(Timestamp.valueOf(sdf.format(d)));
        post.setUid(user.getUid());
        post.setCid(commodity.getCid());
        //PtID为1为商家帖
        post.setPtid(1);
        post.setPbid(commodity.getGid());
        postService.addPost(post);
        return "redirect:/index";
    }
}
