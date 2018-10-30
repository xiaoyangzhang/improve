/*回复内容表*/
CREATE TABLE zkt_wechat.`wx_reply_content` (
  `wx_reply_content_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wx_reply_strategy_id` bigint(20) NOT NULL COMMENT '回复规则id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `creator_id` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除0:未删除1:删除',
  `modifier_id` bigint(20) DEFAULT '0' COMMENT '更新人id',
  PRIMARY KEY (`wx_reply_content_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='回复内容表';
/*规则表*/
CREATE TABLE zkt_wechat.`wx_reply_strategy` (
  `wx_reply_strategy_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `reply_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '回复类型0:关注回复1:关键词回复2:收到消息回复',
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '规则名称',
  `reply_way` tinyint(1) NOT NULL DEFAULT '0' COMMENT '回复方式0:全部回复1:随机选择一条回复',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除0:未删除1:删除',
  `brand_id` int(20) NOT NULL COMMENT '集团id',
  `hotel_id` int(11) NOT NULL COMMENT '酒店id',
  `creator_id` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `modifier_id` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `client_ip` int(11) NOT NULL DEFAULT '0' COMMENT '客户端ip',
  `auto_reply_config` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否开启收到消息自动回复0:不开启1:开启',
  `start_time` varchar(20) NOT NULL DEFAULT '' COMMENT '收到消息回复开始时间',
  `end_time` varchar(20) NOT NULL DEFAULT '' COMMENT '收到消息回复结束时间',
  `valid_dates` varchar(20) NOT NULL DEFAULT '0' COMMENT '收到消息回复有效日期',
  PRIMARY KEY (`wx_reply_strategy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='回复规则表';
/*关键词表*/
CREATE TABLE zkt_wechat.`wx_strategy_key` (
  `wx_strategy_key_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `match_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '匹配方式0:模糊1:全匹配',
  `key_word` varchar(50) NOT NULL DEFAULT '' COMMENT '关键词',
  `wx_reply_strategy_id` bigint(20) NOT NULL COMMENT '规则id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `creator_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除0:未删除1:删除',
  `modifier_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人id',
  PRIMARY KEY (`wx_strategy_key_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关键词回复表';
/*回复内容详情表*/
CREATE TABLE zkt_wechat.`wx_reply_content_detail` (
  `wx_reply_content_detail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '内容类型0:自定义图文1:素材库图文2:超链接3:文本4:图片',
  `wx_reply_strategy_id` bigint(20) NOT NULL COMMENT '回复规则id',
  `wx_reply_content_id` bigint(20) NOT NULL COMMENT '回复内容id',
  `content` text NOT NULL COMMENT '回复内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `creator_id` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除0:未删除1:删除',
  `modifier_id` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `enable_show_redpacket` tinyint(4) DEFAULT '0' COMMENT '关注微信公众号同步展示新人红包0:否1:是',
  PRIMARY KEY (`wx_reply_content_detail_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='回复内容详情表';