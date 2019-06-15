drop database  if EXISTS ExamDB;
create database ExamDB;

use ExamDB;


CREATE TABLE `ty_examination_template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考试模板id',
  `examination_name` varchar(255) NOT  NULL COMMENT '考试模板名称',
  `template_type_dic_id` int(11) NOT  NULL COMMENT '模板分类id（0/司机 1/押韵）关联字典表',
  `create_by` varchar(25)  NOT NULL COMMENT '创建人',
  `update_by` varchar(25)  NULL COMMENT '更新人',
  `create_date` datetime  NOT NULL COMMENT '创建时间',
  `update_date` datetime  NULL COMMENT '更新时间',
  `status` int(11)   NULL COMMENT '状态',
  `delflag` int(11) NOT NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT='考试模板表';


CREATE TABLE `ty_examination_template_question_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考试模板题型id',
  `score` int(25) NOT  NULL COMMENT '分数',
  `exam_number` int(11) NOT NULL COMMENT '题数量',
  `question_type` int(11) NOT  NULL COMMENT '题类型',
  `examination_template_id` int(11) NOT  NULL COMMENT '考试模板id',
  `create_by` varchar(25) NOT  NULL COMMENT '创建人',
  `update_by` varchar(25)  NULL COMMENT '更新人',
  `create_date` datetime NOT  NULL COMMENT '创建时间',
  `update_date` datetime  NULL COMMENT '更新时间',
  `status`  int(11)  NULL COMMENT '状态',
  `delflag` int(11)  NOT NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT='考试模板题型表';


CREATE TABLE `ty_exam_paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `total_score` int(25)  NOT   NULL COMMENT '总分数',
  `exam_time` varchar(255)  NOT    NULL COMMENT '考试时间',
  `examination_template_id` int(11) NOT  NULL COMMENT '考试模板id',
  `exam_question_id` int(11) NOT  NULL COMMENT '试题id',
  `create_by` varchar(25) NOT NULL COMMENT '创建人',
  `update_by` varchar(25)  NULL COMMENT '更新人',
  `create_date` datetime NOT  NULL COMMENT '创建时间',
  `update_date` datetime  NULL COMMENT '更新时间',
  `status` int(11)   NULL COMMENT '状态',
  `delflag` int(11) NOT NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT='试卷表';
