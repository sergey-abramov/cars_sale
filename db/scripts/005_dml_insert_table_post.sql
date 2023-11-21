insert into owner(name) values('Ivan Ivanov');

insert into car(name, brand_id, type_car_id, type_engine_id, type_car_body_id)
values('Mers s600', 1, 2, 1, 9);

insert into car_docs(series, number, car_id, owner_id) values('96BM', 256148, 1, 1);

insert into post(description, price, created, car_id, post_user_id)
values('Первое обьявление', 100000, '2023-11-21 15:35', 1, 1);