create database todo;

use todo;

create table if not exists task (
    id bigint auto_increment primary key,
    description varchar(200) not null,
    status varchar(40)
);


