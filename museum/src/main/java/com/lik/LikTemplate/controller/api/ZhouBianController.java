package com.lik.LikTemplate.controller.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lik.LikTemplate.common.Result;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.ZhouBian;
import com.lik.LikTemplate.mapper.ZhouBianMapper;
import com.lik.LikTemplate.service.UserService;
import com.lik.LikTemplate.service.ZhouBianService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/zhoubian")
public class ZhouBianController {


    @Resource
    private ZhouBianService zhouBianService;


    // 添加
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody ZhouBian zhouBian) {
        System.out.println(zhouBian);
        zhouBian.setCulturalRelicTime(new Date());
        boolean save = zhouBianService.save(zhouBian);

        if (save) {
            return Result.ok().data("item",save);
        } else {
            return Result.error().message("ִ添加失败");
        }
    }

    // 添加
    @RequestMapping("/del")
    @ResponseBody
    public Result del(@RequestParam( value = "id") String id) {
        System.out.println(id);
        boolean b = zhouBianService.removeById(id);
        if (b) {
            return Result.ok().message("周边已下架");
        } else {
            return Result.error().message("ִ添加失败");
        }
    }



    @RequestMapping("/list")
    @ResponseBody
    public Result list() {
        List<ZhouBian> list = zhouBianService.list();
        return Result.ok().data("items",list);
    }

    @RequestMapping("/listByType")
    @ResponseBody
    public Result listByType(@RequestParam( value = "type") String type) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category",type);
        List list = zhouBianService.list(queryWrapper);
        return Result.ok().data("items",list);
    }

    @RequestMapping("/getById")
    @ResponseBody
    public Result getById(@RequestParam( value = "id") String id) {
        ZhouBian byId = zhouBianService.getById(id);
        return Result.ok().data("item",byId);
    }






}
