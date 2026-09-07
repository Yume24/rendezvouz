package com.yume24.rendezvous.user.entity;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Builder
@Getter
@Setter
public class User {
  @Id
  @Column("id")
  private UUID id;

  @Column("username")
  private String username;

  @Column("password")
  private String password;

  @Column("type")
  private UserType type;

  @Column("created_at")
  private Instant createdAt;
}
