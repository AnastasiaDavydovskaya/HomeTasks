create database students;

use students;

create table if not exists student
(
    id         bigint primary key auto_increment,
    first_name varchar(50),
    last_name  varchar(50),
    gpa        float
);

create table if not exists city
(
    id     bigint primary key auto_increment,
    street varchar(50) not null,
    number int
);

alter table student
    add column city_id bigint,
    add foreign key fk_city (city_id) references city (id);

SELECT concat_ws(' ', s.first_name, s.last_name, s.gpa) AS Student,
       concat_ws(' ', c.street, c.number)               as City
FROM student s
         join city c on s.city_id = c.id;