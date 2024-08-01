USE `au`;
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
`user_name`  varchar(32) NOT NULL COMMENT '用户名字',
`openid`  varchar(32) NULL COMMENT '用户id',
`role`  bigint NOT NULL COMMENT '微信登录用户唯一标识',
`phone`  varchar(32) NULL COMMENT '用户手机号',
`province`  varchar(32) NULL COMMENT '用户所在省份',
`city`  varchar(32) NULL COMMENT '用户所在城市',
`avatar_url`  bigint NULL COMMENT '用户头像地址',
`create_time`  datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
`update_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户修改时间',
`is_delete`  int(1) NULL COMMENT '是否删除',
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
;

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
`title`  varchar(32) NOT NULL COMMENT '角色名',
`des`  varchar(256) NULL COMMENT '角色描述',
PRIMARY KEY (`id`)
)
;

DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '权限id',
`title`  varchar(32) NOT NULL COMMENT '权限名',
`des`  varchar(256) NULL COMMENT '权限描述',
PRIMARY KEY (`id`)
)
;

DROP TABLE IF EXISTS `rel_role_permission`;
CREATE TABLE `rel_role_permission` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '角色权限关联id',
`role_id`  bigint NULL COMMENT '角色id',
`permission_id`  bigint NULL COMMENT '权限id',
PRIMARY KEY (`id`)
)
;

DROP TABLE IF EXISTS `tb_vehicle`;
CREATE TABLE `tb_vehicle` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '车辆id',
`vehicle_make`  varchar(64) NULL COMMENT '车辆品牌，例如“宝马”',
`vehicle_model`  varchar(64) NULL COMMENT '车型/车系，例如“宝马GT”',
`vehicle_level`  varchar(16) NULL COMMENT '车级别，例如“商务|SUV|新能源”',
`color`  varchar(16) NULL COMMENT '车辆颜色，多选，例如"黑|灰"',
`price`  varchar(32) NULL DEFAULT '价格面议' COMMENT '车辆租金',
`energy_type`  varchar(32) NULL DEFAULT NULL COMMENT '能源类型，例如“混动”',
`seat_count`  int(2) NULL DEFAULT 5 COMMENT '座位数',
`data_source`  varchar(256) NULL COMMENT '数据源',
`des`  text NULL DEFAULT NULL COMMENT '车辆介绍描述',
`hot`  bigint NULL DEFAULT 0 COMMENT '车辆热度',
`tag`  int(1) NULL DEFAULT 3 COMMENT '维度 1 品牌,2 车系,3 车辆',
`create_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
UNIQUE INDEX `unique_make_model` (`vehicle_make`, `vehicle_model`) ,
INDEX `index_tag_vehicleMake` (`tag`, `vehicle_make`) ,
INDEX `index_tag_vehicleModel` (`tag`, `vehicle_model`)
)
;

DROP TABLE IF EXISTS `rel_vehicle_picture`;
CREATE TABLE `rel_vehicle_picture` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '车辆图片id',
`vehicle_id`  bigint NULL COMMENT '车辆id',
`pic_id`  bigint NULL COMMENT '图片id',
`create_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`)
)
;

DROP TABLE IF EXISTS `rel_user_mark`;
CREATE TABLE `rel_user_mark` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '收藏id',
`user_id`  bigint NULL COMMENT '用户id',
`vehicle_id`  bigint NULL COMMENT '车辆id',
`create_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '收藏时间',
PRIMARY KEY (`id`)
)
;

DROP TABLE IF EXISTS `tb_picture`;
CREATE TABLE `tb_picture` (
`id`  bigint NOT NULL AUTO_INCREMENT COMMENT '图片id',
`pic_name`  varchar(32) NULL COMMENT '图片名',
`pic_url`  varchar(256) NULL COMMENT '图片地址',
`base64_data`  blob NULL COMMENT '图片base数据',
`type`  varchar(32) NULL COMMENT '图片类型：IMAGE_VEHICLE_MAKE:品牌图片 IMAGE_VEHICLE_MODEL:车系图片 IMAGE_VEHICLE:车辆图片 IMAGE_AVATAR:头像图片',
`create_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete`  int(1) NULL COMMENT '是否删除',
PRIMARY KEY (`id`)
)
;



