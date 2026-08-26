package com.yume24.rendezvous.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("registered_users")
@Builder
@Getter
@Setter
public class RegisteredUser {
    @Id
    @Column("id")
    private UUID id;
    @Column("username")
    private String username;
    @Column("password")
    private String password;
}
