/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost:3306
 Source Schema         : lik_template

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 25/07/2021 20:03:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for myresources_info
-- ----------------------------
DROP TABLE IF EXISTS `myresources_info`;
CREATE TABLE `myresources_info` (
  `id` varchar(99) NOT NULL,
  `title` varchar(999) DEFAULT NULL,
  `summary` varchar(999) DEFAULT NULL,
  `hits` int(11) DEFAULT '0',
  `msg` varchar(999) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(60) NOT NULL COMMENT '主键id',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  `is_deleted` int(1) DEFAULT '0' COMMENT '逻辑删除标识,0-未删除,1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `xiaodao` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `title` varchar(999) DEFAULT NULL,
    `content` mediumtext DEFAULT NULL,
    `time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `category` (
    `id` VARCHAR(99) NOT NULL COMMENT '分类ID',
    `title` VARCHAR(99) COMMENT '标题',
    `is_delete` VARCHAR(4) COMMENT '是否删除：0，未删除；1，已删除',
    `create_time` datetime  COMMENT '创建时间',
    `update_time` datetime  COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

CREATE TABLE `items` (
    `id` VARCHAR(99) NOT NULL COMMENT '项目ID',
    `cid` VARCHAR(99) NOT NULL  COMMENT '类别ID',
    `title` VARCHAR(99) COMMENT '标题',
    `title_img` VARCHAR(99) COMMENT '标题图片',
    `level` VARCHAR(99) COMMENT '级别：1，初级；2，中级；3，高级',
    `clicks` INT COMMENT '点击量',
    `price` Decimal(10,2) COMMENT '价格',
    `is_delete` VARCHAR(4) COMMENT '是否删除：0，未删除；1，已删除',
    `create_time` datetime  COMMENT '创建时间',
    `update_time` datetime  COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

CREATE TABLE `meirishici` (
    `id` varchar(99) NOT NULL COMMENT '诗词ID',
    `summary` varchar(99) NOT NULL COMMENT '概述',
    `title` varchar(99) DEFAULT NULL COMMENT '标题',
    `dynasty` varchar(99) DEFAULT NULL COMMENT '朝代',
    `author` varchar(99) DEFAULT NULL COMMENT '作者',
    `content` text DEFAULT NULL COMMENT '内容',
    `translate` MEDIUMTEXT  DEFAULT NULL COMMENT '译文',
    `matchTags` varchar(99) DEFAULT NULL COMMENT '标签',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `meiriyiwen` (
    `id` varchar(99) NOT NULL COMMENT '文章ID',
    `title` varchar(99) DEFAULT NULL COMMENT '标题',
    `author` varchar(99) DEFAULT NULL COMMENT '作者',
    `content` MEDIUMTEXT DEFAULT NULL COMMENT '内容',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ONE` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `img` varchar(99) DEFAULT NULL COMMENT '标题',
    `author` varchar(99) DEFAULT NULL COMMENT '作者',
    `content` MEDIUMTEXT DEFAULT NULL COMMENT '内容',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `meiriyiju` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `tts` varchar(99) DEFAULT NULL COMMENT '音频',
    `content` varchar(99) DEFAULT NULL COMMENT '内容',
    `note` MEDIUMTEXT DEFAULT NULL COMMENT '译文',
    `picture` varchar(99) DEFAULT NULL COMMENT '图片1',
    `fenxiang_img` varchar(99) DEFAULT NULL COMMENT '图片1',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `toutiao` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `content` mediumtext DEFAULT NULL COMMENT '内容',
    `display_url` mediumtext DEFAULT NULL COMMENT 'url',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `36Kr` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `content` mediumtext DEFAULT NULL COMMENT '内容',
	`title` varchar(99) DEFAULT NULL COMMENT '标题',
    `image` varchar(99) DEFAULT NULL COMMENT '图片',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `douban` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `content` mediumtext DEFAULT NULL COMMENT '内容',
	`lable` varchar(99) DEFAULT NULL COMMENT '1:新书速递；2热榜',
    `image` varchar(99) DEFAULT NULL COMMENT '图片',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `lishijingtian` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `content` mediumtext DEFAULT NULL COMMENT '内容',
    `title` varchar(99) DEFAULT NULL COMMENT '标题',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sohu` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `title` varchar(99) DEFAULT NULL COMMENT '标题',
    `content` mediumtext DEFAULT NULL COMMENT '内容',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `wangyi` (
    `id` varchar(99) NOT NULL COMMENT 'ID',
    `title` varchar(99) DEFAULT NULL COMMENT '标题',
    `content` mediumtext DEFAULT NULL COMMENT '内容',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE t_user (
uid INT AUTO_INCREMENT COMMENT '用户id',
username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
password CHAR(32) NOT NULL COMMENT '密码',
salt CHAR(36) COMMENT '盐值',
phone VARCHAR(20) COMMENT '电话号码',
email VARCHAR(30) COMMENT '电子邮箱',
gender INT COMMENT '性别:0-女，1-男',
avatar VARCHAR(50) COMMENT '头像',
is_delete INT COMMENT '是否删除：0-未删除，1-已删除',
created_user VARCHAR(20) COMMENT '日志-创建人',
created_time DATETIME COMMENT '日志-创建时间',
modified_user VARCHAR(20) COMMENT '日志-最后修改执行人',
modified_time DATETIME COMMENT '日志-最后修改时间',
PRIMARY KEY (uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



SET FOREIGN_KEY_CHECKS = 1;
