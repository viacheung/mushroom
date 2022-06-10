package com.lik.LikTemplate.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lik.LikTemplate.common.Result;
import com.lik.LikTemplate.entity.Admin;
import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.vo.UserVo;
import com.lik.LikTemplate.entity.vo.userSexVo;
import com.lik.LikTemplate.service.AdminService;
import com.lik.LikTemplate.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ：LIk
 * @description：
 * @date ：Created in 2021/10/26 16:29
 */

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    /**
     * 1.编写接口
     * 2.调用Service
     * 3.Service调用mapper
     *
    // 管理员登录验证
     //订单接口
    @PostMapping("/getDingDanList")
    public Result getDingDanList(@RequestBody Admin admin) {
        boolean flag = adminService.adminLogin(admin);//调用service
        if (flag) {
            return Result.ok();
        } else {
            return Result.error().message("用户名密码错误");
        }
    }
    **/





    // 管理员登录验证
    @PostMapping("/adminLogin")
    public Result AdminLogin(@RequestBody Admin admin) {
        boolean flag = adminService.adminLogin(admin);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error().message("用户名密码错误");
        }
    }

    //=========用户相关操作==========

    // 删除用户
    @RequestMapping("/deleteUser")
    @ResponseBody
    public Result DeleteUser(String userName) {

        System.out.println("删除用户："+userName);
        int rows = adminService.deleteUser(userName);
        if (rows > 0) {
//            System.out.println("成功删除" + rows + "条数据！");
            return Result.ok();
        } else {
//            System.out.println("ִ删除失败");
            return Result.error().message("ִ删除失败");
        }
    }

    // 查询用户
    @RequestMapping("/getUserByName")
    @ResponseBody
    public Result getUserByName(String userName) {
        User user = adminService.getUserByName(userName);
        return Result.ok().data("item",user);//map
    }

    //查询全部用户
    @RequestMapping(value = "/allUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result AllUser(@RequestParam(defaultValue="1",value="page")Integer page, @RequestParam(defaultValue="10",value="limit")Integer limit, @RequestParam(defaultValue="")String userName) throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        UserVo<User> user = adminService.queryAllUser(page,limit,userName);
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);
        System.out.println(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return Result.ok().data("items",user);
    }

    //性别分组查询   ×
    @RequestMapping(value = "/querySex",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String QuerySex() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        List<userSexVo> userlist = adminService.querySex();
        //将我们的对象解析成为json格式
        List<userSexVo> user = new ArrayList<userSexVo>();
        for(userSexVo user1: userlist) {
            user.add(user1);
        }

        String str = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    //=========公告相关操作==========

    //查询全部公告
    @RequestMapping(value = "/allNotice",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result AllNotice(@RequestParam(defaultValue="1",value="page")Integer page, @RequestParam(defaultValue="10",value="limit")Integer limit) throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        UserVo<Notice> notice = adminService.queryNotice(page,limit);
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(notice);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return Result.ok().data("items",notice);
    }

    //删除公告
    @RequestMapping("/deleteNotice")
    @ResponseBody
    public Result DeleteNotice(@RequestParam(defaultValue="1",value="id")String id) {

        System.out.println("删除公告：" + id);
        int rows = adminService.deleteNotice(id);
        if (rows > 0) {
            System.out.println("成功删除" + rows + "条数据！");
            return Result.ok();
        } else {
            System.out.println("ִ删除失败");
            return Result.error().message("ִ删除失败");
        }
    }

    //新增公告
    @RequestMapping(value = "/notice",produces = "application/json;charset=utf-8")
    public Result Notice(@RequestBody Notice notice, Model model) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        notice.setRelease_time(df.format(new Date()));
        notice.setId(FileNameUtils.getSixNum());
        int row = adminService.addNotice(notice);
        if (row > 0) {
            System.out.println("成功添加" + row + "条公告！");
            return Result.ok();
        } else {
            System.out.println("ִ公告添加失败");
            return Result.error().message("ִ公告添加失败");
        }
    }


    // 更新公告
    @RequestMapping("/updateNotice")
    @ResponseBody
    public String UpdateNotice(Notice notice) {

        int rows = adminService.updateNotice(notice);
        if (rows > 0) {
            System.out.println("成功更新" + rows + "条公告！");
            return"OK";

        } else {
            System.out.println("ִ更新公告失败");
            return"F";
        }

    }

    //=========文物相关操作==========
    // 查询全部文物
    @RequestMapping(value = "/allCulturalRelic", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result AllCulturalRelic(@RequestParam(defaultValue = "1", value = "page") Integer page, @RequestParam(defaultValue = "10", value = "limit") Integer limit, @RequestParam(defaultValue = "") String culturalRelicName) throws JsonProcessingException {
        // 创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        UserVo<CulturalRelic> culturalRelic = adminService.queryAllCulturalRelic(page, limit, culturalRelicName);
        // 将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(culturalRelic);
        // 由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return Result.ok().data("items",culturalRelic);
    }

    //=========文物相关操作==========
    // 查询全部文物
    @RequestMapping(value = "/getCulturalRelicById", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result getCulturalRelicById(@RequestParam(defaultValue = "1", value = "id") String id) throws JsonProcessingException {
        // 创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        CulturalRelic culturalRelic = adminService.getCulturalRelicById(id);
        // 将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(culturalRelic);
        // 由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return Result.ok().data("item",culturalRelic);
    }

    // 查询全部文物
    @RequestMapping(value = "/getCulturalRelicByType", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result getCulturalRelicByType(@RequestParam( value = "type") String type) throws JsonProcessingException {
        // 创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        List culturalRelic = adminService.getCulturalRelicByType(type);
        // 将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(culturalRelic);
        // 由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return Result.ok().data("item",culturalRelic);
    }



    // 删除文物信息
    @RequestMapping("/deleteCulturalRelic")
    @ResponseBody
    public Result DeleteCulturalRelic(@RequestParam(value = "id")  String id) {

        int rows = adminService.deleteCulturalRelic(id);
        if (rows > 0) {
            System.out.println("成功删除" + rows + "件文物！");
            return Result.ok();
        } else {
            System.out.println("ִ删除文物失败");
            return Result.error().message("ִ删除文物失败");
        }
    }

    // 新增文物
    @RequestMapping(value = "/culturalRelic", produces = "application/json;charset=utf-8")
    public Result addCulturalRelic(@RequestBody CulturalRelic culturalRelic) {

        culturalRelic.setCulturalRelicId(FileNameUtils.getSixNum());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        culturalRelic.setCulturalRelicTime(df.format(new Date()));
        culturalRelic.setCulturalRelicNumber(0);
        int row = adminService.addCulturalRelic(culturalRelic);
        if (row > 0) {
            System.out.println("成功添加" + row + "件文物！");
            return Result.ok();
        } else {
            System.out.println("ִ文物添加失败");
            return Result.error().message("ִ文物添加失败");
        }
    }



    // 修改文物
    @RequestMapping("/updateCulturalRelic")
    @ResponseBody
    public Result UpdateCulturalRelic(@RequestBody CulturalRelic culturalRelic) {

        int rows = adminService.updateCulturalRelic(culturalRelic);
        if (rows > 0) {
            System.out.println("成功更新" + rows + "件文物！");
            return Result.ok();
        } else {
            System.out.println("ִ更新文物失败");
            return Result.error().message("ִ更新文物失败");
        }
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String saveImgAddress(MultipartFile file) throws IOException {
        /** 保存图片的路径，图片上传成功后，将路径保存到数据库 */
        String filePath = "D:\\project\\museum-front\\src\\assets\\newCu";
        /** 获取原始图片的扩展名 */
        String originalFilename = file.getOriginalFilename();
        /** 生成文件新的名字 */
        String newFileName = UUID.randomUUID() + originalFilename;
        /** 封装上传文件位置的全路径 */
        File targetFile = new File(filePath, newFileName);
        file.transferTo(targetFile);
        return newFileName;
    }

}
