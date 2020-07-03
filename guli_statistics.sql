/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : guli_statistics

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 03/07/2020 09:49:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for statistics_daily
-- ----------------------------
DROP TABLE IF EXISTS `statistics_daily`;
CREATE TABLE `statistics_daily`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `date_calculated` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '统计日期',
  `register_num` int(11) NOT NULL DEFAULT 0 COMMENT '注册人数',
  `login_num` int(11) NOT NULL DEFAULT 0 COMMENT '登录人数',
  `video_view_num` int(11) NOT NULL DEFAULT 0 COMMENT '每日播放视频数',
  `course_num` int(11) NOT NULL DEFAULT 0 COMMENT '每日新增课程数',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `statistics_day`(`date_calculated`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '网站统计日数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of statistics_daily
-- ----------------------------
INSERT INTO `statistics_daily` VALUES ('1273800995302678530', '2020-06-18 10:13:18', 4, 47, 95, 25, '2020-06-19 10:13:18', '2020-06-19 10:13:18');
INSERT INTO `statistics_daily` VALUES ('1273801008502153218', '2020-06-19 10:13:21', 4, 93, 1, 73, '2020-06-19 10:13:21', '2020-06-19 10:13:21');
INSERT INTO `statistics_daily` VALUES ('1273801012948115458', '2020-06-19 10:13:22', 4, 26, 5, 0, '2020-06-19 10:13:22', '2020-06-19 10:13:22');
INSERT INTO `statistics_daily` VALUES ('1273801017012396033', '2020-06-19 10:13:23', 4, 55, 46, 74, '2020-06-19 10:13:23', '2020-06-19 10:13:23');
INSERT INTO `statistics_daily` VALUES ('1273801018698506242', '2020-06-19 10:13:23', 4, 41, 86, 56, '2020-06-19 10:13:24', '2020-06-19 10:13:24');
INSERT INTO `statistics_daily` VALUES ('1273801019495424002', '2020-06-19 10:13:23', 4, 92, 46, 12, '2020-06-19 10:13:24', '2020-06-19 10:13:24');
INSERT INTO `statistics_daily` VALUES ('1273801020237815810', '2020-06-19 10:13:23', 4, 95, 9, 31, '2020-06-19 10:13:24', '2020-06-19 10:13:24');
INSERT INTO `statistics_daily` VALUES ('1273801020971819010', '2020-06-19 10:13:24', 4, 64, 79, 13, '2020-06-19 10:13:24', '2020-06-19 10:13:24');
INSERT INTO `statistics_daily` VALUES ('1273801021680656385', '2020-06-19 10:13:24', 4, 17, 23, 13, '2020-06-19 10:13:24', '2020-06-19 10:13:24');
INSERT INTO `statistics_daily` VALUES ('1273801022402076674', '2020-06-19 10:13:24', 4, 75, 84, 5, '2020-06-19 10:13:24', '2020-06-19 10:13:24');
INSERT INTO `statistics_daily` VALUES ('1273801023052193793', '2020-06-19 10:13:24', 4, 98, 63, 44, '2020-06-19 10:13:25', '2020-06-19 10:13:25');
INSERT INTO `statistics_daily` VALUES ('1273801024692166657', '2020-06-19 10:13:25', 4, 37, 96, 33, '2020-06-19 10:13:25', '2020-06-19 10:13:25');
INSERT INTO `statistics_daily` VALUES ('1273801026600574978', '2020-06-19 10:13:25', 4, 49, 9, 85, '2020-06-19 10:13:25', '2020-06-19 10:13:25');
INSERT INTO `statistics_daily` VALUES ('1273801031075897346', '2020-06-19 10:13:26', 4, 59, 8, 57, '2020-06-19 10:13:27', '2020-06-19 10:13:27');
INSERT INTO `statistics_daily` VALUES ('1273801606765101057', '2020-06-19 10:15:43', 4, 18, 83, 1, '2020-06-19 10:15:44', '2020-06-19 10:15:44');
INSERT INTO `statistics_daily` VALUES ('1273805209672323073', '2020-06-19 10:30:02', 4, 2, 99, 97, '2020-06-19 10:30:03', '2020-06-19 10:30:03');
INSERT INTO `statistics_daily` VALUES ('1273805283190083585', '2020-06-19 10:30:20', 4, 49, 16, 32, '2020-06-19 10:30:20', '2020-06-19 10:30:20');

SET FOREIGN_KEY_CHECKS = 1;
