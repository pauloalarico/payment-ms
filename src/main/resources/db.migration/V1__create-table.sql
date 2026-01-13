create table ms_payments
(
    cd_idnt_payment UUID default uuid_generate_v4() not null UNIQUE ,
    cd_idnt_order varchar(255) not null UNIQUE ,
    vl_payment int not null,
    cd_status varchar(255) not null,
    PRIMARY KEY(cd_idnt_payment)
);
