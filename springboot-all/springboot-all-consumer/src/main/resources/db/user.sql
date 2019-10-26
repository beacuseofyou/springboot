/*
Navicat MySQL Data Transfer

Source Server         : 192.168.116.132
Source Server Version : 50723
Source Host           : 192.168.116.132:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-09-04 16:54:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `nick` varchar(20) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aa', '1231456', 'fdsfsdfsdf', '321@qq.com');
INSERT INTO `user` VALUES ('2', 'bb', '45646654', 'fsad', '98562312@163.com');
INSERT INTO `user` VALUES ('3', 'cc', '24564654', 'f', '346454578@qq.com');
INSERT INTO `user` VALUES ('4', 'dd', '5413215646', 'dsgsder', '64789878@qq.com');
