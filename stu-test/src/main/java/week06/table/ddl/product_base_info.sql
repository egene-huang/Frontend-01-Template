CREATE TABLE product_base_info
(
    `sku_id` BIGINT NOT NULL,
    `sku_name`  VARCHAR(200) NOT NULL,
    `spu_id` BIGINT NOT NULL,
    `sell_price` DECIMAL(11,2) NOT NULL,
    `cost_price` DECIMAL(11,2) NOT NULL,
    `create_time` timestamp NOT NULL,
    `update_time` timestamp NOT NULL,
    PRIMARY KEY ( `sku_id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment =`基本商品信息表`;