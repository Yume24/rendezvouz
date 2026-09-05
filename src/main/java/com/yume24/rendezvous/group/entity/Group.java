package com.yume24.rendezvous.group.entity;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("groups")
@Builder
@Getter
@Setter
public class Group {
  @Id private UUID ID;

  @Column("name")
  private String name;

  @Column("created_at")
  private Instant createdAt;

  @Column("created_by")
  private UUID createdBy;
}
