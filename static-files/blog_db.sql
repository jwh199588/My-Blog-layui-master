/*
Navicat MySQL Data Transfer

Source Server         : ggj
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : blog_db

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-01-19 15:14:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_blog_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_category`;
CREATE TABLE `tb_blog_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
  `category_name` varchar(50) NOT NULL COMMENT '分类的名称',
  `category_icon` varchar(50) DEFAULT NULL COMMENT '分类的图标',
  `category_rank` int(11) NOT NULL DEFAULT '1' COMMENT '分类的排序值 被使用的越多数值越大',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='博客分类';

-- ----------------------------
-- Records of tb_blog_category
-- ----------------------------
INSERT INTO `tb_blog_category` VALUES ('1', '默认分类', '', '1', '0', '2019-08-30 15:07:02');
INSERT INTO `tb_blog_category` VALUES ('26', 'java', null, '1', '0', '2021-01-18 05:50:15');

-- ----------------------------
-- Table structure for tb_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_comment`;
CREATE TABLE `tb_blog_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联的blog主键',
  `commentator` varchar(50) NOT NULL DEFAULT '' COMMENT '评论者名称',
  `email` varchar(100) NOT NULL DEFAULT '' COMMENT '评论人的邮箱',
  `website_url` varchar(50) DEFAULT '' COMMENT '网址',
  `comment_body` varchar(200) NOT NULL DEFAULT '' COMMENT '评论内容',
  `comment_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论提交时间',
  `commentator_ip` varchar(20) DEFAULT '' COMMENT '评论时的ip地址',
  `reply_body` varchar(200) DEFAULT '' COMMENT '回复内容',
  `reply_create_time` datetime DEFAULT NULL COMMENT '回复时间',
  `comment_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否审核通过 0-未审核 1-审核通过',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='评论信息表';

-- ----------------------------
-- Records of tb_blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_blog_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_config`;
CREATE TABLE `tb_blog_config` (
  `config_field` varchar(20) NOT NULL DEFAULT '' COMMENT '字段名',
  `config_name` varchar(50) NOT NULL COMMENT '配置名',
  `config_value` varchar(200) NOT NULL DEFAULT '' COMMENT '配置项的值',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`config_field`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_blog_config
-- ----------------------------
INSERT INTO `tb_blog_config` VALUES ('sysAuthor', '开发者', '贾先生', '2019-08-24 20:33:17', '2021-01-14 14:19:14');
INSERT INTO `tb_blog_config` VALUES ('sysAuthorImg', '开发者头像', '/authorImg/20210115/20210115_18051617.jpg', '2019-08-24 20:33:14', '2019-08-24 21:56:23');
INSERT INTO `tb_blog_config` VALUES ('sysCopyRight', '版权所有', '贾先生', '2019-08-24 20:33:31', '2021-01-14 14:19:19');
INSERT INTO `tb_blog_config` VALUES ('sysEmail', '开发者邮箱', '1262466460@qq.com', '2019-08-24 14:06:48', '2021-01-14 14:18:39');
INSERT INTO `tb_blog_config` VALUES ('sysUpdateTime', '最后修改时间', '2021-01-14', '2019-08-24 20:33:20', '2021-01-14 14:18:55');
INSERT INTO `tb_blog_config` VALUES ('sysUrl', '服务器url', 'http://121.37.17.42:28083/', '2019-08-24 14:03:23', '2021-01-18 01:51:00');
INSERT INTO `tb_blog_config` VALUES ('sysVersion', '当前版本号', '1.1.0', '2019-08-24 20:33:23', '2019-08-24 11:58:06');
INSERT INTO `tb_blog_config` VALUES ('websiteName', '博客名', '贾先生的博客', '2018-11-11 20:33:01', '2021-01-14 14:21:38');

-- ----------------------------
-- Table structure for tb_blog_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_info`;
CREATE TABLE `tb_blog_info` (
  `blog_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '博客表主键id',
  `blog_title` varchar(200) NOT NULL COMMENT '博客标题',
  `blog_sub_url` varchar(200) NOT NULL COMMENT '博客自定义路径url',
  `blog_preface` varchar(255) NOT NULL COMMENT '博客前言',
  `blog_content` mediumtext NOT NULL COMMENT '博客内容',
  `blog_category_id` int(11) NOT NULL COMMENT '博客分类id',
  `blog_category_name` varchar(50) NOT NULL COMMENT '博客分类(冗余字段)',
  `blog_tags` varchar(200) DEFAULT NULL COMMENT '博客标签(冗余字段)',
  `blog_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-草稿 1-发布',
  `blog_views` bigint(20) NOT NULL DEFAULT '0' COMMENT '阅读量',
  `enable_comment` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-允许评论 1-不允许评论',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='博客信息表';

-- ----------------------------
-- Records of tb_blog_info
-- ----------------------------
INSERT INTO `tb_blog_info` VALUES ('1', '自我介绍', '', '一个默默无闻的程序员', '![](/articleImg/20210119/20210119_15133595.jpg)\n作为一个年轻的程序员，在闲暇时刻做了这个博客，主要是用来记录日常的一些工作经历，分享自己学到的一些知识', '1', '默认分类', '默认标题', '1', '25', '1', '0', '2021-01-19 07:13:40', '2021-01-19 07:13:40');

-- ----------------------------
-- Table structure for tb_blog_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_link`;
CREATE TABLE `tb_blog_link` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '友链表主键id',
  `link_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '友链类别 0-友链 1-推荐 2-个人网站',
  `link_name` varchar(50) NOT NULL COMMENT '网站名称',
  `link_url` varchar(100) NOT NULL COMMENT '网站链接',
  `link_description` varchar(100) NOT NULL COMMENT '网站描述',
  `link_rank` int(11) NOT NULL DEFAULT '0' COMMENT '用于列表排序',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`link_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='友情链接表';

-- ----------------------------
-- Records of tb_blog_link
-- ----------------------------

-- ----------------------------
-- Table structure for tb_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag`;
CREATE TABLE `tb_blog_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
  `tag_name` varchar(100) NOT NULL COMMENT '标签名称',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='标签表';

-- ----------------------------
-- Records of tb_blog_tag
-- ----------------------------
INSERT INTO `tb_blog_tag` VALUES ('1', '默认标题', '0', '2019-09-01 11:19:47');
INSERT INTO `tb_blog_tag` VALUES ('140', '获取一个小黄鸭', '0', '2021-01-18 05:51:30');

-- ----------------------------
-- Table structure for tb_blog_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_tag_relation`;
CREATE TABLE `tb_blog_tag_relation` (
  `relation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系表id',
  `blog_id` bigint(20) NOT NULL COMMENT '博客id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=343 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='博客跟标签的关系表';

-- ----------------------------
-- Records of tb_blog_tag_relation
-- ----------------------------
INSERT INTO `tb_blog_tag_relation` VALUES ('339', '8', '140', '2021-01-18 13:52:19');
INSERT INTO `tb_blog_tag_relation` VALUES ('340', '9', '1', '2021-01-19 14:23:32');
INSERT INTO `tb_blog_tag_relation` VALUES ('342', '1', '1', '2021-01-19 15:13:39');

-- ----------------------------
-- Table structure for tb_sec_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_sec_user`;
CREATE TABLE `tb_sec_user` (
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_roles` varchar(255) DEFAULT NULL COMMENT '用户角色',
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_sec_user
-- ----------------------------
INSERT INTO `tb_sec_user` VALUES ('admin', '$2a$10$xVeKtM6f6p3D/NqdXhYAQOV92Ka2y2yqQfQI9SOHMlPPLLWhn0d1e', 'ROLE_USER', '贾先生');
