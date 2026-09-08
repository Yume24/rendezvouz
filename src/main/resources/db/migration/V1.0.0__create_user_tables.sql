-- create type user_type as enum ('registered', 'anonymous');

create table users (
    id uuid primary key default uuidv7(),
    username varchar(255) not null,
    password char(60),
    type varchar(63) not null,
    created_at timestamptz not null default now(),
    constraint chk_anonymous_user_no_pswd check (type != 'anonymous' or password is null),
    constraint chk_registered_user_has_pswd check(type != 'registered' or password is not null)
);

create unique index on users(username) where type = 'registered';