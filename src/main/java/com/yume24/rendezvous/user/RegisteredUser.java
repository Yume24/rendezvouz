package com.yume24.rendezvous.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("registered_users")
@Builder
@Getter
@Setter
public class RegisteredUser {
    @Column("username")
    private String username;
    @Column("password")
    private String password;
}
