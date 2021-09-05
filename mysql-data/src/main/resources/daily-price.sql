create table daily_price(
    id BIGINT not null AUTO_INCREMENT,
    sku_id BIGINT NOT NULL,
    dt_day date NOT NULL,
    price DECIMAL(11, 2) not null,
    yn TINYINT NOT NULL DEFAULT 1,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( `id` ),
    unique uniq_skuId_dtDay(`sku_id`, `dt_day`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into daily_price(price) values (123.45);

alter table daily_price add sku_id BIGINT NOT NULL after id;

alter table daily_price add dt_day date NOT NULL after sku_id;

describe daily_price;

create unique index uniq_skuId_dtDay on daily_price(`sku_id`, `dt_day`);
select * from daily_price where sku_id = 8533983719787939363 and dt_day = '2021-09-04' limit 10;

explain select * from daily_price where dt_day = '2021-09-04' and sku_id = 8533983719787939363 and yn = 1;
explain select * from daily_price where yn = 1 and dt_day = '2021-09-04' and sku_id = 8533983719787939363;
explain select * from daily_price where yn = 1 and sku_id = 8533983719787939284;
explain select * from daily_price where sku_id = 8533983719787939284 and  yn = 1;

update daily_price set yn = 0 where sku_id = 8533983719787939363;

create index index_dtDay on daily_price(`dt_day`);