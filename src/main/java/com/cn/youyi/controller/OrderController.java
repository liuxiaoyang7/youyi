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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private UserService userService;

    @Transactional
    @RequestMapping("orderByUid/{uid}")
    public String orderByUid(Model model,@PathVariable int uid){
        List<Commodity> commodities = commodityService.getAlllCommodity();
        List<Oorder> oorders = orderService.getOrderByUid(uid);

        model.addAttribute("oorders",oorders);
        model.addAttribute("commodities",commodities);
        return "order";
    }
}
