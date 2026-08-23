CREATE TABLE IF NOT EXISTS users
(
    id         UUID PRIMARY KEY      DEFAULT uuidv7(),
    username   VARCHAR(255) NOT NULL,
    role       VARCHAR(50)  NOT NULL
        CHECK (role IN ('ROLE_USER', 'ROLE_ANONYMOUS')),
    created_at TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS groups
(
    id         UUID PRIMARY KEY      DEFAULT uuidv7(),
    name       VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID         NOT NULL REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS group_membership
(
    group_id UUID NOT NULL REFERENCES groups (id) ON DELETE CASCADE,
    user_id  UUID NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    PRIMARY KEY (group_id, user_id)
);