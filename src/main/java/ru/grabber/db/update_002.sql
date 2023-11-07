CREATE TABLE if not exists post(
    id serial primary key,
    name varchar,
    text varchar,
    link varchar unique,
    created timestamp
);