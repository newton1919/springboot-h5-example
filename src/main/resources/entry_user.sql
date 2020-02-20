/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : h5_example

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-02-20 12:12:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for entry_user
-- ----------------------------
DROP TABLE IF EXISTS `entry_user`;
CREATE TABLE `entry_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `gender` varchar(20) NOT NULL DEFAULT '' COMMENT '性别 : male or female',
  `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '用户个人介绍',
  `status` int(255) NOT NULL DEFAULT '0' COMMENT '0 有效  1 逻辑删除',
  `misc` varchar(255) NOT NULL DEFAULT '' COMMENT '描述(保留字段)',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
