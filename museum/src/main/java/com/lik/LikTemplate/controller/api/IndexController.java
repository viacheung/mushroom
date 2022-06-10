package com.lik.LikTemplate.controller.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lik.LikTemplate.common.Result;
import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：LiK
 * @date ：2021/9/12 9:06 上午
 */


@CrossOrigin
@RequestMapping("/api")
@RestController
public class IndexController {


    @Resource
    private UserService userService;

    // 最新公告
    @PostMapping(value = "/newNotice", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result newNotice() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Notice> noticeVo = userService.newNotice();
        String str = mapper.writeValueAsString(noticeVo);
        // System.out.print(str);
        return Result.ok().data("items",noticeVo);
    }

    // 最新文物
    @PostMapping(value = "/newCu", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result newCu() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<CulturalRelic> newCu = userService.newCu();
        String str = mapper.writeValueAsString(newCu);
        // System.out.print(str);
        return Result.ok().data("items",newCu);
    }

    // 查询所有藏品
    @RequestMapping(value = "/queryCulturalRelic", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result queryCulturalRelic() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        List<CulturalRelic> culturalRelics = userService.queryCulturalRelic();
        // System.out.print(culturalRelics);
        String str = mapper.writeValueAsString(culturalRelics);
        return Result.ok().data("items",culturalRelics);
    }









}
