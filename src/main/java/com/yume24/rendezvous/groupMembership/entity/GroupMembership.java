package com.yume24.rendezvous.groupMembership.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("group_membership")
@Getter
@Setter
@AllArgsConstructor
public class GroupMembership {
  @Id private GroupMembershipKey id;

  public GroupMembership(UUID userId, UUID groupId) {
    this.id = new GroupMembershipKey(userId, groupId);
  }
}
