package com.yume24.rendezvous.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Table("users")
@Builder
@Getter
@Setter
class User {
    @Id
    @Column("id")
    protected UUID id;
    @Column("created_at")
    protected Instant createdAt;
}
