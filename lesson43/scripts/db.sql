create database shop;

use shop;

create table if not exists user
(
    id bigint primary key auto_increment,
    login    varchar(50) not null,
    password varchar(30) not null,
    role varchar(30)
);
insert into user(login, password, role)
values ('admin@mail.ru', 'admin', 'ADMIN');






