package com.lik.LikTemplate.controller.api;


import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lik.LikTemplate.common.Result;
import com.lik.LikTemplate.config.AliPayBean;
import com.lik.LikTemplate.config.Alipay;
import com.lik.LikTemplate.entity.Order;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.ZhouBian;
import com.lik.LikTemplate.entity.vo.OrderVo;
import com.lik.LikTemplate.service.OrderService;
import com.lik.LikTemplate.service.UserService;
import com.lik.LikTemplate.service.ZhouBianService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping("/order")
public class OrderController {


    @Resource
    OrderService orderService;

    @Resource
    UserService userService;

    @Resource
    ZhouBianService zhouBianService;

    /**
     *
     * @param request 支付宝支付回调 支付成功的情况下
     * @return
     */
    @RequestMapping("/success")
    @ResponseBody
    public String success(HttpServletRequest request){

        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
            }
            Order order = new Order();
            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String myPayment = params.get("subject");
            order.setId(tradeNo);
            order.setState("0");
            orderService.updateById(order);
            System.out.println("支付成功回调");
        }
        return "success";
    }

    // 添加
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Order order) {
        System.out.println(order);
        order.setCulturalRelicTime(new Date());
        order.setState("0");
        boolean save = orderService.save(order);

        ZhouBian z = zhouBianService.getById(order.getZid());

        //开始调用支付宝接口，获取拉起支付页面
        AliPayBean alipayBean = new AliPayBean();
        alipayBean.setOut_trade_no(order.getId());
        alipayBean.setSubject("商品支付订单");
        alipayBean.setTotal_amount(z.getPrice());
        try {
            Alipay alipay = new Alipay();
            return Result.ok().message(alipay.pay(alipayBean));
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (save) {
            return Result.ok().data("item",save);
        } else {
            return Result.error().message("ִ添加失败");
        }
    }

    // 添加
    @RequestMapping("/all")
    @ResponseBody
    public Result all() {
        List<Order> list = orderService.list();
        List list1 = new ArrayList();

        for(int i =0 ;i<list.size();i++){
            Order order = list.get(i);
            ZhouBian byId = zhouBianService.getById(order.getZid());
            OrderVo vo = new OrderVo();
            vo.setOid(order.getId());
            vo.setPrice(byId.getPrice());
            vo.setTime(order.getCulturalRelicTime());
            vo.setZName(byId.getName());
            vo.setUName(order.getUid());
            vo.setState(order.getState());
            list1.add(vo);
        }
        return Result.ok().data("item",list1);
    }

    // 添加
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestParam( value = "id") String id) {
        Order byId = orderService.getById(id);
        byId.setState("1");
        boolean b = orderService.updateById(byId);
        return Result.ok();
    }

    // 添加
    @RequestMapping("/getByName")
    @ResponseBody
    public Result getByName(@RequestParam( value = "uid") String uid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",uid);
        List<Order> list = orderService.list(queryWrapper);
        List list1 = new ArrayList();
        for(int i =0 ;i<list.size();i++){
            Order order = list.get(i);
            ZhouBian byId = zhouBianService.getById(order.getZid());
            OrderVo vo = new OrderVo();
            vo.setOid(order.getId());
            vo.setPrice(byId.getPrice());
            vo.setTime(order.getCulturalRelicTime());
            vo.setZName(byId.getName());
            vo.setUName(order.getUid());
            vo.setState(order.getState());
            list1.add(vo);
        }
        return Result.ok().data("item",list1);
    }

}
