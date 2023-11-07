create database grabber;
create table if not exists post(
                                   id serial primary key,
                                   name varchar(2000),
                                   text text,
                                   link varchar(2000) unique check ( link != ''),
                                   created date
);