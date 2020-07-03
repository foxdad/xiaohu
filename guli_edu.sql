/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : guli_edu

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 03/07/2020 09:49:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_chapter
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '章节ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '章节名称',
  `sort` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '显示排序',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1', '14', '第一章：HTML', 0, '2019-01-01 12:27:40', '2019-01-01 12:55:30');
INSERT INTO `edu_chapter` VALUES ('1181729226915577857', '18', '第七章：I/O流', 7, '2019-10-09 08:32:58', '2019-10-09 08:33:20');
INSERT INTO `edu_chapter` VALUES ('1192252428399751169', '1192252213659774977', '第一章节', 1, '2019-11-07 09:28:25', '2019-11-07 09:28:25');
INSERT INTO `edu_chapter` VALUES ('1275244781123866625', '18', 'Java成神之路', 8, '2020-06-23 09:50:23', '2020-06-23 09:50:23');
INSERT INTO `edu_chapter` VALUES ('1275257400501104642', '18', '收藏二十', 20, '2020-06-23 10:40:32', '2020-06-23 10:40:32');
INSERT INTO `edu_chapter` VALUES ('1275259152982052865', '18', 'java成神之路', 8, '2020-06-23 10:47:30', '2020-06-23 10:47:30');
INSERT INTO `edu_chapter` VALUES ('1275260758213496833', '18', 'Java成神之路二', 9, '2020-06-23 10:53:53', '2020-06-23 10:53:53');
INSERT INTO `edu_chapter` VALUES ('1275261118806200321', '18', 'Java成神之路三', 10, '2020-06-23 10:55:19', '2020-06-23 10:55:19');
INSERT INTO `edu_chapter` VALUES ('1275261863853002754', '18', 'Java成神之路4', 11, '2020-06-23 10:58:16', '2020-06-23 10:58:16');
INSERT INTO `edu_chapter` VALUES ('1275268907804897282', '18', 'Java成神之路6', 13, '2020-06-23 11:26:16', '2020-06-23 11:26:16');
INSERT INTO `edu_chapter` VALUES ('1275273424248127490', '18', '笑笑', 19, '2020-06-23 11:44:12', '2020-06-23 11:44:12');
INSERT INTO `edu_chapter` VALUES ('1275615790226149378', '18', 'java入坑之路', 14, '2020-06-24 10:24:39', '2020-06-24 10:24:39');
INSERT INTO `edu_chapter` VALUES ('1275616501743685633', '18', 'SpringBoot', 20, '2020-06-24 10:27:28', '2020-06-24 10:27:28');
INSERT INTO `edu_chapter` VALUES ('15', '18', '第一章：Java入门', 0, '2019-01-01 12:27:40', '2019-10-09 09:13:19');
INSERT INTO `edu_chapter` VALUES ('3', '14', '第二章：CSS', 2, '2019-01-01 12:55:35', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('32', '18', '第二章：控制台输入和输出', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('44', '18', '第三章：控制流', 3, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('48', '18', '第四章：类的定义', 4, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('63', '18', '第五章：数组', 5, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('64', '18', '第六章：继承', 66, '2019-01-01 12:27:40', '2019-10-09 08:32:47');

-- ----------------------------
-- Table structure for edu_comment
-- ----------------------------
DROP TABLE IF EXISTS `edu_comment`;
CREATE TABLE `edu_comment`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '讲师ID',
  `course_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `thumb_up_numberint` int(11) NULL DEFAULT 0,
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id`) USING BTREE,
  INDEX `idx_member_id`(`member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_comment
-- ----------------------------
INSERT INTO `edu_comment` VALUES ('1194499162790211585', '18', '1189389726308478977', '1', '小三123', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '课程很好', 0, NULL, '2019-11-13 14:16:08', '2019-11-13 14:16:08');
INSERT INTO `edu_comment` VALUES ('1194898406466420738', '18', '1189389726308478977', '1', '小三123', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '11', 0, NULL, '2019-11-14 16:42:35', '2019-11-14 16:42:35');
INSERT INTO `edu_comment` VALUES ('1194898484388200450', '18', '1189389726308478977', '1', '小三123', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '111', 0, NULL, '2019-11-14 16:42:53', '2019-11-14 16:42:53');
INSERT INTO `edu_comment` VALUES ('1195251020861317122', '18', '1189389726308478977', '1', NULL, NULL, '2233', 0, NULL, '2019-11-15 16:03:45', '2019-11-15 16:03:45');
INSERT INTO `edu_comment` VALUES ('1195251382720700418', '18', '1189389726308478977', '1', NULL, NULL, '4455', 0, NULL, '2019-11-15 16:05:11', '2019-11-15 16:05:11');
INSERT INTO `edu_comment` VALUES ('1195252819177570306', '18', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '55', 0, NULL, '2019-11-15 16:10:53', '2019-11-15 16:10:53');
INSERT INTO `edu_comment` VALUES ('1195252899448160258', '18', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '55', 0, NULL, '2019-11-15 16:11:13', '2019-11-15 16:11:13');
INSERT INTO `edu_comment` VALUES ('1195252920587452417', '18', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '223344', 0, NULL, '2019-11-15 16:11:18', '2019-11-15 16:11:18');
INSERT INTO `edu_comment` VALUES ('1195262128095559681', '18', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '11', 0, NULL, '2019-11-15 16:47:53', '2019-11-15 16:47:53');
INSERT INTO `edu_comment` VALUES ('1196264505170767874', '18', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '666666', 0, NULL, '2019-11-18 11:10:58', '2019-11-18 11:10:58');
INSERT INTO `edu_comment` VALUES ('1272735704632205314', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:40:13', '2020-06-16 11:40:13');
INSERT INTO `edu_comment` VALUES ('1272735754770915329', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:40:25', '2020-06-16 11:40:25');
INSERT INTO `edu_comment` VALUES ('1272735781513797633', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:40:31', '2020-06-16 11:40:31');
INSERT INTO `edu_comment` VALUES ('1272736006991192065', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:25', '2020-06-16 11:41:25');
INSERT INTO `edu_comment` VALUES ('1272736009046401026', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:26', '2020-06-16 11:41:26');
INSERT INTO `edu_comment` VALUES ('1272736012422815745', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:26', '2020-06-16 11:41:26');
INSERT INTO `edu_comment` VALUES ('1272736013467197442', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:27', '2020-06-16 11:41:27');
INSERT INTO `edu_comment` VALUES ('1272736015480463362', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:27', '2020-06-16 11:41:27');
INSERT INTO `edu_comment` VALUES ('1272736020840783873', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:28', '2020-06-16 11:41:28');
INSERT INTO `edu_comment` VALUES ('1272736044630876162', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:34', '2020-06-16 11:41:34');
INSERT INTO `edu_comment` VALUES ('1272736047545917442', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:35', '2020-06-16 11:41:35');
INSERT INTO `edu_comment` VALUES ('1272736049399799809', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:35', '2020-06-16 11:41:35');
INSERT INTO `edu_comment` VALUES ('1272736062502805505', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:38', '2020-06-16 11:41:38');
INSERT INTO `edu_comment` VALUES ('1272736064839032833', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:41:39', '2020-06-16 11:41:39');
INSERT INTO `edu_comment` VALUES ('1272737348635795458', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试', 0, 0, '2020-06-16 11:46:45', '2020-06-16 11:46:45');
INSERT INTO `edu_comment` VALUES ('1272737779285958657', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试评论', 0, 0, '2020-06-16 11:48:28', '2020-06-16 11:48:28');
INSERT INTO `edu_comment` VALUES ('1272738229645156353', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '手动阀打法', 0, 0, '2020-06-16 11:50:15', '2020-06-16 11:50:15');
INSERT INTO `edu_comment` VALUES ('1272738351254806530', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '发发是案说法', 0, 0, '2020-06-16 11:50:44', '2020-06-16 11:50:44');
INSERT INTO `edu_comment` VALUES ('1272738778578886657', '', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '在线测试数据', 0, 0, '2020-06-16 11:52:26', '2020-06-16 11:52:26');
INSERT INTO `edu_comment` VALUES ('1272740244416823297', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '上的房间案例', 0, 0, '2020-06-16 11:58:15', '2020-06-16 11:58:15');
INSERT INTO `edu_comment` VALUES ('1272759285390966785', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '测试数据添加', 0, 0, '2020-06-16 13:13:55', '2020-06-16 13:13:55');
INSERT INTO `edu_comment` VALUES ('1272759586026033153', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '重新测试数据的添加', 0, 0, '2020-06-16 13:15:07', '2020-06-16 13:15:07');
INSERT INTO `edu_comment` VALUES ('1272760043494576129', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '又来测试了', 0, 0, '2020-06-16 13:16:56', '2020-06-16 13:16:56');
INSERT INTO `edu_comment` VALUES ('1272807278529945601', '18', '1189389726308478977', '', '', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '数据测试', 0, 0, '2020-06-16 16:24:37', '2020-06-16 16:24:37');
INSERT INTO `edu_comment` VALUES ('1273182985219178497', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '支付测试求通过', 0, 0, '2020-06-17 17:17:33', '2020-06-17 17:17:33');
INSERT INTO `edu_comment` VALUES ('1273183057331847170', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '通惠河', 0, 0, '2020-06-17 17:17:50', '2020-06-17 17:17:50');
INSERT INTO `edu_comment` VALUES ('1273183090185830401', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '的咖啡了多久啦就', 0, 0, '2020-06-17 17:17:58', '2020-06-17 17:17:58');
INSERT INTO `edu_comment` VALUES ('1273191407520022530', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '发达发达发', 0, 0, '2020-06-17 17:51:01', '2020-06-17 17:51:01');
INSERT INTO `edu_comment` VALUES ('1273191407599714306', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '发达发达发', 0, 0, '2020-06-17 17:51:01', '2020-06-17 17:51:01');
INSERT INTO `edu_comment` VALUES ('1273191407641657346', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '发达发达发', 0, 0, '2020-06-17 17:51:01', '2020-06-17 17:51:01');
INSERT INTO `edu_comment` VALUES ('1273253199306776577', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '发发', 0, 0, '2020-06-17 21:56:33', '2020-06-17 21:56:33');
INSERT INTO `edu_comment` VALUES ('1273253219586236418', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '发达发达', 0, 0, '2020-06-17 21:56:38', '2020-06-17 21:56:38');
INSERT INTO `edu_comment` VALUES ('1273253237131010050', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '打发发', 0, 0, '2020-06-17 21:56:42', '2020-06-17 21:56:42');
INSERT INTO `edu_comment` VALUES ('1273253255372038146', '1192252213659774977', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '阿凡达发的说法打法', 0, 0, '2020-06-17 21:56:47', '2020-06-17 21:56:47');
INSERT INTO `edu_comment` VALUES ('1273255274514178050', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '啊多发点是', 0, 0, '2020-06-17 22:04:48', '2020-06-17 22:04:48');
INSERT INTO `edu_comment` VALUES ('1273255574746652673', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '发发打发', 0, 0, '2020-06-17 22:06:00', '2020-06-17 22:06:00');
INSERT INTO `edu_comment` VALUES ('1273255618535186433', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '1111111111', 0, 0, '2020-06-17 22:06:10', '2020-06-17 22:06:10');
INSERT INTO `edu_comment` VALUES ('1273255654253879298', '18', '1189389726308478977', '1191600824445046786', 'qy', 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', '111111', 0, 0, '2020-06-17 22:06:19', '2020-06-17 22:06:19');

-- ----------------------------
-- Table structure for edu_comment_childer
-- ----------------------------
DROP TABLE IF EXISTS `edu_comment_childer`;
CREATE TABLE `edu_comment_childer`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论子级id',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论的课程id',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论父级id',
  `by_reply_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被回复id',
  `by_reply_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被回复用户',
  `by_reply_id_avater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被回复用户图片',
  `call_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复用户',
  `avater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复人图片',
  `call_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复id',
  `connet` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `thumb_up_numberint` int(11) NULL DEFAULT 0 COMMENT '点赞数',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_comment_childer
-- ----------------------------

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程标题',
  `price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售数量',
  `view_count` bigint(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览数量',
  `version` bigint(20) UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint(3) NULL DEFAULT NULL COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE,
  INDEX `idx_subject_id`(`subject_id`) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('1192252213659774977', '1189389726308478977', '1178214681139539969', '1178214681118568449', 'java基础课程：test', 0.01, 2, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 4, 423, 1, 'Normal', 0, '2019-11-07 09:27:33', '2020-06-25 16:20:25');
INSERT INTO `edu_course` VALUES ('1274299567655747586', '1189389726308478977', 'JavaScript', '1178214681181483010', '111', 10.00, 10, 'https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/2020/06/20/a7001cc1_default.jpg', 0, 2, 1, 'Draft', NULL, '2020-06-20 19:14:27', '2020-06-25 16:20:12');
INSERT INTO `edu_course` VALUES ('1274303551456120833', '1189426437876985857', '1178214681353449473', '1178214681324089345', '小狐在线测试', 0.00, 11, 'https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/2020/06/20/304244bf_default.jpg', 0, 1, 1, 'Draft', NULL, '2020-06-20 19:30:17', '2020-06-25 16:20:19');
INSERT INTO `edu_course` VALUES ('1274305288745226242', '1263751774478520322', '1178214681428946945', '1178214681399586817', '测试数据', 0.00, 220, 'https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/2020/06/20/eef3dd58_default.jpg', 0, 1, 1, 'Draft', NULL, '2020-06-20 19:37:11', '2020-06-23 16:32:25');
INSERT INTO `edu_course` VALUES ('1274306430644473857', '1189426464967995393', '1178214681252786178', '1178214681231814658', '在线添加', 0.00, 330, 'https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/2020/06/20/f34d80ce_default.jpg', 0, 0, 1, 'Draft', NULL, '2020-06-20 19:41:43', '2020-06-20 19:41:43');
INSERT INTO `edu_course` VALUES ('1274306898540056578', '', '', '', '', 0.00, 0, '/static/default1.jpg', 0, 0, 1, 'Draft', NULL, '2020-06-20 19:43:35', '2020-06-20 19:43:35');
INSERT INTO `edu_course` VALUES ('14', '1189389726308478977', '1101348944971091969', '1101348944920760321', 'XHTML CSS2 JS整站制作教程课程学习', 0.00, 3, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 3, 76, 15, 'Normal', 0, '2018-04-02 18:33:34', '2020-06-18 12:04:22');
INSERT INTO `edu_course` VALUES ('15', '1189389726308478977', '1101348944971091969', '1101348944920760321', 'HTML5入门课程学习', 0.00, 23, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 0, 75, 17, 'Normal', 0, '2018-04-02 18:34:32', '2020-06-18 11:52:35');
INSERT INTO `edu_course` VALUES ('18', '1189389726308478977', '1178214681139539969', '1178214681118568449', 'Java精品课程', 0.01, 20, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 153, 1005, 6, 'Normal', 0, '2018-04-02 21:28:46', '2020-07-01 15:11:32');
INSERT INTO `edu_course` VALUES ('19', '1189289726308478977', '1178214681139539969', '1178214681118568449', '小狐吊打面试官系列', 6789.89, 0, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 0, 2, 1, 'Normal', NULL, '2020-06-09 17:23:07', '2020-06-18 11:52:57');
INSERT INTO `edu_course` VALUES ('33', '1264090456863502337', '1264090456863502332', '1264090226863502337', '手写reids底层', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200427/223532-15879981322506.jpg', 0, 9907, 2, 'Normal', 0, '2020-06-12 22:56:10', '2020-06-18 12:42:34');
INSERT INTO `edu_course` VALUES ('337', '1264090456863502337', '1264090456263502332', '1264390226863502337', '手写Jenkis', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200313/171754-15840910748da2.jpg', 0, 2401, 1, 'Normal', 0, '2020-06-12 23:11:52', '2020-06-18 11:48:12');
INSERT INTO `edu_course` VALUES ('338', '1264090456863502337', '1264090456263502332', '1264390226863502337', '小姐姐带你玩转Spring全家桶', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200311/213935-158393397557fb.jpg', 0, 1314529, 1, 'Normal', 0, '2020-06-12 23:11:52', '2020-06-18 12:42:47');
INSERT INTO `edu_course` VALUES ('343', '1264090456863502337', '1264090456263502332', '1264390226863502337', '手写zookeeper底层', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200424/235135-15877434952b9d.jpg', 0, 1004, 1, 'Normal', 0, '2020-06-12 23:11:52', '2020-06-18 15:08:02');
INSERT INTO `edu_course` VALUES ('349', '1264090456863502337', '1264090456263502332', '1264390226863502337', 'Netty就那么简单', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200203/113453-15807008934092.jpg', 1314520, 12322299, 1, 'Normal', 0, '2020-06-12 23:11:52', '2020-06-18 11:40:38');
INSERT INTO `edu_course` VALUES ('353', '1264090456863502337', '1264090456863572332', '1264090236863502337', '手写tomcat底层', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200416/214734-158704485443d1.jpg', 0, 982299, 1, 'Normal', 0, '2020-06-12 23:08:57', '2020-06-18 08:36:22');
INSERT INTO `edu_course` VALUES ('35333', '1264090456863502337', '1264090456863572332', '1264090236863502337', '手写mysql底层', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200416/214734-158704485443d1.jpg', 0, 982299, 1, 'Normal', 0, '2020-06-12 23:12:22', '2020-06-18 10:14:13');
INSERT INTO `edu_course` VALUES ('362', '1264090456863502337', '1264090456263502332', '1264390226863502337', '手写linux', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200330/231042-15855810428a56.jpg', 0, 9232392, 1, 'Normal', 0, '2020-06-12 23:11:52', '2020-06-18 12:02:39');
INSERT INTO `edu_course` VALUES ('450', '1264090456863502337', '1264090456263502332', '1264390226863502337', '小姐姐教你人肉运维', 20.00, 0, 'http://pic.netbian.com/uploads/allimg/200206/160735-15809764553e78.jpg', 520, 77786, 1, 'Normal', 0, '2020-06-12 23:11:52', '2020-06-18 11:52:00');

-- ----------------------------
-- Table structure for edu_course_collect
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_collect`;
CREATE TABLE `edu_course_collect`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收藏ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程收藏' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_course_collect
-- ----------------------------
INSERT INTO `edu_course_collect` VALUES ('1196269345666019330', '1192252213659774977', '1', 1, '2019-11-18 11:30:12', '2019-11-18 11:30:12');

-- ----------------------------
-- Table structure for edu_course_description
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程ID',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '课程简介',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程简介' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1104870479077879809', '<p>11</p>', '2019-03-11 06:23:44', '2019-03-11 06:23:44');
INSERT INTO `edu_course_description` VALUES ('1192252213659774977', '<p>测试</p>', '2019-11-07 09:27:33', '2019-11-13 16:21:28');
INSERT INTO `edu_course_description` VALUES ('14', '', '2019-03-13 06:04:43', '2019-03-13 06:05:33');
INSERT INTO `edu_course_description` VALUES ('15', '', '2019-03-13 06:03:33', '2019-03-13 06:04:22');
INSERT INTO `edu_course_description` VALUES ('18', '<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>', '2019-03-06 18:06:36', '2019-10-30 19:58:36');

-- ----------------------------
-- Table structure for edu_subject
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别名称',
  `parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程科目' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('1178214681118568449', '后端开发', '0', 1, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681139539969', 'Java', '1178214681118568449', 1, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681181483010', '前端开发', '0', 3, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681210843137', 'JavaScript', '1178214681181483010', 4, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681231814658', '云计算', '0', 5, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681252786178', 'Docker', '1178214681231814658', 5, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681294729217', 'Linux', '1178214681231814658', 6, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681324089345', '系统/运维', '0', 7, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681353449473', 'Linux', '1178214681324089345', 7, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681382809602', 'Windows', '1178214681324089345', 8, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681399586817', '数据库', '0', 9, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681428946945', 'MySQL', '1178214681399586817', 9, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681454112770', 'MongoDB', '1178214681399586817', 10, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681483472898', '大数据', '0', 11, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681504444418', 'Hadoop', '1178214681483472898', 11, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681529610242', 'Spark', '1178214681483472898', 12, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681554776066', '人工智能', '0', 13, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681584136193', 'Python', '1178214681554776066', 13, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681613496321', '编程语言', '0', 14, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178214681626079234', 'Java', '1178214681613496321', 14, '2019-09-29 15:47:25', '2019-09-29 15:47:25');
INSERT INTO `edu_subject` VALUES ('1178585108407984130', 'Python', '1178214681118568449', 2, '2019-09-30 16:19:22', '2019-09-30 16:19:22');
INSERT INTO `edu_subject` VALUES ('1178585108454121473', 'HTML/CSS', '1178214681181483010', 3, '2019-09-30 16:19:22', '2019-09-30 16:19:22');
INSERT INTO `edu_subject` VALUES ('1265096671961772034', '前端', '0', 0, '2020-05-26 09:45:26', '2020-05-26 09:45:26');
INSERT INTO `edu_subject` VALUES ('1265096672125349889', '后端', '0', 0, '2020-05-26 09:45:26', '2020-05-26 09:45:26');
INSERT INTO `edu_subject` VALUES ('1265098423578591234', 'Vue', '1265096671961772034', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423628922881', 'Bootstarp', '1265096671961772034', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423675060226', 'Layui', '1265096671961772034', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423712808962', 'WebSocket', '1265096671961772034', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423746363394', 'Node.js', '1265096671961772034', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423788306434', 'php', '1265096672125349889', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423830249473', 'java', '1265096672125349889', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423867998209', 'Redis', '1265096672125349889', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423905746946', 'HBase', '1265096672125349889', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265098423943495681', '小程序开发', '1265096671961772034', 0, '2020-05-26 09:52:23', '2020-05-26 09:52:23');
INSERT INTO `edu_subject` VALUES ('1265118844021608449', '测试数据', '0', 0, '2020-05-26 11:13:32', '2020-05-26 11:13:32');
INSERT INTO `edu_subject` VALUES ('1265118844105494529', '测试数据', '1265118844021608449', 0, '2020-05-26 11:13:32', '2020-05-26 11:13:32');
INSERT INTO `edu_subject` VALUES ('1265118844134854657', '测试', '0', 0, '2020-05-26 11:13:32', '2020-05-26 11:13:32');
INSERT INTO `edu_subject` VALUES ('1265118844160020481', '测试', '1265118844134854657', 0, '2020-05-26 11:13:32', '2020-05-26 11:13:32');
INSERT INTO `edu_subject` VALUES ('1265123345684107265', '新数据', '0', 0, '2020-05-26 11:31:25', '2020-05-26 11:31:25');
INSERT INTO `edu_subject` VALUES ('1265123345738633218', '新测试', '1265123345684107265', 0, '2020-05-26 11:31:25', '2020-05-26 11:31:25');

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '讲师ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int(10) UNSIGNED NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '讲师头像',
  `sort` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '讲师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1', '张三', '近年主持国家自然科学基金（6项）、江苏省重大科技成果转化项目（5项）、江苏省产学研前瞻性联合研究项目（3项）、省工业科技支撑、省高技术、省自然科学基金等省部级及其企业的主要科研项目40多个，多个项目在企业成功转化，产生了较好的经济、社会和环境效益。积极开展产学研科技合作，并与省内16家企业建立了江苏省研究生工作站，其中6家为江苏省优秀研究生工作站', '高级', 2, 'http://pic.netbian.com/uploads/allimg/200527/233932-15905939722e02.jpg', 0, 1, '2019-10-30 14:18:46', '2019-11-12 13:36:36');
INSERT INTO `edu_teacher` VALUES ('1189389726308478977', '晴天', '高级讲师简介', '高级讲师资历', 1, 'http://pic.netbian.com/uploads/allimg/200609/000616-1591632376f4c2.jpg', 1, 0, '2019-10-30 11:53:03', '2020-05-25 14:55:42');
INSERT INTO `edu_teacher` VALUES ('1189390295668469762', '李刚22222', '高级讲师简介', '高级讲师', 2, 'http://pic.netbian.com/uploads/allimg/200528/120942-1590638982591b.jpg', 8, 0, '2019-10-30 11:55:19', '2020-05-23 14:54:23');
INSERT INTO `edu_teacher` VALUES ('1189426437876985857', '王二', '高级讲师简介就是个fw\n', '高级讲师', 1, 'http://pic.netbian.com/uploads/allimg/200528/124605-15906411653cfb.jpg', 0, 0, '2019-10-30 14:18:56', '2020-05-24 18:02:35');
INSERT INTO `edu_teacher` VALUES ('1189426464967995393', '王五', '高级讲师简介', '高级讲师', 1, 'http://pic.netbian.com/uploads/allimg/200605/212133-1591363293b300.jpg', 0, 0, '2019-10-30 14:19:02', '2019-11-12 13:37:18');
INSERT INTO `edu_teacher` VALUES ('1192249914833055746', '李四', '高级讲师简介', '高级讲师', 1, 'http://pic.netbian.com/uploads/allimg/200608/233814-15916306949010.jpg', 0, 1, '2019-11-07 09:18:25', '2019-11-12 13:37:01');
INSERT INTO `edu_teacher` VALUES ('1192327476087115778', '1222-12-12', '1111', '11', 1, 'http://pic.netbian.com/uploads/allimg/200609/205753-1591707473ea33.jpg', 0, 1, '2019-11-07 14:26:37', '2019-11-11 16:26:26');
INSERT INTO `edu_teacher` VALUES ('1195337453429129218', 'test', 'sdfsdf', 'sdfdf', 1, 'http://pic.netbian.com/uploads/allimg/200609/210405-1591707845e5f8.jpg', 0, 1, '2019-11-15 21:47:12', '2019-11-15 21:47:27');
INSERT INTO `edu_teacher` VALUES ('1263749482987585538', '马化腾', '2017年8月7日，腾讯股价盘中再创历史新高价320.6港元，马化腾身家361亿美元成为中国首富。 [4]  2018年4月，获《时代周刊》2018年全球最具影响力人物荣誉。 [5]  2018年10月25日，福布斯发布了2018福布斯中国400富豪榜，马化腾凭借328亿美元的身家蝉联榜单第二名。2018年12月18日，党中央、国务院授予马化腾同志改革先锋称号，颁授改革先锋奖章 [6]  。2019年3月，马化腾以388亿美元财富排名2019年福布斯全球亿万富豪榜第20位。 [7]  2019年9月5日，突破奖基金会及其赞助人——马化腾等人共同宣布2020年突破奖及新视野奖的获得者。 [8]  2019福布斯中国慈善榜排名第4位。 [9]  2019年10月19日，入选2019福布斯年度商业人物之跨国经营商业领袖名单。 [10]  2019年11月7日，以2,545.50亿元财富值位列2019福布斯中国400富豪榜第2名。', '腾讯公司主要创办人之一。现任腾讯公司董事会主席兼首席执行官；全国青联副主席；全国人大代表。', 2, 'http://pic.netbian.com/uploads/allimg/200609/205932-1591707572cfe1.jpg', 28, 0, '2020-05-22 16:32:11', '2020-05-22 16:32:11');
INSERT INTO `edu_teacher` VALUES ('1263750043925413890', '马云', '2017年12月15日，荣获“影响中国”2017年度教育人物 [8]  。2018年9月10日，马云发出公开信宣布将于2019年9月10日卸任集团董事局主席，由CEO张勇接任。 2018年12月18日，党中央、国务院授予马云同志改革先锋称号，颁授改革先锋奖章。 [9]  2019年3月，马云以373亿美元财富排名2019年福布斯全球亿万富豪榜第21位。 [10]  2019年5月10日，马云等17位全球杰出人士被联合国秘书长古特雷斯任命为新一届可持续发展目标倡导者。 [11]  2019福布斯中国慈善榜排名第3位 [12]  。2019年10月获得福布斯终身成就奖 [13]  。2019年10月19日，入选2019福布斯年度商业人物之跨国经营商业领袖名单', '988年毕业于杭州师范学院外语系，同年担任杭州电子工业学院英文及国际贸易教师，1995年创办中国第一家互联网商业信息发布网站“中国黄页”，1998年出任中国国际电子商务中心国富通信息技术发展有限公司总经理，1999年创办阿里巴巴，并担任阿里集团CEO、董事局主席', 2, 'http://pic.netbian.com/uploads/allimg/200528/120844-1590638924b04f.jpg', 20, 0, '2020-05-22 16:34:24', '2020-05-22 16:34:24');
INSERT INTO `edu_teacher` VALUES ('1263751774478520322', '李彦宏', '1991年，李彦宏毕业于北京大学信息管理专业，随后前往美国布法罗纽约州立大学完成计算机科学硕士学位，先后担任道·琼斯公司高级顾问，《华尔街日报》网络版实时金融信息系统设计者，Infoseek公司资深工程师。2000年1月，李彦宏创建百度。并持有“超链分析”技术专利。2013年，当选第十二届全国政协委员，兼任中国民间商会副会长，第十一届中华全国工商业联合会副主席、第八届北京市科协副主席等职务', '2018年1月19日，李彦宏成为了《时代》当期亚洲版的封面人物。2018年12月18日，党中央、国务院授予李彦宏改革先锋称号，颁授改革先锋奖章', 2, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 35, 0, '2020-05-22 16:41:17', '2020-05-22 16:41:17');
INSERT INTO `edu_teacher` VALUES ('1263752158320250881', '李子柒', '2015年，李子柒开始拍摄短视频 [4]  ；11月，发布短视频《兰州牛肉面》 [5]  。2017年，正式组建团队；6月16日，获得新浪微博超级红人节十大美食红人奖 [6]  。2018年，她的原创短视频在海外运营3个月后获得YouTube银牌奖 [7]  。2019年8月，获得超级红人节最具人气博主奖 [8]  、年度最具商业价值红人奖 [9]  ；12月14日，获得中国新闻周刊“年度文化传播人物奖” [3]  。2020年1月1日，入选中国妇女报“2019十大女性人物” [10]  。2020年5月19日中华人民共和国农业农村部官网发布消息， [11]  李子柒受聘担任首批中国农民丰收节推广大使。', '中国内地美食短视频创作者', 1, 'http://pic.netbian.com/uploads/allimg/200605/220419-1591365859d23b.jpg', 10, 0, '2020-05-22 16:42:49', '2020-05-22 16:42:49');
INSERT INTO `edu_teacher` VALUES ('1263752386188398593', '刘亦菲', '2002年主演个人首部电视剧《金粉世家》，从而踏入演艺圈。2003年因主演武侠剧《天龙八部》崭露头角。2004年凭借仙侠剧《仙剑奇侠传》赵灵儿一角获得了高人气与关注度。2005年因在武侠剧《神雕侠侣》中饰演小龙女受到广泛关注。2006年发行首张国语专辑《刘亦菲》和日文专辑《All My W ... >>>', '刘亦菲，1987年8月25日出生于湖北省武汉市，华语影视女演员、歌手，毕业于北京电影学院2002级表演系本科', 2, 'http://pic.netbian.com/uploads/allimg/190824/205524-15666513248366.jpg', 13, 0, '2020-05-22 16:43:43', '2020-05-25 14:55:18');
INSERT INTO `edu_teacher` VALUES ('1263752560142962689', '刘诗诗 ', '2002年，考入北京舞蹈学院芭蕾舞专业本科班学习。2004年，因在爱情剧《月影风荷》中饰演女主角叶风荷而踏入演艺圈。2010年，凭借仙侠剧《仙剑奇侠传三》受到更多关注。2011年，因在宫廷剧《步步惊心》中饰演马尔泰·若曦而赢得颇高人气，并获得第十八届上海电视节白玉兰奖最具人气女演员奖。2012年，凭借仙侠剧《轩辕 ... >>>', '刘诗诗，原名刘诗施，1987年3月10日出生于北京市，中国内地影视女演员、影视出品人。', 2, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 99, 0, '2020-05-22 16:44:24', '2020-05-25 14:55:10');
INSERT INTO `edu_teacher` VALUES ('1263752888959619073', '刘德华', '演艺事业外，刘德华关心公益慈善。1994年创立刘德华慈善基金会 [19]  。2000年被评为世界十大杰出青年 [20]  。2005年发起亚洲新星导计划 [21]  。2008年被委任为香港非官守太平绅士 [22]  。2010年获得第12届世界杰出华人奖 [23]  。2016年连任中国残疾人福利基金会副理事长 [20]  ', '1961年9月27日出生于中国香港，籍贯广东新会 [1]  ，中国香港男演员、歌手、作词人、制片人', 1, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 133, 0, '2020-05-22 16:45:43', '2020-05-25 14:55:01');
INSERT INTO `edu_teacher` VALUES ('1264090456863502337', '西施', '西施与王昭君、貂蝉、杨玉环并称为“中国古代四大美女”，其中，西施居首。四大美女享有“沉鱼落雁之容，闭月羞花之貌”之美誉。其中的“沉鱼”一词，讲述的就是“西施浣纱”的故事', '西施，子姓施氏（7月19日出生，具体生卒年不详，一说卒于公元前473年），本名施夷光，春秋时期越国美女，一般称为西施，后人尊称其“西子“，春秋末期出生于越国句无苎萝村（今浙江省绍兴市诸暨苎萝村），自幼随母浣纱江边，故又称“浣纱女”。她天生丽质、倾国倾城，是美的化身和代名词。', 2, 'http://pic.netbian.com/uploads/allimg/200420/004348-1587314628e15e.jpg', 6666, 0, '2020-05-23 15:07:05', '2020-05-25 14:54:52');

-- ----------------------------
-- Table structure for edu_video
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '章节ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `play_count` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '播放次数',
  `is_free` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否可以试听：0收费 1免费',
  `duration` float NULL DEFAULT 0 COMMENT '视频时长（秒）',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '视频源文件大小（字节）',
  `version` bigint(20) UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE,
  INDEX `idx_chapter_id`(`chapter_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程视频' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1275261863886557186', '18', '1275261863853002754', 'Java成神之路4', 'a80cabfc1f8a41b1868c6eb90be885e0', NULL, 11, 0, 1, 0, 'Empty', 2211663, 1, '2020-06-23 10:58:16', '2020-06-23 10:58:16');
INSERT INTO `edu_video` VALUES ('1275268907922337794', '18', '1275261863853002754', 'Java成神之路6', '\r\na80cabfc1f8a41b1868c6eb90be885e1', '6 - What If I Want to Move Faster.mp4', 13, 0, 0, 0, 'Empty', 2211663, 1, '2020-06-23 11:26:16', '2020-06-23 11:26:16');
INSERT INTO `edu_video` VALUES ('1275273424281681922', '18', '1275261863853002754', '笑笑', '\r\na80cabfc1f8a41b1868c6eb90be885e1', '6 - What If I Want to Move Faster.mp4', 19, 0, 1, 0, 'Empty', 2211663, 1, '2020-06-23 11:44:12', '2020-06-23 11:44:12');
INSERT INTO `edu_video` VALUES ('1275615790515556354', '18', '1275615790226149378', 'java入坑之路', '707335ebffd2454baee1ee2f0fe8cf01', '6 - What If I Want to Move Faster.mp4', 14, 0, 1, 0, 'Empty', 2211663, 1, '2020-06-24 10:24:39', '2020-06-24 10:24:39');
INSERT INTO `edu_video` VALUES ('1275616501785628674', '18', '1275616501743685633', 'SpringBoot', 'bbab5aab33784fbb82211f86736c2709', '6 - What If I Want to Move Faster.mp4', 20, 0, 0, 0, 'Empty', 2211663, 1, '2020-06-24 10:27:28', '2020-06-24 10:27:28');

SET FOREIGN_KEY_CHECKS = 1;
