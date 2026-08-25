package com.yume24.rendezvous.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("anonymous_users")
@Getter
@Setter
@Builder
public final class AnoynymousUser extends User {
    @Column("username")
    private String username;
}
