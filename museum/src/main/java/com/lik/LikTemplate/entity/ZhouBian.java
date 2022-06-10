package com.lik.LikTemplate.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("zhoubian")
public class ZhouBian {

    /**
     * `id` varchar(255) NOT NULL COMMENT 'id',
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;


    /**
     * `title` varchar(255) DEFAULT NULL COMMENT '标题',
     */
    @TableField("name")
    private String name;

    /**
     *`summary` varchar(900) DEFAULT NULL COMMENT '概述',
     */
    @TableField("price")
    private String price;

    /**
     * `title` varchar(255) DEFAULT NULL COMMENT '类型',
     */
    @TableField("category")
    private String category;

    /**
     *    `category` varchar(255) DEFAULT NULL COMMENT '类别',
     */
    @TableField("content")
    private String content;

    /**
     *    `img_url` varchar(255) DEFAULT NULL COMMENT '图片',
     */
    @TableField("img")
    private String img;


    /**
     *`create_time` datetime DEFAULT NULL COMMENT '创建时间',
     */
    @TableField("culturalRelicTime")
    private Date culturalRelicTime;

}
