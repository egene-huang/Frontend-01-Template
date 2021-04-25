CREATE TABLE order_info
(
    `order_id` BIGINT NOT NULL,
    `amount` DECIMAL(11,2) NOT NULL,
    `pin` VARCHAR(50) NOT NULL,
    `payment_amount` DECIMAL(11,2) NOT NULL,
    `payment_time` DECIMAL(11,2) NOT NULL,
    `site` DECIMAL(11,2) NOT NULL,
    `create_time` timestamp NOT NULL,
    `update_time` timestamp NOT NULL,
    PRIMARY KEY ( `order_id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment =`基本订单信息表`;