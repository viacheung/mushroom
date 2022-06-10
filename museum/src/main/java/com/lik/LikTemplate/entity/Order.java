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
@AllArgsConstructor//带参构造
@NoArgsConstructor//无参构造
@TableName("orders")//**实体类与sql表名映射**
public class Order {

    /**
     * `id` varchar(255) NOT NULL COMMENT 'id',
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)//设置主键映射 value映射主键字段的名字  type 设置主键类型 主键的生成策略
    private String id;//使用mp自动赋值 采取雪花算法

    /**
     * `title` varchar(255) DEFAULT NULL COMMENT '标题',
     */
    @TableField("zid")
    private String zid;

    /**
     *`summary` varchar(900) DEFAULT NULL COMMENT '概述',
     */
    @TableField("uid")
    private String uid;

    /**
     * `title` varchar(255) DEFAULT NULL COMMENT '类型',
     */
    @TableField("state")
    private String state;


    /**
     *`create_time` datetime DEFAULT NULL COMMENT '创建时间',
     */
    @TableField("culturalRelicTime")
    private Date culturalRelicTime;


}
