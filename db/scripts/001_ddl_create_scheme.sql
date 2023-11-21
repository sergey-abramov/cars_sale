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

create table type_engine
(
    id   serial primary key,
    name varchar not null
);

create table brand
(
    id   serial primary key,
    name varchar not null
);

create table car
(
    id   serial primary key,
    name varchar not null,
    brand_id int references brand(id) not null,
    type_car_id int references type_car(id) not null,
    type_engine_id int references type_engine(id) not null
);

create table owner
(
    id   serial primary key,
    name varchar not null
);

create table car_docs
(
    id   serial primary key,
    series varchar not null,
    number int not null,
    car_id int references car(id) not null,
    owner_id int references owner(id) not null
);

create table post_history
(
    id   serial primary key
);

create table post
(
    id   serial primary key,
    description varchar not null,
    price int not null,
    created timestamp not null,
    sell boolean default false,
    car_id int references car(id) not null,
    post_user_id int references post_user(id) not null,
    post_history_id int references post_history(id)
);

create table file
(
    id   serial primary key,
    name varchar not null,
    path varchar not null,
    post_id int references post(id) not null
);