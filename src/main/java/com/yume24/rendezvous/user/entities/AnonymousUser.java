package com.yume24.rendezvous.user.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("anonymous_users")
@Getter
@Setter
@Builder
public class AnonymousUser {
    @Id
    @Column("id")
    private UUID id;
    @Column("username")
    private String username;
}
