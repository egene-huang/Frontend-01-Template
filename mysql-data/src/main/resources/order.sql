create table MY_DB.order_info
(
    order_id       bigint         not null,
    amount         decimal(11, 2) not null,
    pin            varchar(50)    not null,
    payment_amount decimal(11, 2) not null,
    payment_time   timestamp      not null,
    site           char           not null,
    create_time    timestamp      not null,
    update_time    timestamp      not null,
    id             bigint auto_increment
        primary key
)
    comment '基本订单信息表' charset = utf8;