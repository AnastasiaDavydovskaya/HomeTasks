create database todo;

use todo;

create table if not exists task
(
    id          bigint auto_increment primary key,
    description varchar(200) not null,
    status      varchar(40)
);

create table if not exists file
(
    id        bigint auto_increment primary key,
    file_name varchar(100),
    id_task   bigint
);

drop database todo;











