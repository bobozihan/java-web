/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : java-web

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-01-04 14:35:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
  `user_code` varchar(20) NOT NULL COMMENT '用户编码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `address` text COMMENT '住址',
  `birth_day` date DEFAULT NULL COMMENT '生日',
  `salary` double(8,3) DEFAULT NULL COMMENT '工资',
  `create_by` varchar(20) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(20) NOT NULL COMMENT '修改人',
  `update_date` datetime NOT NULL COMMENT '修改时间',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态，默认为0正常',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
