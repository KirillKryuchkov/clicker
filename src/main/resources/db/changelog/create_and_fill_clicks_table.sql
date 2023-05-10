create table if not exists clicks_table
(
    application_name varchar primary key not null,
    clicks_count     bigint              not null default 0
);

insert into clicks_table values ('clicker', 0);