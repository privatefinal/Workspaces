# Host: localhost  (Version 5.5.21)
# Date: 2017-06-27 10:23:41
# Generator: MySQL-Front 5.4  (Build 3.3)
# Internet: http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "jeecg_note"
#

DROP TABLE IF EXISTS `jeecg_note`;
CREATE TABLE `jeecg_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '详细描述',
  `crtuser` varchar(255) DEFAULT NULL,
  `crtuser_name` varchar(255) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL COMMENT '建创时间',
  `deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "jeecg_note"
#

INSERT INTO `jeecg_note` VALUES (1,'12','12','','','2013-02-06 13:31:56',NULL);

#
# Structure for table "jeecg_person"
#

DROP TABLE IF EXISTS `jeecg_person`;
CREATE TABLE `jeecg_person` (
  `id` varchar(36) NOT NULL,
  `age` int(11) NOT NULL COMMENT '年龄',
  `name` varchar(255) NOT NULL COMMENT '名字',
  `salary` decimal(19,2) DEFAULT NULL COMMENT '工资',
  `createdt` datetime DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "jeecg_person"
#

INSERT INTO `jeecg_person` VALUES ('93c78b3e-d297-4a62-abd7-2acf6665df3d',20,'张三',1000.00,'2013-02-13 14:50:01'),('e4dbf837-550e-4fbd-9766-15ed4079da4c',23,'李四',100.00,'2013-02-20 13:33:02');

#
# Structure for table "mailbox"
#

DROP TABLE IF EXISTS `mailbox`;
CREATE TABLE `mailbox` (
  `Id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键Id',
  `mailAccount` varchar(100) DEFAULT NULL COMMENT '邮箱账号',
  `mailPassword` varchar(100) DEFAULT NULL COMMENT '邮箱登录密码',
  `mailLicense` varchar(100) DEFAULT NULL COMMENT '邮箱授权码',
  `addUser` varchar(100) DEFAULT NULL COMMENT '添加人',
  `addDate` datetime DEFAULT NULL COMMENT '添加时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateUser` varchar(100) DEFAULT NULL COMMENT '修改人',
  `deleteSign` int(2) NOT NULL DEFAULT '0' COMMENT '删除标记，0否，1是',
  `stateSign` int(2) NOT NULL DEFAULT '0' COMMENT '是否在扫描中，0否，1是',
  `host` varchar(100) DEFAULT NULL COMMENT '邮箱服务器地址',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮箱账号表';

#
# Data for table "mailbox"
#

INSERT INTO `mailbox` VALUES ('00bfac17-9534-4f3d-8526-28f16eb9fb9f','liliuqing01@126.com','aHVmb3podWFuODg4','emh1YW5nZTg4OA==','admin@qq.com','2016-11-13 21:22:30',NULL,NULL,0,0,'imap.126.com'),('9a201922-ceae-4564-9562-c7d04615fa51','18813907332@126.com','aHVmb3podWFuODg4','emh1YW5nZTg4OA==','admin@qq.com','2016-11-10 22:34:40','2016-11-12 18:08:27','admin@qq.com',0,0,'imap.126.com'),('b3c3c2d2-c698-425f-a738-f9e9f31416ef','897707984@qq.com','aHVmb3podWFuMTk5NTA3','c3h0dXZ6cnB4aXpwYmFqYQ==','admin@qq.com','2016-11-12 12:08:42','2016-11-12 18:10:24','admin@qq.com',0,0,'imap.qq.com');

#
# Structure for table "order"
#

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `Id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `productId` varchar(36) DEFAULT NULL COMMENT '产品ID',
  `productnumber` varchar(32) DEFAULT NULL COMMENT '物品编号',
  `productname` varchar(255) DEFAULT NULL COMMENT '物品名称',
  `orderID` varchar(36) NOT NULL DEFAULT '' COMMENT '订单号',
  `sellerAccount` varchar(255) DEFAULT NULL COMMENT '卖家交易账号',
  `dealPrice` double(9,3) DEFAULT NULL COMMENT '成交价格（单位：美元）',
  `dealNumber` int(11) NOT NULL DEFAULT '0' COMMENT '成交数量（单位：件）',
  `dealDate` datetime DEFAULT NULL COMMENT '成交日期',
  `buyersAccount` varchar(255) DEFAULT NULL COMMENT '买家交易账号',
  `buyersAddress` varchar(500) DEFAULT NULL COMMENT '买家邮寄地址',
  `buyersMailbox` varchar(255) DEFAULT NULL COMMENT '买家邮箱地址',
  `buyersPhone` varchar(50) DEFAULT NULL COMMENT '买家联系电话',
  `MailNumber` varchar(100) DEFAULT NULL COMMENT '邮件编号',
  `MailSendDate` datetime DEFAULT NULL COMMENT '邮件发送日期',
  `deleteSign` int(11) DEFAULT '0' COMMENT '删除标记，0否，1是',
  `addDate` datetime DEFAULT NULL COMMENT '添加时间',
  `updataTime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateUser` varchar(100) DEFAULT NULL COMMENT '修改人',
  `addUser` varchar(100) DEFAULT NULL COMMENT '添加人',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详细表';

#
# Data for table "order"
#


#
# Structure for table "order_detail"
#

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `Id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `productId` varchar(36) DEFAULT NULL COMMENT '产品ID',
  `productNumber` varchar(32) DEFAULT NULL COMMENT '物品编号',
  `dealNumber` varchar(50) NOT NULL DEFAULT '' COMMENT '交易号',
  `mailNumber` varchar(100) DEFAULT NULL COMMENT '邮件编号',
  `dealTime` datetime DEFAULT NULL COMMENT '交易时间',
  `unitPrice` double(9,3) DEFAULT NULL COMMENT '单价（美元$/每件）',
  `buyNumber` int(11) DEFAULT NULL COMMENT '购买数量（单位：件）',
  `buyTime` datetime DEFAULT NULL COMMENT '购买时间',
  `buyersName` varchar(100) DEFAULT NULL COMMENT '买家名称',
  `buyersAdderss` varchar(500) DEFAULT NULL COMMENT '买家地址',
  `buyersPayAccount` varchar(255) DEFAULT NULL COMMENT '买家支付账号',
  `totalMoney` double(9,3) DEFAULT NULL COMMENT '买家支付的总金额（美元），税费+保险费+运费和手续费',
  `taxation` double(9,3) DEFAULT NULL COMMENT '税费（美元）',
  `bxf` double(8,3) DEFAULT NULL COMMENT '保险费（美元）',
  `yfhsxf` double(8,3) DEFAULT NULL COMMENT '保险费和手续费（美元）',
  `buyersMessage` varchar(500) DEFAULT NULL COMMENT '买家留言',
  `wpsm` varchar(255) DEFAULT NULL COMMENT '物品说明',
  `deleteSign` int(11) DEFAULT '0' COMMENT '删除标记，0否，1是',
  `makrs` varchar(255) DEFAULT NULL COMMENT '备注',
  `orderId` varchar(36) DEFAULT NULL COMMENT '订单Id',
  `addTime` datetime DEFAULT NULL COMMENT '添加时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateUser` varchar(100) DEFAULT NULL COMMENT '修改人',
  `addUser` varchar(100) DEFAULT NULL COMMENT '添加人',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单交易详细';

#
# Data for table "order_detail"
#


#
# Structure for table "product"
#

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '产品ID',
  `productName` varchar(200) DEFAULT NULL COMMENT '产品名称',
  `productNumber` varchar(36) DEFAULT NULL COMMENT '物品编号',
  `buyingPrice` double(10,3) DEFAULT NULL COMMENT '进货价格，单位人民币（￥）',
  `risePrice` double(10,3) DEFAULT NULL COMMENT '起标价,单位美元（US$）',
  `sellPrice` double(10,3) DEFAULT NULL COMMENT '出售价格，单位美元（US$）',
  `saleEndTime` datetime DEFAULT NULL COMMENT '拍卖结束时间',
  `publishPrice` double(8,3) DEFAULT NULL COMMENT '刊登费用',
  `releaseUser` varchar(100) DEFAULT NULL COMMENT '产品发布人账号',
  `releaseTime` datetime DEFAULT NULL COMMENT '产品发布时间',
  `updateUser` varchar(100) DEFAULT NULL COMMENT '修改人账号',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `deleteMark` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '删除标记，0否，1是',
  `imagType` int(11) DEFAULT '0' COMMENT '图片类型，0标题小图片，1页面展示大图',
  `images` blob COMMENT '产品标题小图图片',
  `imagesPath` varchar(200) DEFAULT NULL COMMENT '产品大图图片路径',
  `supplierId` varchar(36) DEFAULT NULL COMMENT '供货商Id',
  `p_describe` varchar(500) DEFAULT NULL COMMENT '产品描述',
  `sourceSign` int(11) DEFAULT '0' COMMENT '数据来源标记，0是扫描邮箱，1是手动添加',
  `brand` varchar(255) DEFAULT NULL COMMENT '商标，牌子',
  `features` varchar(255) DEFAULT NULL COMMENT '产品特点，特征',
  `p_color` varchar(100) DEFAULT NULL COMMENT '产品颜色',
  `p_weight` double(10,4) DEFAULT NULL COMMENT '产品重量（单位：克 K）',
  `p_width` double(10,2) DEFAULT NULL COMMENT '产品宽度（单位：毫米 mm）',
  `p_height` double(10,2) DEFAULT NULL COMMENT '产品高度（单位：毫米 mm）',
  `p_length` double(10,2) DEFAULT NULL COMMENT '产品长度（单位：毫米 mm）',
  `country` varchar(255) DEFAULT NULL COMMENT '生产地址',
  `URL` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '产品URL链接',
  `mailboxAccount` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '发送者邮箱账号',
  `mailId` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮件ID',
  `offsign` int(11) NOT NULL DEFAULT '0' COMMENT '下架标记，0否，1是',
  PRIMARY KEY (`id`),
  KEY `productNumber_index` (`productNumber`) COMMENT 'productNumber_index'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品';

#
# Data for table "product"
#

INSERT INTO `product` VALUES ('0806bc76-d949-463d-a35f-b3e62d5fcc14','10W E27 E26 LED 16 Color Changing RGB Magic Light #Bulb Lamp   IR Remote Control','162279055003',NULL,1.000,NULL,'2016-11-20 19:01:04',0.000,'lliuqin_0','2016-11-13 19:01:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=162279055003&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#a27fa5e313784d7591c09bf6c9b65f47#]',0),('1ad6f831-8009-47fb-9337-e7b06439e8b8','E27 LED 7 Colors RGB Bulb Light Lamp Bluetooth #Control Music Audio Smart Speaker','162279059177',NULL,10.990,NULL,'2016-11-20 19:06:06',0.000,'lliuqin_0','2016-11-13 19:06:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=162279059177&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#089ac3d38f9848619be8c8b490bcd1bf#]',0),('21ed48b9-c2a6-4692-aafa-130abe285c0f','Energy Efficient E27 15W 5730SMD 56LEDs led Corn #Bulb LED lamp-Warm White-1pcs','162278832353',NULL,1.000,NULL,'2016-11-20 12:33:09',0.000,'lliuqin_0','2016-11-13 12:33:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=162278832353&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#95e5bc0f3bdb4ca99a461e304b95b45a#]',0),('21f90ac6-b6e6-41e1-89e0-c78b4328cae1','Bluetooth Waterproof Wireless Speaker Suction Shower #speaker Hands free Mic','142160230760',NULL,3.990,NULL,'2016-11-01 22:02:32',0.000,'hfozhua_0','2016-10-25 22:02:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142160230760&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#49faad5e1fee42db904db55508132e3f#]',0),('2ad1125b-f6c8-4cab-8cad-7cf7ae5876b0','Lady Women Hobo Shoulder Bag Messenger Purse Satchel #Tote Handbag','142159734467',NULL,1.990,NULL,'2016-11-01 12:49:25',0.000,'hfozhua_0','2016-10-25 12:49:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142159734467&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#6c8b609ac0724339b30e5b57972ec49c#]',0),('3a8193ae-f16e-4089-ab14-1b1ffcfa8cf7','3D VR Box Virtual Reality 3D Smart Glass Gears VR #Headset for Samsung Galaxy S6','142160264292',NULL,5.990,NULL,'2016-11-01 22:37:22',0.000,'hfozhua_0','2016-10-25 22:37:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142160264292&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#b093fdfe0bb74a39ab4a8b2d6e2db8d5#]',0),('5b8f1763-63c4-401d-9824-56828fa3ab85','E27 8W 85-265V AC Cool White Retro Filament LED Bulb #Light Lamp','162279050996',NULL,1.990,NULL,'2016-11-20 18:55:38',0.000,'lliuqin_0','2016-11-13 18:55:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=162279050996&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#b629510705424c8db60ed0277e262070#]',0),('754b4e67-75bb-4c24-9361-9a17a6ab8a01','Flexible Lazy Bracket Mobile Phone Stand Holder Car #Bed Desk For iPhone Samsung','162278837170',NULL,0.990,NULL,'2016-11-20 12:42:07',0.000,'lliuqin_0','2016-11-13 12:42:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=162278837170&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#e8e32ce331fa4f22be9e9418a4ed1ec2#]',0),('81abd6b0-705e-4cc9-b491-a8a936d2dc84','LED RGB Bluetooth Speaker Bulb Wireless E27 12W #Power Light Lamp Music Playing','142172971963',NULL,6.990,NULL,'2016-11-14 21:28:39',0.000,'hfozhua_0','2016-11-07 21:28:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142172971963&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#4d198477812e49ad82f9334750d72320#]',0),('9b20a7c6-a7e3-4bf5-9613-8e541bd579f2','Bluetooth Wireless Speaker Mini Portable Super Bass #For Smartphone Tablet MP3 PC','142160246708',NULL,5.000,NULL,'2016-11-01 22:14:22',0.000,'hfozhua_0','2016-10-25 22:14:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142160246708&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#8b0d1d7d365a4f14b3e0a2c4d946d0c5#]',0),('ba3738ba-e630-48c8-992f-6a4f94a6d3e4','E27 LED 7 Colors RGB Bulb Light Lamp Bluetooth #Control Music Audio Smart Speaker','142167912992',NULL,6.990,NULL,'2016-11-09 07:49:21',0.000,'hfozhua_0','2016-11-02 07:49:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142167912992&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#f36c29aa17ec48db9a7ff1f5c3440249#]',0),('daf6b97a-2a57-4985-9ef9-0c7d0ec89b59','Wireless Bluetooth Selfie Remote Controller Shutter #Gamepad For iOS Android PC','142160254610',NULL,1.990,NULL,'2016-11-01 22:26:51',0.000,'hfozhua_0','2016-10-25 22:26:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142160254610&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#573a078cf5294b2f98908bbaa29ad40d#]',0),('e61f4177-6859-4a0f-9733-27d32f3b6c58','RGB Stage Laser Lights Magic Ball Party DJ Disco #Mini LED Lighting Voice-Control','142167919197',NULL,5.990,NULL,'2016-11-07 07:58:46',0.000,'hfozhua_0','2016-11-02 07:58:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142167919197&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#c6de709831ba4135bc7dc990ada14453#]',0),('e748a9d7-2ad9-4307-953a-34b9dc9826f1','1pcs Universal E14 6W 36 LED SMD 5730 Light LED Corn #Bulb cool White 110-120V','142167259240',NULL,0.090,NULL,'2016-11-08 21:11:34',0.000,'hfozhua_0','2016-11-01 21:11:00',NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'http://cgi.ebay.com/ws/eBayISAPI.dll?ViewItem&item=142167259240&ssPageName=ADME:L:LCA:US:1123','eBay<ebay@ebay.com.hk>','[#df477232a6ef42a99d36bea0e1ed34e5#]',0);

#
# Structure for table "product_images"
#

DROP TABLE IF EXISTS `product_images`;
CREATE TABLE `product_images` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键ID',
  `productId` varchar(36) DEFAULT NULL COMMENT '产品ID',
  `url` varchar(500) DEFAULT NULL COMMENT 'URL地址',
  `filePath` varchar(255) DEFAULT NULL COMMENT '图片存放目录',
  `fileName` varchar(100) DEFAULT NULL COMMENT '图片文件夹名称',
  `addTime` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '添加时间',
  `addUser` varchar(100) DEFAULT NULL COMMENT '创建人',
  `deleteSign` int(11) DEFAULT '0' COMMENT '删除标记，0否，1是',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateUser` varchar(100) DEFAULT NULL COMMENT '修改人',
  `serial` int(11) DEFAULT NULL COMMENT '图片顺序，序号',
  PRIMARY KEY (`id`),
  KEY `productId_index` (`productId`) COMMENT 'productId_index'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品图片';

#
# Data for table "product_images"
#


#
# Structure for table "repertory"
#

DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '库存ID',
  `productId` varchar(36) NOT NULL DEFAULT '' COMMENT '产品ID',
  `productCount` int(11) DEFAULT NULL COMMENT '库存总数',
  `workOffCount` int(11) DEFAULT NULL COMMENT '售出总数',
  `surplusCount` int(11) DEFAULT NULL COMMENT '库存剩余总数',
  `addUser` varchar(50) DEFAULT NULL COMMENT '添加人账号',
  `addTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '添加时间',
  `lastUpdateUser` varchar(50) DEFAULT NULL COMMENT '最后修改人账号',
  `lastUpdateTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `offSign` int(11) NOT NULL DEFAULT '0' COMMENT '下架标记，0否，1是',
  `deleteSign` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记，0否，1是',
  PRIMARY KEY (`id`),
  KEY `productId_index` (`productId`) COMMENT 'productId_index'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品库存表';

#
# Data for table "repertory"
#


#
# Structure for table "sys_menu"
#

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL COMMENT '系统url',
  `parentId` int(10) DEFAULT NULL COMMENT ' 父id 关联sys_menu.id',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除,0=未删除，1=已删除',
  `createName` varchar(60) DEFAULT NULL COMMENT '添加人账号',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateName` varchar(60) DEFAULT NULL COMMENT '修改人账号',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `rank` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `actions` varchar(500) DEFAULT '0' COMMENT '注册Action 按钮|分隔',
  `menu_sign` int(11) NOT NULL DEFAULT '0' COMMENT '0表示菜单组，1表示菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Data for table "sys_menu"
#

INSERT INTO `sys_menu` VALUES (1,'系统管理','',NULL,0,NULL,'2012-12-23 17:21:58',NULL,'2013-01-10 22:30:50',1,'',0),(2,'菜单管理','/sysMenu/menu.shtml',1,0,NULL,'2012-12-23 18:18:32',NULL,'2013-01-13 02:29:33',0,'dataList.do',1),(3,'站点管理','',NULL,1,NULL,'2012-12-23 20:26:35',NULL,'2012-12-23 21:16:51',1,'',0),(4,'站点信息管理','/siteMain/list.shtml',3,0,NULL,'2012-12-23 20:26:53',NULL,'2013-01-13 01:24:47',0,'dataList.do|/siteType/typeListJson.do',1),(5,'站点类型','/siteType/list.shtml',3,0,NULL,'2012-12-23 20:28:23',NULL,'2013-01-13 01:20:46',0,'dataList.do',1),(6,'系统用户管理','/sysUser/list.shtml',1,0,NULL,'2012-12-23 22:15:33',NULL,'2013-02-18 11:42:46',0,'dataList.do',1),(7,'角色管理','/sysRole/role.shtml',1,0,NULL,'2012-12-24 22:17:51',NULL,'2013-01-13 01:15:00',0,'dataList.do|/sysMenu/getMenuTree.do',1),(8,'系统用户授权','/sysUser/userRole.shtml',1,0,NULL,'2013-01-06 11:42:26',NULL,'2013-02-18 11:43:19',0,'userList.do|/sysRole/loadRoleList.do',1),(9,'业务功能','',NULL,0,NULL,'2013-02-09 10:42:42',NULL,'2013-02-19 17:25:42',1,'',0),(10,'职员管理','/jeecgPerson/list.shtml',9,0,NULL,'2013-02-09 10:44:45',NULL,'2013-02-20 13:32:26',1,'dataList.do',1),(13,'公告','/jeecgNote/list.shtml',9,0,NULL,'2013-02-19 17:24:36',NULL,'2013-02-19 17:27:48',1,'dataList.do',1),(16,'树形菜单管理','/sysMenu/menu2.shtml',1,0,NULL,'2016-10-13 22:22:22',NULL,NULL,0,'',1),(17,'测试','',NULL,1,NULL,'2016-10-15 23:24:06',NULL,NULL,1,'',0),(18,'测试修改功能','',NULL,1,NULL,'2016-10-15 23:24:49','admin@qq.com','2016-10-26 23:11:02',1,'',0),(19,'测试菜单12','/sysMenu/menu2.shtml',17,1,'admin@qq.com','2016-10-21 20:31:26','admin@qq.com','2016-10-26 23:13:37',0,'dataList.do',1),(20,'扫描邮件管理','/mail/startmailhtml.shtml',1,0,'admin@qq.com','2016-11-05 17:22:29','admin@qq.com','2016-11-05 17:26:35',0,'',1),(21,'产品管理','',NULL,0,'admin@qq.com','2016-11-05 19:35:58',NULL,NULL,1,'',0),(22,'产品管理','/product/list.shtml',21,0,'admin@qq.com','2016-11-05 19:44:21',NULL,NULL,0,'dataList.do',1),(23,'邮箱管理','/mailbox/list.shtml',1,0,'admin@qq.com','2016-11-10 21:10:26',NULL,NULL,0,'dataList.do',1);

#
# Structure for table "sys_menu_btn"
#

DROP TABLE IF EXISTS `sys_menu_btn`;
CREATE TABLE `sys_menu_btn` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int(11) NOT NULL COMMENT ' 菜单id关联 sys_menu.id',
  `btnName` varchar(30) DEFAULT NULL COMMENT '按钮名称',
  `btnType` varchar(30) DEFAULT NULL COMMENT '按钮类型，用于列表页显示的按钮',
  `actionUrls` varchar(250) DEFAULT NULL COMMENT 'url注册，用"," 分隔 。用于权限控制UR',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

#
# Data for table "sys_menu_btn"
#

INSERT INTO `sys_menu_btn` VALUES (5,2,'添加','add','save.do'),(6,2,'修改','edit','getId.do|save.do'),(7,2,'删除','remove','delete.do'),(8,6,'添加','add','save.do'),(9,6,'修改','edit','getId.do|save.do'),(10,6,'修改密码','editPwd','updatePwd.do'),(11,6,'删除','remove','delete.do'),(12,7,'添加','add','save.do'),(13,7,'修改','edit','getId.do|save.do'),(14,7,'删除','remove','delete.do'),(15,8,'授权','authRole','/sysUser/getUser.do|/sysUser/addUserRole.do'),(16,5,'添加','add','save.do'),(17,5,'修改','edit','getId.do|save.do'),(18,5,'删除','remove','delete.do'),(19,4,'添加','add','save.do'),(20,4,'修改','edit','getId.do|save.do'),(21,4,'删除','remove','delete.do'),(22,10,'添加','add','save.do'),(23,10,'修改','edit','getId.do|save.do'),(24,10,'删除','remove','delete.do'),(25,13,'添加','add','save.do'),(26,13,'修改','edit','getId.do|save.do'),(27,13,'删除','remove','delete.do'),(28,22,'添加','add','save.do'),(29,22,'修改','edit','getId.do|save.do'),(30,22,'删除','remove','delete.do'),(31,23,'添加','add','save.do'),(32,23,'修改','edit','getId.do|save.do'),(33,23,'删除','remove','delete.do');

#
# Structure for table "sys_role"
#

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `roleName` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createBy` int(11) DEFAULT NULL COMMENT '创建人',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateBy` int(11) DEFAULT NULL COMMENT '修改人',
  `state` int(1) DEFAULT NULL COMMENT '状态0=可用 1=禁用',
  `descr` varchar(200) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

#
# Data for table "sys_role"
#

/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'系统管理员','2013-01-05 16:07:00',NULL,'2016-11-10 21:11:34',NULL,0,NULL),(3,'管理员','2013-01-06 10:45:06',NULL,'2013-01-14 11:22:38',NULL,0,NULL),(18,'站点管理','2013-01-13 01:21:46',NULL,'2013-01-13 01:21:54',NULL,0,'站点管理'),(19,'测试管理员','2013-01-13 17:10:21',NULL,'2013-02-09 21:11:41',NULL,0,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

#
# Structure for table "sys_role_rel"
#

DROP TABLE IF EXISTS `sys_role_rel`;
CREATE TABLE `sys_role_rel` (
  `roleId` int(11) NOT NULL DEFAULT '0' COMMENT '角色主键 sys_role.id',
  `objId` int(11) NOT NULL COMMENT '关联主键 type=0管理sys_menu.id, type=1关联sys_user.id',
  `relType` int(1) DEFAULT NULL COMMENT '关联类型 0=菜单,1=用户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_role_rel"
#

INSERT INTO `sys_role_rel` VALUES (1,3,1),(18,4,0),(18,5,0),(18,19,2),(18,20,2),(18,16,2),(18,17,2),(18,5,1),(3,5,1),(3,8,0),(3,1,0),(3,2,0),(3,6,0),(3,7,0),(3,5,2),(3,8,2),(3,9,2),(3,12,2),(3,13,2),(3,15,2),(18,6,1),(3,6,1),(1,6,1),(19,6,1),(19,8,0),(19,1,0),(19,2,0),(19,6,0),(19,7,0),(19,7,2),(19,8,2),(19,10,2),(19,13,2),(19,15,2),(3,1,1),(18,1,1),(19,1,1),(1,1,1),(3,13,1),(1,1,0),(1,2,0),(1,6,0),(1,7,0),(1,8,0),(1,16,0),(1,20,0),(1,23,0),(1,9,0),(1,10,0),(1,13,0),(1,21,0),(1,22,0),(1,5,2),(1,6,2),(1,7,2),(1,8,2),(1,9,2),(1,10,2),(1,11,2),(1,12,2),(1,13,2),(1,14,2),(1,15,2),(1,31,2),(1,32,2),(1,33,2),(1,22,2),(1,23,2),(1,24,2),(1,25,2),(1,26,2),(1,27,2),(1,28,2),(1,29,2),(1,30,2);

#
# Structure for table "sys_user"
#

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `email` varchar(50) NOT NULL COMMENT '邮箱也是登录帐号',
  `pwd` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0=可用,1=禁用',
  `loginCount` int(11) DEFAULT NULL COMMENT '登录总次数',
  `loginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态 0=未删除,1=已删除',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createBy` int(11) DEFAULT NULL COMMENT '创建人',
  `updateBy` int(11) DEFAULT NULL COMMENT '修改人',
  `superAdmin` int(1) NOT NULL DEFAULT '0' COMMENT '是否超级管理员 0= 不是，1=是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

#
# Data for table "sys_user"
#

INSERT INTO `sys_user` VALUES (1,'admin@qq.com','C33367701511B4F6020EC61DED352059','系统管理员',0,428,'2016-11-15 16:34:40',0,'2012-12-23 23:01:15','2016-11-15 16:34:40',NULL,NULL,1),(5,'wolf@qq.com','827CCB0EEA8A706C4C34A16891F84E7B','scott2',0,71,'2013-02-09 10:29:42',0,'2013-01-07 12:30:10','2016-10-13 00:36:01',NULL,NULL,0),(6,'youke@qq.com',NULL,' 游客',0,NULL,NULL,0,'2013-01-13 03:41:32','2013-01-13 03:41:32',NULL,NULL,0),(12,'zhangdaihaoscot@163.com',NULL,'ces',1,NULL,NULL,0,'2013-02-20 11:24:28','2013-02-20 11:24:28',NULL,NULL,0),(13,'18813907332@126.com',NULL,'enter',0,NULL,NULL,0,'2016-10-12 23:47:02','2016-10-12 23:47:02',NULL,NULL,0);
