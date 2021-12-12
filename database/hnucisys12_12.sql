/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3307
 Source Schema         : hnucisys

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 12/12/2021 14:55:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition`  (
  `cptid` int(11) NOT NULL AUTO_INCREMENT COMMENT '比赛id',
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '比赛名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '比赛图片地址',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '比赛类别',
  `time` datetime(0) NOT NULL COMMENT '比赛时间',
  `evaluation` int(11) NULL DEFAULT NULL COMMENT '比赛评价，1-5，5为等第最高',
  `createtime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`cptid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES (1, '2021年MathorCup高校数学建模挑战赛——大数据竞赛', 'https://publicqn.saikr.com/2021/11/10/contest618ba13c51ed93.884670951636540785645.png?imageView2/2/w/1080', '科技类', '2021-12-21 00:00:00', 3, '2021-12-05 00:00:00', '2021-12-05 00:00:00');
INSERT INTO `competition` VALUES (2, '2021《英语世界》杯全国大学生英语写作大赛——冬奥写作大赛', 'https://publicqn.saikr.com/2021/11/30/contest61a5f405b00627.663666351638265902402.png?imageView2/2/w/1080', '英语', '2021-12-31 00:00:00', 3, '2021-12-05 00:00:00', '2021-12-05 00:00:00');
INSERT INTO `competition` VALUES (3, '第十三届蓝桥杯全国软件和信息技术专业人才大赛', 'https://publicqn.saikr.com/2021/10/27/contest6178c498595982.910643191635304862590.jpeg?imageView2/2/w/1080', '科技类', '2022-03-01 00:00:00', 5, '2021-12-05 00:00:00', '2021-12-05 00:00:00');
INSERT INTO `competition` VALUES (4, '2021年第四届“传智杯”全国大学生IT技能大赛', 'https://publicqn.saikr.com/2021/11/02/contest6180ac5f4cb8b7.789260881635822773154.png?imageView2/2/w/1080', '科技类', '2021-11-20 00:00:00', 2, '2021-12-05 00:00:00', '2021-12-05 00:00:00');
INSERT INTO `competition` VALUES (5, '第三届中国工业文学作品“光耀杯”大赛', 'https://publicqn.saikr.com/2021/04/27/contest60878d3aa64ac4.387723331619496323410.png?imageView2/2/w/1080', '文化类', '2022-02-01 00:00:00', 3, '2021-12-05 00:00:00', '2021-12-05 00:00:00');

-- ----------------------------
-- Table structure for cpt_content
-- ----------------------------
DROP TABLE IF EXISTS `cpt_content`;
CREATE TABLE `cpt_content`  (
  `cptid` int(11) NOT NULL COMMENT '比赛id',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '比赛内容',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cptid`) USING BTREE,
  CONSTRAINT `FORE_CID` FOREIGN KEY (`cptid`) REFERENCES `competition` (`cptid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cpt_content
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `teamid` int(11) NOT NULL AUTO_INCREMENT COMMENT '队伍id',
  `team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '队伍名',
  `cptid` int(11) NOT NULL COMMENT '比赛id',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`teamid`) USING BTREE,
  INDEX `FORE_CPTID`(`cptid`) USING BTREE,
  CONSTRAINT `FORE_CPTID` FOREIGN KEY (`cptid`) REFERENCES `competition` (`cptid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------

-- ----------------------------
-- Table structure for team_user
-- ----------------------------
DROP TABLE IF EXISTS `team_user`;
CREATE TABLE `team_user`  (
  `tuid` int(11) NOT NULL COMMENT 'team_user_id',
  `teamid` int(11) NOT NULL COMMENT '队伍id',
  `userid` int(11) NOT NULL COMMENT '队员id',
  `role` int(11) NOT NULL COMMENT '0代表队长，1代表队员',
  `createtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`tuid`) USING BTREE,
  INDEX `FORE_USERID`(`userid`) USING BTREE,
  INDEX `FORE_TEAMID`(`teamid`) USING BTREE,
  CONSTRAINT `FORE_TEAMID` FOREIGN KEY (`teamid`) REFERENCES `team` (`teamid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FORE_USERID` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_user
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `grade` int(11) NOT NULL COMMENT '年级',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `sex` int(11) NOT NULL COMMENT '性别，1为男，0为女',
  `qq` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'QQ号',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人简介',
  `createtime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1012 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, 'sim', '123456', 4, '材料科学与工程', 1, '1517753785', '擅长深度学习、数据挖掘，有很好的组织能力，曾带领队伍赢得计算机设计大赛国一，互联网＋省级一等奖，挑战杯国三等奖项。', '2021-11-04 00:00:00', '2021-11-21 00:00:00');
INSERT INTO `user` VALUES (1002, 'xusong', '123455', 2, '应用数学', 1, '1578426579', '擅长数学方面，专业第二，熟练掌握建模知识，会matlab，lingo，spss等多种建模软件，曾获得全国大学生数学建模国家一等奖，有丰富的参赛经验', '2021-11-06 00:00:00', '2021-11-18 00:00:00');
INSERT INTO `user` VALUES (1003, 'yinhaoran', '123454', 1, '农学', 1, '1786878899', '擅长ppt制作，论文编写，以及演讲，曾获世界艾滋病日主题演讲比赛校级一等奖，获得“学党史、强信念、跟党走”征文比赛省级一等奖。', '2021-11-03 00:00:00', '2021-11-12 00:00:00');
INSERT INTO `user` VALUES (1004, 'xiejun', '123489', 2, '计算机科学与技术', 0, '1798428947', '擅长c语言、python、Java、c++等多种语言，擅长网站设计，熟练掌握js、vue、css等技能。', '2021-11-05 00:00:00', '2021-11-18 00:00:00');
INSERT INTO `user` VALUES (1005, 'xiaoyun', '214899', 1, '数学', 0, '1789712347', '目前没掌握技能，但踏实肯干、吃苦耐劳，可以认真去学。', '2021-11-05 00:00:00', '2021-11-27 00:00:00');
INSERT INTO `user` VALUES (1006, 'songyiyi', '317894', 2, '软工', 0, '1298721478', '擅长软件开发设计，动手能力强，曾开发过微信小程序，获得天梯赛个人赛省级一等奖，蓝桥杯省级一等奖。', '2021-11-05 00:00:00', '2021-11-24 00:00:00');
INSERT INTO `user` VALUES (1007, 'xuwei', '423897', 3, '计算机科学与技术', 0, '3472888984', '曾发表过4项论文，其中一项被sci收录，参与过3个项目，获得中国计算机大赛国家二等奖，互联网＋国家一等奖，挑战杯国家一等奖，以及10余个小奖项。', '2021-11-04 00:00:00', '2021-11-24 00:00:00');
INSERT INTO `user` VALUES (1008, 'moliu', '234245', 1, '软工', 1, '4328948192', '没有什么技能，想参加比赛涨涨经验。', '2021-11-03 00:00:00', '2021-11-20 00:00:00');
INSERT INTO `user` VALUES (1009, 'sdfa', '123456', 0, 'cs', 0, '34311', NULL, NULL, NULL);
INSERT INTO `user` VALUES (1010, 'jason', '123456', 0, 'music', 0, '1399838112', NULL, NULL, NULL);
INSERT INTO `user` VALUES (1011, 'sofia', '123456', 0, 'dance', 0, '123875345', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_message
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message`  (
  `messageid` int(5) NOT NULL COMMENT '信息id',
  `wuid` int(255) NOT NULL COMMENT '发送者id',
  `guid` int(255) NOT NULL COMMENT '接收者id',
  `messagetext` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送内容',
  `replymessage` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  `createtime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`messageid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_message
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
