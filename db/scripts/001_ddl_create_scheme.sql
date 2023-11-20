create table post_user
(
    id   serial primary key,
    login varchar unique not null,
    password varchar not null,
    user_zone varchar
);

create table type_car
(
    id   serial primary key,
    name varchar not null
);

create table type_car_body
(
    id   serial primary key,
    name varchar not null,
    type_car_id int references type_car(id) not null
);