/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : guli_ipcount

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 03/07/2020 09:49:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for guli_ipcount
-- ----------------------------
DROP TABLE IF EXISTS `guli_ipcount`;
CREATE TABLE `guli_ipcount`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `ip_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录的ip地址',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of guli_ipcount
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
