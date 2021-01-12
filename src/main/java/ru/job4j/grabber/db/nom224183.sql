create table meeting (
                         id int primary key,
                         name varchar(255)
);

create table users (
                       id int primary key,
                       name varchar(255)
);

create table crosstable (
                            id serial primary key,
                            id_user int references users(id),
                            id_event int references meeting(id),
                            agreement boolean
);

insert into meeting values (1, 'meet1'), (2, 'meet2'), (3, 'meet3');

insert into users values (1, 'AA'), (2, 'BB'), (3, 'cc'), (4, 'dd');

insert into crosstable (id_user, id_event, agreement) VALUES (1,1,true),
                         (1,2,true), (2,2,true), (3,2,true), (4,1,false);

-- 2. Нужно написать запрос, который получит список всех заявок и количество подтвердивших участников.
select m.name as meeting_name, count(c.id_event) as agreements_count
from meeting m left outer join crosstable c on m.id = c.id_event and c.agreement
group by m.id;


--3. Нужно получить все совещания, где не было ни одной заявки на посещения
select m.name as meeting_name
from meeting m left outer join crosstable c on m.id = c.id_event and c.agreement
where c.id_event is null or c.agreement is false;

-- или другой вариант п.3.
select m.name as meeting_name, count(c.id_event) as agreements_count
from meeting m left outer join crosstable c on m.id = c.id_event and c.agreement
group by m.id having count(c.id_event) = 0;