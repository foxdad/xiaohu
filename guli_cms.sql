/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : guli_cms

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 03/07/2020 09:49:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crm_banner
-- ----------------------------
DROP TABLE IF EXISTS `crm_banner`;
CREATE TABLE `crm_banner`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'ID',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标题',
  `image_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `link_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '链接地址',
  `sort` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '首页banner表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of crm_banner
-- ----------------------------
INSERT INTO `crm_banner` VALUES ('1194556896025845762', 'test1', 'https://jiuge-guli.oss-cn-https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/banner.jpg', '/course', 1, 0, '2019-11-13 18:05:32', '2019-11-18 10:28:22');
INSERT INTO `crm_banner` VALUES ('1194607458461216769', 'test2', 'https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/1525939573202.jpg', '/teacher', 2, 0, '2019-11-13 21:26:27', '2019-11-14 09:12:15');

SET FOREIGN_KEY_CHECKS = 1;
