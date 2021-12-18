/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.29 : Database - hnucisys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hnucisys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hnucisys`;

/*Table structure for table `competition` */

DROP TABLE IF EXISTS `competition`;

CREATE TABLE `competition` (
  `cptid` int(11) NOT NULL AUTO_INCREMENT COMMENT '比赛id',
  `name` varchar(60) NOT NULL COMMENT '比赛名称',
  `url` varchar(255) NOT NULL COMMENT '比赛图片地址',
  `category` varchar(20) NOT NULL COMMENT '比赛类别',
  `time` datetime NOT NULL COMMENT '比赛时间',
  `evaluation` int(11) DEFAULT NULL COMMENT '比赛评价，1-5，5为等第最高',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`cptid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `competition` */

insert  into `competition`(`cptid`,`name`,`url`,`category`,`time`,`evaluation`,`createtime`,`updatetime`) values (1,'2021年MathorCup高校数学建模挑战赛——大数据竞赛','https://publicqn.saikr.com/2021/11/10/contest618ba13c51ed93.884670951636540785645.png?imageView2/2/w/1080','科技类','2021-12-21 00:00:00',3,'2021-12-05 00:00:00','2021-12-05 00:00:00'),(2,'2021《英语世界》杯全国大学生英语写作大赛——冬奥写作大赛','https://publicqn.saikr.com/2021/11/30/contest61a5f405b00627.663666351638265902402.png?imageView2/2/w/1080','英语','2021-12-31 00:00:00',3,'2021-12-05 00:00:00','2021-12-05 00:00:00'),(3,'第十三届蓝桥杯全国软件和信息技术专业人才大赛','https://publicqn.saikr.com/2021/10/27/contest6178c498595982.910643191635304862590.jpeg?imageView2/2/w/1080','科技类','2022-03-01 00:00:00',5,'2021-12-05 00:00:00','2021-12-05 00:00:00'),(4,'2021年第四届“传智杯”全国大学生IT技能大赛','https://publicqn.saikr.com/2021/11/02/contest6180ac5f4cb8b7.789260881635822773154.png?imageView2/2/w/1080','科技类','2021-11-20 00:00:00',2,'2021-12-05 00:00:00','2021-12-05 00:00:00'),(5,'第三届中国工业文学作品“光耀杯”大赛','https://publicqn.saikr.com/2021/04/27/contest60878d3aa64ac4.387723331619496323410.png?imageView2/2/w/1080','文化类','2022-02-01 00:00:00',3,'2021-12-05 00:00:00','2021-12-05 00:00:00');

/*Table structure for table `cpt_content` */

DROP TABLE IF EXISTS `cpt_content`;

CREATE TABLE `cpt_content` (
  `cptid` int(11) NOT NULL COMMENT '比赛id',
  `content` mediumtext NOT NULL COMMENT '比赛内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cptid`) USING BTREE,
  CONSTRAINT `FORE_CID` FOREIGN KEY (`cptid`) REFERENCES `competition` (`cptid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `cpt_content` */

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `teamid` int(11) NOT NULL AUTO_INCREMENT COMMENT '队伍id',
  `teamname` varchar(255) NOT NULL COMMENT '队伍名',
  `cptid` int(11) NOT NULL COMMENT '比赛id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`teamid`) USING BTREE,
  KEY `FORE_CPTID` (`cptid`) USING BTREE,
  CONSTRAINT `FORE_CPTID` FOREIGN KEY (`cptid`) REFERENCES `competition` (`cptid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1116 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `team` */

insert  into `team`(`teamid`,`teamname`,`cptid`,`createtime`,`updatetime`) values (1111,'Syn',3,'2021-12-09 19:45:32','2021-12-13 19:45:36'),(1112,'coi',1,'2021-12-11 19:47:12','2021-12-13 19:47:17'),(1113,'星耀',2,'2021-12-03 19:47:51','2021-12-13 19:47:55'),(1114,'dawn',5,'2021-12-02 19:48:32','2021-12-13 19:48:36'),(1115,'L.S.Y',4,'2021-12-04 19:49:14','2021-12-13 19:49:18');

/*Table structure for table `team_user` */

DROP TABLE IF EXISTS `team_user`;

CREATE TABLE `team_user` (
  `tuid` int(11) NOT NULL COMMENT 'team_user_id',
  `teamid` int(11) NOT NULL COMMENT '队伍id',
  `userid` int(11) NOT NULL COMMENT '队员id',
  `role` int(11) NOT NULL COMMENT '0代表队长，1代表队员',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`tuid`) USING BTREE,
  KEY `FORE_USERID` (`userid`) USING BTREE,
  KEY `FORE_TEAMID` (`teamid`) USING BTREE,
  CONSTRAINT `FORE_TEAMID` FOREIGN KEY (`teamid`) REFERENCES `team` (`teamid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FORE_USERID` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `team_user` */

insert  into `team_user`(`tuid`,`teamid`,`userid`,`role`,`createtime`,`updatetime`) values (1,1111,1001,0,'2021-12-03 20:38:32','2021-12-14 20:38:36'),(2,1112,1003,0,'2021-12-02 20:38:56','2021-12-14 20:38:59'),(3,1113,1002,0,'2021-12-14 20:39:16','2021-12-14 20:39:19'),(4,1114,1006,0,'2021-12-02 20:39:40','2021-12-13 20:39:43'),(5,1115,1004,0,'2021-12-02 20:40:08','2021-12-14 20:40:11'),(6,1111,1005,1,'2021-12-09 21:16:56','2021-12-15 21:16:59');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL COMMENT '姓名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `perms` varchar(255) NOT NULL COMMENT '用户类型，user or admin',
  `grade` int(11) NOT NULL COMMENT '年级',
  `major` varchar(255) NOT NULL COMMENT '专业',
  `sex` int(11) NOT NULL COMMENT '性别，1为男，0为女',
  `qq` varchar(12) NOT NULL COMMENT 'QQ号',
  `introduction` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`password`,`perms`,`grade`,`major`,`sex`,`qq`,`introduction`,`createtime`,`updatetime`) values (1001,'sim','123456','user',4,'材料科学与工程',1,'1517753785','擅长深度学习、数据挖掘，有很好的组织能力，曾带领队伍赢得计算机设计大赛国一，互联网＋省级一等奖，挑战杯国三等奖项。','2021-12-12 17:58:13','2021-12-12 17:58:13'),(1002,'xusong','123455','user',2,'应用数学',1,'1578426579','擅长数学方面，专业第二，熟练掌握建模知识，会matlab，lingo，spss等多种建模软件，曾获得全国大学生数学建模国家一等奖，有丰富的参赛经验','2021-12-12 17:58:16','2021-12-12 17:58:16'),(1003,'yinhaoran','123454','user',1,'农学',1,'1786878899','擅长ppt制作，论文编写，以及演讲，曾获世界艾滋病日主题演讲比赛校级一等奖，获得“学党史、强信念、跟党走”征文比赛省级一等奖。','2021-12-12 17:58:17','2021-12-12 17:58:17'),(1004,'xiejun','123489','user',2,'计算机科学与技术',0,'1798428947','擅长c语言、python、Java、c++等多种语言，擅长网站设计，熟练掌握js、vue、css等技能。','2021-12-12 17:58:18','2021-12-12 17:58:18'),(1005,'xiaoyun','214899','user',1,'数学',0,'1789712347','目前没掌握技能，但踏实肯干、吃苦耐劳，可以认真去学。','2021-12-12 17:58:19','2021-12-12 17:58:19'),(1006,'songyiyi','317894','user',2,'软工',0,'1298721478','擅长软件开发设计，动手能力强，曾开发过微信小程序，获得天梯赛个人赛省级一等奖，蓝桥杯省级一等奖。','2021-12-12 17:58:19','2021-12-12 17:58:19'),(1007,'xuwei','423897','user',3,'计算机科学与技术',0,'3472888984','曾发表过4项论文，其中一项被sci收录，参与过3个项目，获得中国计算机大赛国家二等奖，互联网＋国家一等奖，挑战杯国家一等奖，以及10余个小奖项。','2021-12-12 17:58:20','2021-12-12 17:58:20'),(1008,'moliu','234245','user',1,'软工',1,'4328948192','没有什么技能，想参加比赛涨涨经验。','2021-12-12 17:58:20','2021-12-12 17:58:20'),(1009,'sdfa','123456','admin',0,'cs',0,'34311','hello','2021-12-12 17:58:40','2021-12-12 17:58:40'),(1010,'jason','123456','user',0,'music',0,'1399838112','hello','2021-12-12 17:58:43','2021-12-12 17:58:43'),(1011,'sofia','123456','user',0,'dance',0,'123875345','hello','2021-12-12 17:58:45','2021-12-12 17:58:45');

/*Table structure for table `user_message` */

DROP TABLE IF EXISTS `user_message`;

CREATE TABLE `user_message` (
  `messageid` int(5) NOT NULL COMMENT '信息id',
  `wuid` int(255) NOT NULL COMMENT '发送者id',
  `guid` int(255) NOT NULL COMMENT '接收者id',
  `messagetext` text NOT NULL COMMENT '发送内容',
  `replymessage` text COMMENT '回复内容',
  `createtime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`messageid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_message` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
