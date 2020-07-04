package com.cn.youyi.controller;

import com.cn.youyi.entity.Commodity;
import com.cn.youyi.entity.Oorder;
import com.cn.youyi.entity.User;
import com.cn.youyi.service.CommodityService;
import com.cn.youyi.service.OrderService;
import com.cn.youyi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class CommodityController {
    @Resource
    OrderService orderService;
    @Resource
    CommodityService commodityService;
    @Resource
    UserService userService;


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
        List<Commodity> listA = commodityService.getAllCommodity();
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
        System.out.println(user.getYue());
        System.out.println(commodity.getPrice());
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
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                order.setBuyTime(Timestamp.valueOf(sdf.format(d)));
                System.out.println("====================================================================1");
                System.out.println("================"+order);
                orderService.addOrder(order);
                System.out.println("================"+order);
                System.out.println("====================================================================2");
                return "redirect:/index";
            }
    }
}
