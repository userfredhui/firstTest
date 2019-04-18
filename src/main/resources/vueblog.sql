/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50725
Source Host           : 47.97.175.132:3306
Source Database       : vueblog

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-18 18:25:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `mdContent` text COMMENT 'md文件源码',
  `htmlContent` text COMMENT 'html源码',
  `summary` text,
  `cid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `publishDate` datetime DEFAULT NULL,
  `editTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '0表示草稿箱，1表示已发表，2表示已删除',
  `pageView` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '测试', 'a', '<p>a</p>\n', 'a\n', '7', '1', '2019-04-16 18:30:40', '2019-04-16 18:30:40', '1', '15');
INSERT INTO `article` VALUES ('2', '测试第一个文章', '#### 修改文章测试\n![loginbg.jpg](http://localhost:8082/blogimg/20190416/18be3591-1797-4301-ba04-cec435557b14_login-bg.jpg)\n*希望能修改成功*', '<h4><a id=\"_0\"></a>修改文章测试</h4>\n<p><img src=\"http://localhost:8082/blogimg/20190416/18be3591-1797-4301-ba04-cec435557b14_login-bg.jpg\" alt=\"loginbg.jpg\" /><br />\n<em>希望能修改成功</em></p>\n', '修改文章测试\n\n希望能修改成功\n', '7', '1', '2019-04-16 15:23:50', '2019-04-16 15:23:50', '1', '30');
INSERT INTO `article` VALUES ('3', '第二篇文章2', '## 二级标题\n测试二级标题的\n*iiii*\n![userImg.jpg](http://localhost:8082/blogimg/20190415/bce319f4-ffa2-43fb-a2e4-9dbca189abfb_userImg.jpg)\n> 段落引用\n非常不错的呦', '<h2><a id=\"_0\"></a>二级标题</h2>\n<p>测试二级标题的<br />\n<em>iiii</em><br />\n<img src=\"http://localhost:8082/blogimg/20190415/bce319f4-ffa2-43fb-a2e4-9dbca189abfb_userImg.jpg\" alt=\"userImg.jpg\" /></p>\n<blockquote>\n<p>段落引用<br />\n非常不错的呦</p>\n</blockquote>\n', '二级标题\n测试二级标题的\niiii\n\n\n段落引用\n非常不错的呦\n\n', '8', '1', '2019-04-16 16:12:17', '2019-04-16 16:12:17', '1', '11');
INSERT INTO `article` VALUES ('4', '二狗子测试文章1', '#### 二狗子主题文章title\n~~很开心的呀，开心啦~~\n![userImg.jpg](http://localhost:8082/blogimg/20190416/b0f10e6a-7de9-4440-9f84-a54bd4caaa62_userImg.jpg)', '<h4><a id=\"title_0\"></a>二狗子主题文章title</h4>\n<p><s>很开心的呀，开心啦</s><br />\n<img src=\"http://localhost:8082/blogimg/20190416/b0f10e6a-7de9-4440-9f84-a54bd4caaa62_userImg.jpg\" alt=\"userImg.jpg\" /></p>\n', '二狗子主题文章title\n很开心的呀，开心啦\n\n', '10', '22', '2019-04-17 10:40:32', '2019-04-17 10:40:32', '1', '20');
INSERT INTO `article` VALUES ('5', '栏目4的标题（修改）', '==栏目4开始了==\n*请开始你的表演*![微信头像](http://api.penghui.work/assets/user-img.jpg)\n**嗨皮的很**\n', '<p><mark>栏目4开始了</mark><br />\n<em>请开始你的表演</em><img src=\"http://api.penghui.work/assets/user-img.jpg\" alt=\"微信头像\" /><br />\n<strong>嗨皮的很</strong></p>\n', '栏目4开始了\n请开始你的表演\n嗨皮的很\n', '10', '1', '2019-04-16 15:42:25', '2019-04-16 15:42:25', '1', '7');
INSERT INTO `article` VALUES ('6', '测试草稿箱的文章', '2222', '<p>2222</p>\n', '2222\n', '13', '1', '2019-04-16 18:44:30', '2019-04-16 18:44:30', '1', '32');
INSERT INTO `article` VALUES ('7', 'test1新建的文章', '啦啦啦啦唱歌啦![loginbg.jpg](http://localhost:8082/blogimg/20190417/d9dab037-a47d-4012-837a-ae276c88a266_login-bg.jpg)', '<p>啦啦啦啦唱歌啦<img src=\"http://localhost:8082/blogimg/20190417/d9dab037-a47d-4012-837a-ae276c88a266_login-bg.jpg\" alt=\"loginbg.jpg\" /></p>\n', '啦啦啦啦唱歌啦\n', '11', '21', '2019-04-17 10:38:04', '2019-04-17 10:38:04', '1', '4');
INSERT INTO `article` VALUES ('8', 'test2测试新建文章', '### 三级标题\n啦啦啦啦很嗨皮![userImg.jpg](http://localhost:8082/blogimg/20190417/a3a6c6dc-87ed-476f-b69a-c24f15bcdd09_userImg.jpg)', '<h3><a id=\"_0\"></a>三级标题</h3>\n<p>啦啦啦啦很嗨皮<img src=\"http://localhost:8082/blogimg/20190417/a3a6c6dc-87ed-476f-b69a-c24f15bcdd09_userImg.jpg\" alt=\"userImg.jpg\" /></p>\n', '三级标题\n啦啦啦啦很嗨皮\n', '9', '22', '2019-04-17 10:39:01', '2019-04-17 10:39:01', '1', '5');
INSERT INTO `article` VALUES ('9', 'test创建文章', '### test3已经成为超级管理员\n~祝贺了呀！~> 段落引用222222222\n[百度](http://www.baidu.com)![userImg.jpg](http://localhost:8082/blogimg/20190418/de26e7bc-25a5-48e2-b105-779025a0ebd8_userImg.jpg)', '<h3><a id=\"test3_0\"></a>test3已经成为超级管理员</h3>\n<p><sub>祝贺了呀！</sub>', 'test3已经成为超级管理员\n祝贺了呀！', '12', '27', '2019-04-18 14:39:08', '2019-04-18 14:39:08', '1', '3');
INSERT INTO `article` VALUES ('10', 'test3建一篇发表的文章', '### 成功的发表文章\n::: hljs-left\n\n真是开心的很，上班很嗨皮\n\n:::\n::: hljs-right\n\n居右的文案测试，果然局右了，牛批\n\n:::\n![loginbg.jpg](http://localhost:8082/blogimg/20190418/d2fce937-2f8e-41b9-aa32-faf4f6542fa7_login-bg.jpg)\n\n美女照片', '<h3><a id=\"_0\"></a>成功的发表文章</h3>\n<div class=\"hljs-left\">\n<p>真是开心的很，上班很嗨皮</p>\n</div>\n<div class=\"hljs-right\">\n<p>居右的文案测试，果然局右了，牛批</p>\n</div>\n<p><img src=\"http://localhost:8082/blogimg/20190418/d2fce937-2f8e-41b9-aa32-faf4f6542fa7_login-bg.jpg\" alt=\"loginbg.jpg\" /></p>\n<p>美女照片</p>\n', '成功的发表文章\n\n真是开心的很，上班很嗨皮\n\n\n居右的文案测试，果然局右了，牛批\n\n\n美女照片\n', '11', '27', '2019-04-18 14:38:51', '2019-04-18 14:38:51', '1', '1');
INSERT INTO `article` VALUES ('11', '测试人员4的标题', '### 测试人员4的文章\n测试这挺开心的\n> 上传张图片试试\n![userImg.jpg](http://api.penghui.work:8082/blogimg/20190418/a9cedf69-7e72-4906-bcbd-b3f9dd5dc37c_userImg.jpg)\n', '<h3><a id=\"4_0\"></a>测试人员4的文章</h3>\n<p>测试这挺开心的</p>\n<blockquote>\n<p>上传张图片试试<br />\n<img src=\"http://api.penghui.work:8082/blogimg/20190418/a9cedf69-7e72-4906-bcbd-b3f9dd5dc37c_userImg.jpg\" alt=\"userImg.jpg\" /></p>\n</blockquote>\n', '测试人员4的文章\n测试这挺开心的\n\n上传张图片试试\n\n\n', '10', '28', '2019-04-18 16:29:08', '2019-04-18 16:29:08', '1', '3');
INSERT INTO `article` VALUES ('12', '测试人员4第二篇文章', '##### 测试人4的第二篇文章\n::: hljs-right\n\n右对齐的挺好玩的哈哈哈\n\n:::\n1. 第一条\n2. 第二条\n3. 第三条', '<h5><a id=\"4_0\"></a>测试人4的第二篇文章</h5>\n<div class=\"hljs-right\">\n<p>右对齐的挺好玩的哈哈哈</p>\n</div>\n<ol>\n<li>第一条</li>\n<li>第二条</li>\n<li>第三条</li>\n</ol>\n', '测试人4的第二篇文章\n\n右对齐的挺好玩的哈哈哈\n\n\n第一条\n第二条\n第三条\n\n', '9', '28', '2019-04-18 16:33:29', '2019-04-18 16:33:29', '1', '4');

-- ----------------------------
-- Table structure for article_tags
-- ----------------------------
DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`) USING BTREE,
  KEY `article_tags_ibfk_1` (`aid`) USING BTREE,
  CONSTRAINT `article_tags_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_tags_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tags` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_tags
-- ----------------------------
INSERT INTO `article_tags` VALUES ('10', '2', '3');
INSERT INTO `article_tags` VALUES ('11', '2', '6');
INSERT INTO `article_tags` VALUES ('12', '2', '8');
INSERT INTO `article_tags` VALUES ('13', '2', '11');
INSERT INTO `article_tags` VALUES ('15', '5', '15');
INSERT INTO `article_tags` VALUES ('16', '3', '4');
INSERT INTO `article_tags` VALUES ('17', '1', '1');
INSERT INTO `article_tags` VALUES ('19', '6', '19');
INSERT INTO `article_tags` VALUES ('20', '7', '20');
INSERT INTO `article_tags` VALUES ('21', '8', '21');
INSERT INTO `article_tags` VALUES ('22', '4', '5');
INSERT INTO `article_tags` VALUES ('24', '10', '23');
INSERT INTO `article_tags` VALUES ('25', '9', '22');
INSERT INTO `article_tags` VALUES ('26', '11', '26');
INSERT INTO `article_tags` VALUES ('27', '11', '25');
INSERT INTO `article_tags` VALUES ('28', '12', '27');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cateName` varchar(64) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('7', 'react', '2019-04-12');
INSERT INTO `category` VALUES ('8', 'vue', '2019-04-12');
INSERT INTO `category` VALUES ('9', 'angluar', '2019-04-12');
INSERT INTO `category` VALUES ('10', 'node.js', '2019-04-12');
INSERT INTO `category` VALUES ('11', 'java', '2019-04-12');
INSERT INTO `category` VALUES ('12', 'phython', '2019-04-12');
INSERT INTO `category` VALUES ('13', 'php', '2019-04-12');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '超级管理员');
INSERT INTO `roles` VALUES ('2', '普通用户');
INSERT INTO `roles` VALUES ('3', '测试角色1');
INSERT INTO `roles` VALUES ('4', '测试角色2');
INSERT INTO `roles` VALUES ('5', '测试角色3');

-- ----------------------------
-- Table structure for roles_user
-- ----------------------------
DROP TABLE IF EXISTS `roles_user`;
CREATE TABLE `roles_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT '2',
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`) USING BTREE,
  KEY `roles_user_ibfk_2` (`uid`) USING BTREE,
  CONSTRAINT `roles_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`),
  CONSTRAINT `roles_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_user
-- ----------------------------
INSERT INTO `roles_user` VALUES ('1', '1', '1');
INSERT INTO `roles_user` VALUES ('131', '2', '21');
INSERT INTO `roles_user` VALUES ('132', '2', '22');
INSERT INTO `roles_user` VALUES ('140', '2', '28');
INSERT INTO `roles_user` VALUES ('141', '2', '27');
INSERT INTO `roles_user` VALUES ('142', '3', '27');
INSERT INTO `roles_user` VALUES ('143', '4', '27');
INSERT INTO `roles_user` VALUES ('144', '2', '29');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tagName` (`tagName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES ('20', 'test1');
INSERT INTO `tags` VALUES ('21', 'test2');
INSERT INTO `tags` VALUES ('22', 'test3Admin');
INSERT INTO `tags` VALUES ('5', '二狗子');
INSERT INTO `tags` VALUES ('23', '发布test3');
INSERT INTO `tags` VALUES ('26', '有图片');
INSERT INTO `tags` VALUES ('3', '标签1');
INSERT INTO `tags` VALUES ('6', '标签2');
INSERT INTO `tags` VALUES ('8', '标签3');
INSERT INTO `tags` VALUES ('11', '标签4');
INSERT INTO `tags` VALUES ('15', '栏目4tag');
INSERT INTO `tags` VALUES ('27', '没图');
INSERT INTO `tags` VALUES ('25', '测试4');
INSERT INTO `tags` VALUES ('1', '第一个标签');
INSERT INTO `tags` VALUES ('2', '第二个标签');
INSERT INTO `tags` VALUES ('4', '第二篇文章');
INSERT INTO `tags` VALUES ('19', '草稿箱tag');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `email` varchar(64) DEFAULT NULL,
  `userface` varchar(255) DEFAULT NULL,
  `regTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lph', '辉', '202cb962ac59075b964b07152d234b70', '1', '957997712@qq.com', 'http://api.penghui.work/assets/user-img.jpg', '2019-01-06 10:41:29');
INSERT INTO `user` VALUES ('21', 'test1', 'test1汉字', '202cb962ac59075b964b07152d234b70', '1', '957997124@qq.com', 'http://api.penghui.work/assets/user-img.jpg', '2019-04-08 10:41:35');
INSERT INTO `user` VALUES ('22', 'test2', '二狗子', '202cb962ac59075b964b07152d234b70', '1', '957997125@qq.com', 'http://api.penghui.work/assets/user-img.jpg', '2019-04-12 14:47:38');
INSERT INTO `user` VALUES ('27', 'test3', '带头像的test3', '202cb962ac59075b964b07152d234b70', '1', '957997512', 'http://localhost:8082/blogimg/20190418/72f4e92b-2060-4840-9ce2-3421dec109a1_login-bg.jpg', '2019-04-18 14:23:21');
INSERT INTO `user` VALUES ('28', 'test4', '测试人员4', '202cb962ac59075b964b07152d234b70', '1', '967007123@qq.com', 'http://localhost:8082/blogimg/20190418/a249fc5f-e49a-4cb5-bcd2-605f32242c96_login-bg.jpg', '2019-04-18 14:41:25');
INSERT INTO `user` VALUES ('29', 'test5', 'qa5', '202cb962ac59075b964b07152d234b70', '1', '746123456@qq.com', 'http://api.penghui.work:8082/blogimg/20190418/9a742461-007d-43f7-a566-2e52d139baa2_login-bg.jpg', '2019-04-18 16:48:57');
