use MY_DB;
CREATE TABLE user_info
(
    `pin` VARCHAR(50) NOT NULL,
    `nick_name`   VARCHAR(25),
    `mobile` VARCHAR(11) NOT NULL,
    `country` VARCHAR(5) NOT NULL,
    `create_time` timestamp NOT NULL,
    `update_time` timestamp NOT NULL,
    PRIMARY KEY ( `pin` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment ='用户信息表';