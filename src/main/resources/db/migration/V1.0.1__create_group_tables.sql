create table groups (
    id uuid primary key default uuidv7(),
    name varchar(255),
    created_at timestamptz not null default now(),
    created_by uuid not null references users(id)
);

create table group_membership (
    user_id uuid not null references users(id),
    group_id uuid not null references groups(id),
    primary key (user_id, group_id)
);