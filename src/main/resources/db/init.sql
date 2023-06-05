CREATE TABLE `teacher`
(
    `id`           int(11)    NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_create`   datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `creator`      varchar(50)         DEFAULT NULL COMMENT '创建者',
    `modifier`     varchar(50)         DEFAULT NULL COMMENT '修改者',
    `is_delete`    tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `sort_index`   float      NOT NULL DEFAULT '99' COMMENT '排序',
    `title`        varchar(100)        DEFAULT NULL COMMENT '标题',
    `version`      bigint(20)          DEFAULT NULL COMMENT '版本号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='教师表';

CREATE TABLE `student`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_create`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `creator`      varchar(50)           DEFAULT NULL COMMENT '创建者',
    `modifier`     varchar(50)           DEFAULT NULL COMMENT '修改者',
    `is_delete`    tinyint(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
    `sort_index`   float        NOT NULL DEFAULT '99' COMMENT '排序',
    `title`        varchar(100) NOT NULL DEFAULT 'test' COMMENT '标题',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='学生表';

CREATE TABLE `student_detail`
(
    `id`           INT(11)    NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_create`   DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `creator`      VARCHAR(50)         DEFAULT NULL COMMENT '创建者',
    `modifier`     VARCHAR(50)         DEFAULT NULL COMMENT '修改者',
    `is_delete`    TINYINT(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `sort_index`   FLOAT      NOT NULL DEFAULT '99' COMMENT '排序',
    `student_id`   INT(11)             DEFAULT NULL COMMENT '学生id',
    `age`          INT(11)             DEFAULT NULL COMMENT '年龄',
    `email`        VARCHAR(1024)       DEFAULT NULL COMMENT '邮箱',
    `address`      VARCHAR(1024)       DEFAULT NULL COMMENT '地址',
    `description`  json                DEFAULT NULL COMMENT '描述Json',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='学生详细信息表';


CREATE TABLE `student_book`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_create`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `creator`      varchar(50)           DEFAULT NULL COMMENT '创建者',
    `modifier`     varchar(50)           DEFAULT NULL COMMENT '修改者',
    `is_delete`    tinyint(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
    `sort_index`   float        NOT NULL DEFAULT '99' COMMENT '排序',
    `title`        varchar(100) NOT NULL DEFAULT 'test' COMMENT '标题',
    `price`        float        NOT NULL DEFAULT '0.1' COMMENT '价格',
    `student_id`   int(11)               DEFAULT NULL COMMENT '学生id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='学生书本表';


CREATE TABLE `course`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_create`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `creator`      varchar(50)           DEFAULT NULL COMMENT '创建者',
    `modifier`     varchar(50)           DEFAULT NULL COMMENT '修改者',
    `is_delete`    tinyint(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
    `sort_index`   float        NOT NULL DEFAULT '99' COMMENT '排序',
    `title`        varchar(100) NOT NULL DEFAULT 'test' COMMENT '标题',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='课程表';

CREATE TABLE `course_student`
(
    `id`           int(11)    NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_create`   datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `creator`      varchar(50)         DEFAULT NULL COMMENT '创建者',
    `modifier`     varchar(50)         DEFAULT NULL COMMENT '修改者',
    `is_delete`    tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `course_id`    int(11)             DEFAULT NULL COMMENT '课程id',
    `student_id`   int(11)             DEFAULT NULL COMMENT '学生id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='课程学生关联中间表';