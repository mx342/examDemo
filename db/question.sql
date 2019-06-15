DROP DATABASE IF EXISTS ExamDB;
Create DATABASE IF NOT EXISTS ExamDB;
use ExamDB;

DROP TABLE IF EXISTS `ty_question_bank`;
CREATE TABLE `ty_question_bank`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题库id',
  `name` varchar(255)  COMMENT '题库名称',
  `create_by` varchar(25) NOT NULL COMMENT '创建人',
  `update_by` varchar(25) DEFAULT NULL COMMENT '更新人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int(11) NULL COMMENT '状态',
  `delflag` int(11)  NOT NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  DEFAULT CHARSET=utf8 COMMENT='题库表';

DROP TABLE IF EXISTS `ty_test_question`;
CREATE TABLE `ty_test_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题id',
  `question_trunk` varchar(255) NOT NULL COMMENT '题干',
  `answer` longtext NOT NULL COMMENT '答案([{"A":"XX","B":"XX"}]（json格式）)',
  `right_answer` varchar(20) NOT NULL COMMENT '正确答案(["A","B"]（array格式）)',
  `question_type_id` int(11) NOT NULL COMMENT '试题类型（字典表外键）',
  `question_bank_id` int(11) NOT NULL COMMENT '题库id',
  `create_by` varchar(25) NOT NULL COMMENT '创建人',
  `update_by` varchar(25) DEFAULT NULL COMMENT '更新人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int(11) NULL COMMENT '状态',
  `delflag` int(11) NOT NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  DEFAULT CHARSET=utf8 COMMENT='试题表';

