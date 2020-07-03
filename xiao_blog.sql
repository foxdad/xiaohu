/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : xiao_blog

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 03/07/2020 09:50:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章id',
  `group_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属文章分类',
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属文章标题',
  `article_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `article_context` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章描述',
  `article_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章路径',
  `sort` int(11) NULL DEFAULT NULL COMMENT '文章排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1277432695752740865', '1', 'Spring Boot', '集群化部署，Spring Security 要如何处理 session 共享？', '今天我们就来看看集群化部署，Spring Security 要如何处理 session 并发。', 'http://www.javaboy.org/2020/0518/springsecurity-spring-session.html', NULL, '2020-06-29 10:44:23', '2020-06-29 10:44:23');
INSERT INTO `article` VALUES ('1277436411759251458', '1277436356688039937', '数据库', '事务跟索引', '事务跟索引', 'https://blog.csdn.net/qq_33369905/article/details/105911814', NULL, '2020-06-29 10:59:09', '2020-06-29 10:59:09');
INSERT INTO `article` VALUES ('1277440391927255041', '1277436356688039937', '数据库', '【数据库调优】屡试不爽的面试连环combo', '【数据库调优】屡试不爽的面试连环combo', 'https://blog.csdn.net/qq_35190492/article/details/106682127', NULL, '2020-06-29 11:14:58', '2020-06-29 11:14:58');
INSERT INTO `article` VALUES ('1277446541796167681', '1', 'Spring Boot', '集群化部署，Spring Security 要如何处理 session 共享？', '今天我们就来看看集群化部署，Spring Security 要如何处理 session 并发。', 'http://www.javaboy.org/2020/0518/springsecurity-spring-session.html', NULL, '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `article` VALUES ('1277446569717649409', '1277436356688039937', '数据库', '事务跟索引', '事务跟索引', 'https://blog.csdn.net/qq_33369905/article/details/105911814', NULL, '2020-06-29 11:39:31', '2020-06-29 11:39:31');
INSERT INTO `article` VALUES ('1277446606593970177', '1277436356688039937', '数据库', '【数据库调优】屡试不爽的面试连环combo', '【数据库调优】屡试不爽的面试连环combo', 'https://blog.csdn.net/qq_35190492/article/details/106682127', NULL, '2020-06-29 11:39:39', '2020-06-29 11:39:39');
INSERT INTO `article` VALUES ('18', '12', 'Spring Security', '要学就学透!SpringBoot', '松哥和大家聊了什么是 CSRF 攻击，以及 CSRF 攻击要如何防御。主要和大家聊了 Spring Security 中处理该问题的几种办法', 'http://www.javaboy.org/2020/0520/springsecurity-csrf-sourcecode.html', 1, '2020-06-25 18:09:58', '2020-06-25 18:10:03');
INSERT INTO `article` VALUES ('19', '1', 'Spring Boot', 'SpringBoot 单点登录的第三种方案', '松哥周末抽空给 Spring Security 系列也录制了一套视频，目录如下：\r\n\r\n', 'http://www.javaboy.org/2020/0604/springsecurity-cas.html', 2, '2020-06-26 16:11:54', '2020-06-26 16:11:59');
INSERT INTO `article` VALUES ('20', '1277400234352156673', '\r\nSPRING CLOUD\r\n', '来一个简单的，微服务项目中如何管理依赖版本号？', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0602/springcloud-maven-version.html', 3, '2020-06-26 16:16:49', '2020-06-26 16:16:54');
INSERT INTO `article` VALUES ('21', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('22', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('23', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('24', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('25', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('26', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('27', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('28', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('29', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');
INSERT INTO `article` VALUES ('30', '12', 'Spring Security', 'Spring Security 两种资源放行策略，千万别用错了！', '松哥原创的四套视频教程已经全部杀青，感兴趣的小伙伴戳这里', 'http://www.javaboy.org/2020/0528/springsecurity-ignoring.html', 4, '2020-06-28 09:02:11', '2020-06-28 09:02:15');

-- ----------------------------
-- Table structure for blogger
-- ----------------------------
DROP TABLE IF EXISTS `blogger`;
CREATE TABLE `blogger`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主id',
  `blogger_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主',
  `avater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg' COMMENT '博主头像',
  `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '访问数量',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主跳转链接',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blogger
-- ----------------------------
INSERT INTO `blogger` VALUES ('1238446549915800473', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1238446549915800923', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1238446549915800953', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1238446549915800973', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1277446540917800493', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1277446541917800493', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1277446541917802493', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1277446541917802498', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1277446569767981058', '狂神说', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'https://blog.csdn.net/qq_33369905/article/details/105911814', '2020-06-29 11:39:31', '2020-06-29 11:39:31');
INSERT INTO `blogger` VALUES ('1277446606635913218', '傲丙', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'https://blog.csdn.net/qq_35190492', '2020-06-29 11:39:39', '2020-06-29 11:39:39');
INSERT INTO `blogger` VALUES ('1278446540917800473', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1278446540917800493', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1278446549915800473', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('1278446549917800473', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446543912832223', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446543912836223', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446543912836273', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446549912800923', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446549912802923', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446549912832223', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446549912832923', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');
INSERT INTO `blogger` VALUES ('2238446549915800923', '江南一点雨', 'http://pic.netbian.com/uploads/allimg/180514/102951-152626499141b2.jpg', 0, 'http://www.javaboy.org/', '2020-06-29 11:39:24', '2020-06-29 11:39:24');

-- ----------------------------
-- Table structure for group_blogger
-- ----------------------------
DROP TABLE IF EXISTS `group_blogger`;
CREATE TABLE `group_blogger`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类id',
  `group_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类标题',
  `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '访问排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_blogger
-- ----------------------------
INSERT INTO `group_blogger` VALUES ('1', 'Spring Boot', 1, '2020-06-28 12:54:54', '2020-06-28 12:54:58');
INSERT INTO `group_blogger` VALUES ('12', 'Spring Security', 0, '2020-06-30 13:33:24', '2020-06-30 13:33:28');
INSERT INTO `group_blogger` VALUES ('1277399629030203393', 'Dubbo', 0, '2020-06-29 08:32:59', '2020-06-29 08:32:59');
INSERT INTO `group_blogger` VALUES ('1277400234352156673', 'Spring Cloud', 0, '2020-06-29 08:35:23', '2020-06-29 08:35:23');
INSERT INTO `group_blogger` VALUES ('1277400543568830465', 'Vue', 0, '2020-06-29 08:36:37', '2020-06-29 08:36:37');
INSERT INTO `group_blogger` VALUES ('1277436356688039937', '数据库', 0, '2020-06-29 10:58:56', '2020-06-29 10:58:56');

-- ----------------------------
-- Table structure for recommend_blog
-- ----------------------------
DROP TABLE IF EXISTS `recommend_blog`;
CREATE TABLE `recommend_blog`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '推荐标识id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '推荐博主的花名',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '推荐博客的标题',
  `linked` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐博主的友链',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '推荐文章的友链',
  `content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐文章的描述',
  `status` tinyint(255) NOT NULL DEFAULT 0 COMMENT '审核状态（0,待审核，1审核通过，2，审核未通过）',
  `group_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类id',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `extend` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客扩展分类',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recommend_blog
-- ----------------------------
INSERT INTO `recommend_blog` VALUES ('1277072050226155521', '江南一点雨', '集群化部署，Spring Security 要如何处理 session 共享？', 'http://www.javaboy.org/', 'http://www.javaboy.org/2020/0518/springsecurity-spring-session.html', '今天我们就来看看集群化部署，Spring Security 要如何处理 session 并发。', 1, '1', NULL, NULL, '2020-06-28 15:13:14', '2020-06-29 11:39:23');
INSERT INTO `recommend_blog` VALUES ('1277436220461240322', '狂神说', '事务跟索引', 'https://blog.csdn.net/qq_33369905/article/details/105911814', 'https://blog.csdn.net/qq_33369905/article/details/105911814', '事务跟索引', 1, NULL, NULL, NULL, '2020-06-29 10:58:23', '2020-06-29 11:39:31');
INSERT INTO `recommend_blog` VALUES ('1277440205796626434', '傲丙', '【数据库调优】屡试不爽的面试连环combo', 'https://blog.csdn.net/qq_35190492', 'https://blog.csdn.net/qq_35190492/article/details/106682127', '【数据库调优】屡试不爽的面试连环combo', 1, NULL, NULL, NULL, '2020-06-29 11:14:13', '2020-06-29 11:39:39');

SET FOREIGN_KEY_CHECKS = 1;
