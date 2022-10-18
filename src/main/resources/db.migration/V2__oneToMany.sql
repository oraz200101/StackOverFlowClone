drop table if exists stack_over_flow.users_answers;
drop table if exists stack_over_flow.users_questions;
alter table stack_over_flow.questions
    add column user_id bigint;
alter table stack_over_flow.questions
    add constraint user2_fk foreign key (user_id) references users (id);
alter table stack_over_flow.answers
    add column user_id bigint;
alter table stack_over_flow.answers
    add constraint user3_fk foreign key (user_id) references users (id);