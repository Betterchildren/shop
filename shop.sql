/*
 Navicat Premium Data Transfer

 Source Server         : xsyz
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 11/01/2020 22:27:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_p_filename` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_p_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_p_price` decimal(10, 2) NULL DEFAULT NULL,
  `cart_quantity` int(11) NULL DEFAULT NULL,
  `cart_p_stock` int(11) NULL DEFAULT NULL,
  `cart_p_id` int(11) NULL DEFAULT NULL,
  `cart_u_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES (24, 's4.jpg', '盘子', 33.00, 4, 333, 31, 'admin', 1);
INSERT INTO `shop_cart` VALUES (27, 'flo4.jpg', '花束', 21.00, 2, 111, 23, 'admin', 1);
INSERT INTO `shop_cart` VALUES (35, 'flo4.jpg', '花束', 21.00, 4, 111, 23, '1', 1);
INSERT INTO `shop_cart` VALUES (36, 'flo5.jpg', '花朵', 33.00, 1, 333, 30, '1', 1);

-- ----------------------------
-- Table structure for shop_category
-- ----------------------------
DROP TABLE IF EXISTS `shop_category`;
CREATE TABLE `shop_category`  (
  `CATE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CATE_PARENT_ID` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`CATE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_category
-- ----------------------------
INSERT INTO `shop_category` VALUES (1, '摆件', 0);
INSERT INTO `shop_category` VALUES (2, '布饰', 0);
INSERT INTO `shop_category` VALUES (3, '墙饰', 0);
INSERT INTO `shop_category` VALUES (4, '家居', 0);
INSERT INTO `shop_category` VALUES (5, '花艺', 1);
INSERT INTO `shop_category` VALUES (6, '花瓶', 1);
INSERT INTO `shop_category` VALUES (7, '桌布', 2);
INSERT INTO `shop_category` VALUES (8, '靠垫', 2);
INSERT INTO `shop_category` VALUES (9, '装饰', 3);
INSERT INTO `shop_category` VALUES (10, '家居', 4);

-- ----------------------------
-- Table structure for shop_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product`  (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10, 2) NOT NULL,
  `PRODUCT_STOCK` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_FID` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_CID` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_FILENAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_product
-- ----------------------------
INSERT INTO `shop_product` VALUES (23, '花束', '花束', 21.00, 111, 1, 5, 'flo4.jpg');
INSERT INTO `shop_product` VALUES (24, '鲜花', '鲜花', 33.00, 222, 1, 5, 'flo6.jpg');
INSERT INTO `shop_product` VALUES (25, '花瓶', '花瓶', 12.00, 111, 1, 6, 'flo1.jpg');
INSERT INTO `shop_product` VALUES (26, '桌布', '桌布', 25.00, 222, 2, 7, 'idea8.jpg');
INSERT INTO `shop_product` VALUES (27, '靠垫', '靠垫', 44.00, 222, 2, 8, 's9.jpg');
INSERT INTO `shop_product` VALUES (28, '画像', '画像', 22.00, 222, 3, 9, 'i3.jpg');
INSERT INTO `shop_product` VALUES (29, '桌椅', '桌椅', 22.00, 333, 4, 10, 's7.jpg');
INSERT INTO `shop_product` VALUES (30, '花朵', '花朵', 33.00, 333, 1, 5, 'flo5.jpg');

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user`  (
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_BIRTHDAY` datetime(0) NULL DEFAULT NULL,
  `USER_IDENITY_CODE` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_EMAIL` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_STATUS` decimal(6, 0) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES ('1', '1', '1', 'T', '2019-12-07 00:00:00', NULL, '2877147906@qq.com', '17639386005', '河南科技大学', 1);
INSERT INTO `shop_user` VALUES ('111', '111', '111', 'T', '2013-12-12 00:00:00', NULL, '211', '12', '12', 1);
INSERT INTO `shop_user` VALUES ('2', '2', '2', 'T', '2010-12-12 00:00:00', NULL, '1', '1', '1', 1);
INSERT INTO `shop_user` VALUES ('admin', 'admin', '123', 'T', '2019-10-08 00:00:00', NULL, 'aaa@bbb.com', '222222', '4323323232323232', 2);
INSERT INTO `shop_user` VALUES ('admin1', 'admin', '123', 'T', '2019-10-08 00:00:00', NULL, 'aaa@bbb.com', '222222', '4323323232323232', 2);
INSERT INTO `shop_user` VALUES ('lisi67', '李四', '111', 'T', '2019-11-05 00:00:00', NULL, 'lisi@lmonkey.com', '15801684888', '北京西二期软件园', 1);
INSERT INTO `shop_user` VALUES ('qewqewq', 'wq', 'wq', 'T', '2019-11-11 00:00:00', NULL, 'dddsds', 'dsdsds', 'dsdsds', 1);
INSERT INTO `shop_user` VALUES ('wangwu', '王五', '111', 'T', '2019-11-01 00:00:00', NULL, 'wangwu@lmonkey.com', '18810090000', '中关村软件园', 1);
INSERT INTO `shop_user` VALUES ('xsyz', 'xsyz', '1', 'T', '2020-12-12 00:00:00', NULL, '12', '12', '12', 1);
INSERT INTO `shop_user` VALUES ('zhangsan', '张三', '111', 'T', '2019-11-08 00:00:00', NULL, 'zhangsan@lmonkey.com', '1192121221', '北京西二期软件园', 1);
INSERT INTO `shop_user` VALUES ('zhaoliu1', '赵六', '111', 'F', '2019-11-11 00:00:00', NULL, 'zhaoliu@lmonkey.com', '18810683388', '北京市海淀区中关村软件园二期', 1);

SET FOREIGN_KEY_CHECKS = 1;
