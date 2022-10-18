drop table if exists answer_seq;
drop table if exists answers;
drop table if exists question_seq;
drop table if exists questions;
drop table if exists tag_seq;
drop table if exists tags;
drop table if exists tags_questions;
drop table if exists user_seq;
drop table if exists users;
drop table if exists users_answers;
drop table if exists users_questions;
create table users
(
    id       bigint not null,
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    role     varchar(255),
    primary key (id)
);
create table tags
(
    id          bigint not null,
    description varchar(255),
    name        varchar(255),
    primary key (id)
);
create table answers
(
    id          bigint not null,
    created     datetime(6),
    description varchar(255),
    question_id bigint,
    primary key (id)
);
create table questions
(
    id              bigint not null,
    description     varchar(255),
    created         datetime(6),
    name            varchar(255),
    question_status varchar(255),
    primary key (id)
);
create table answer_seq
(
    next_val bigint
);
insert into answer_seq
values (1);
create table question_seq
(
    next_val bigint
);
insert into question_seq
values (1);
create table tag_seq
(
    next_val bigint
);
insert into tag_seq
values (1);
create table user_seq
(
    next_val bigint
);
insert into user_seq
values (1);
create table users_answers
(
    user_id   bigint not null,
    answer_id bigint not null
);
create table users_questions
(
    user_id     bigint not null,
    question_id bigint not null
);
create table tags_questions
(
    tag_id      bigint not null,
    question_id bigint not null
);
alter table answers
    add constraint question_fk foreign key (question_id) references questions (id);
alter table users_answers
    add constraint user_fk foreign key (user_id) references users (id),
    add constraint answer_fk foreign key (answer_id) references answers (id);
alter table tags_questions
    add constraint tag_fk foreign key (tag_id) references tags (id),
    add constraint question2_fk foreign key (question_id) references questions (id);
alter table users_questions
    add constraint user2_fk foreign key (user_id) references users (id),
    add constraint question3_fk foreign key (question_id) references questions (id);
