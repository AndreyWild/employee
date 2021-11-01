create table employees
(
    employee_id   bigint auto_increment
        primary key,
    first_name    varchar(30)  not null,
    last_name     varchar(30)  not null,
    department_id bigint       null,
    job_title     varchar(30)  null,
    gender        varchar(30)  not null
);