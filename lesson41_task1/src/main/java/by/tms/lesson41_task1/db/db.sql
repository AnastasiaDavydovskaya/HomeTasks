create database student;

    use student;

        create table if not exists student(
            id bigint primary key auto_increment,
            first_name varchar(50) not null,
            last_name varchar(50) not null,
            number_of_group varchar(50),
            gpa double
        );
