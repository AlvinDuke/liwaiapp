-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.0.96-community-nt - MySQL Community Edition (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 liwaiapp 的数据库结构
CREATE DATABASE IF NOT EXISTS `liwaiapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `liwaiapp`;


-- 导出  表 liwaiapp.dep_scope 结构
CREATE TABLE IF NOT EXISTS `dep_scope` (
  `id` int(11) NOT NULL auto_increment,
  `o_id` int(11) default NULL,
  `s_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKB3EB9E24BEE1B1FA` (`s_id`),
  CONSTRAINT `FKB3EB9E24BEE1B1FA` FOREIGN KEY (`s_id`) REFERENCES `t_dep` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.dep_scope 的数据：~0 rows (大约)
DELETE FROM `dep_scope`;
/*!40000 ALTER TABLE `dep_scope` DISABLE KEYS */;
/*!40000 ALTER TABLE `dep_scope` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_attachment 结构
CREATE TABLE IF NOT EXISTS `t_attachment` (
  `id` int(11) NOT NULL auto_increment,
  `cre_date` datetime default NULL,
  `new_name` varchar(255) default NULL,
  `old_name` varchar(255) default NULL,
  `size` bigint(20) NOT NULL,
  `type` varchar(255) default NULL,
  `doc_id` int(11) default NULL,
  `msg_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK48549DCE934651E` (`doc_id`),
  KEY `FK48549DCE2E2E7FF` (`msg_id`),
  CONSTRAINT `FK48549DCE2E2E7FF` FOREIGN KEY (`msg_id`) REFERENCES `t_msg` (`id`),
  CONSTRAINT `FK48549DCE934651E` FOREIGN KEY (`doc_id`) REFERENCES `t_doc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_attachment 的数据：~0 rows (大约)
DELETE FROM `t_attachment`;
/*!40000 ALTER TABLE `t_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_attachment` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_dep 结构
CREATE TABLE IF NOT EXISTS `t_dep` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_dep 的数据：~0 rows (大约)
DELETE FROM `t_dep`;
/*!40000 ALTER TABLE `t_dep` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_dep` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_dep_doc 结构
CREATE TABLE IF NOT EXISTS `t_dep_doc` (
  `id` int(11) NOT NULL auto_increment,
  `dep_id` int(11) default NULL,
  `dco_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK18318C3D6F1438DE` (`dep_id`),
  KEY `FK18318C3D890BF86` (`dco_id`),
  CONSTRAINT `FK18318C3D890BF86` FOREIGN KEY (`dco_id`) REFERENCES `t_doc` (`id`),
  CONSTRAINT `FK18318C3D6F1438DE` FOREIGN KEY (`dep_id`) REFERENCES `t_dep` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_dep_doc 的数据：~0 rows (大约)
DELETE FROM `t_dep_doc`;
/*!40000 ALTER TABLE `t_dep_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_dep_doc` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_doc 结构
CREATE TABLE IF NOT EXISTS `t_doc` (
  `id` int(11) NOT NULL auto_increment,
  `content` text,
  `cre_date` datetime default NULL,
  `title` varchar(255) default NULL,
  `u_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK68F5AED99D47F1` (`u_id`),
  CONSTRAINT `FK68F5AED99D47F1` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_doc 的数据：~0 rows (大约)
DELETE FROM `t_doc`;
/*!40000 ALTER TABLE `t_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_doc` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_msg 结构
CREATE TABLE IF NOT EXISTS `t_msg` (
  `id` int(11) NOT NULL auto_increment,
  `content` text,
  `cre_date` datetime default NULL,
  `title` varchar(255) default NULL,
  `u_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK68F7D3699D47F1` (`u_id`),
  CONSTRAINT `FK68F7D3699D47F1` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_msg 的数据：~0 rows (大约)
DELETE FROM `t_msg`;
/*!40000 ALTER TABLE `t_msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_msg` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_pro 结构
CREATE TABLE IF NOT EXISTS `t_pro` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `sales` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_pro 的数据：~2 rows (大约)
DELETE FROM `t_pro`;
/*!40000 ALTER TABLE `t_pro` DISABLE KEYS */;
INSERT INTO `t_pro` (`id`, `name`, `sales`, `status`) VALUES
	(1, '地中海风情卧床', 150, 1),
	(2, '欧美风情皇家双人床', 100, 1);
/*!40000 ALTER TABLE `t_pro` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_pro_module 结构
CREATE TABLE IF NOT EXISTS `t_pro_module` (
  `id` int(11) NOT NULL auto_increment,
  `colourkey` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `purchaseprice` int(11) NOT NULL,
  `retailprice` int(11) NOT NULL,
  `sales` int(11) NOT NULL,
  `sizekey` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_pro_module 的数据：~3 rows (大约)
DELETE FROM `t_pro_module`;
/*!40000 ALTER TABLE `t_pro_module` DISABLE KEYS */;
INSERT INTO `t_pro_module` (`id`, `colourkey`, `pid`, `purchaseprice`, `retailprice`, `sales`, `sizekey`, `stock`) VALUES
	(1, 1, 1, 100, 150, 10, 100, 100),
	(2, 2, 1, 150, 200, 20, 101, 200),
	(3, 2, 2, 1999, 3999, 5, 101, 50);
/*!40000 ALTER TABLE `t_pro_module` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_pro_module_values 结构
CREATE TABLE IF NOT EXISTS `t_pro_module_values` (
  `id` int(11) NOT NULL auto_increment,
  `conkey` int(11) default NULL,
  `conval` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_pro_module_values 的数据：~4 rows (大约)
DELETE FROM `t_pro_module_values`;
/*!40000 ALTER TABLE `t_pro_module_values` DISABLE KEYS */;
INSERT INTO `t_pro_module_values` (`id`, `conkey`, `conval`) VALUES
	(1, 1, '卡其色'),
	(2, 2, '米蓝色'),
	(3, 100, '1.2米'),
	(4, 101, '1.5米');
/*!40000 ALTER TABLE `t_pro_module_values` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `email` varchar(255) default NULL,
  `nickname` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `dep_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKCB63CCB66F1438DE` (`dep_id`),
  CONSTRAINT `FKCB63CCB66F1438DE` FOREIGN KEY (`dep_id`) REFERENCES `t_dep` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_user 的数据：~0 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_user_msg 结构
CREATE TABLE IF NOT EXISTS `t_user_msg` (
  `id` int(11) NOT NULL auto_increment,
  `is_read` int(11) default NULL,
  `mid` int(11) default NULL,
  `uid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKA6CF58789686B1C` (`uid`),
  KEY `FKA6CF5878425F7FAE` (`mid`),
  CONSTRAINT `FKA6CF5878425F7FAE` FOREIGN KEY (`mid`) REFERENCES `t_msg` (`id`),
  CONSTRAINT `FKA6CF58789686B1C` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_user_msg 的数据：~0 rows (大约)
DELETE FROM `t_user_msg`;
/*!40000 ALTER TABLE `t_user_msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_msg` ENABLE KEYS */;


-- 导出  表 liwaiapp.t_user_read_doc 结构
CREATE TABLE IF NOT EXISTS `t_user_read_doc` (
  `id` int(11) NOT NULL auto_increment,
  `d_id` int(11) default NULL,
  `u_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK580CA47858740A72` (`d_id`),
  KEY `FK580CA47899D47F1` (`u_id`),
  CONSTRAINT `FK580CA47899D47F1` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK580CA47858740A72` FOREIGN KEY (`d_id`) REFERENCES `t_doc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  liwaiapp.t_user_read_doc 的数据：~0 rows (大约)
DELETE FROM `t_user_read_doc`;
/*!40000 ALTER TABLE `t_user_read_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_read_doc` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
