create database todo;

use todo;

create table if not exists task (
    description varchar(200) not null,
    status varchar(40)
);
