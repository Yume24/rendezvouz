create type user_role as enum ('registered', 'anonymous');

create table users (
    id uuid primary key default uuidv7(),
    created_at timestamptz default now() not null,
    role user_role not null
);

create table anonymous_users (
    id uuid references users(id) not null,
    username varchar(63) not null
);

create table registered_users (
    id uuid references users(id) not null,
    username varchar(63) unique not null,
    password varchar(60) not null
);