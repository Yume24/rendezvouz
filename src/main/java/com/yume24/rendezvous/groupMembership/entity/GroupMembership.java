package com.yume24.rendezvous.groupMembership.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("users_groups")
@Getter
@Setter
@AllArgsConstructor
public class GroupMembership {
    @Id
    private GroupMembershipKey id;

    public GroupMembership(UUID userId, UUID groupId) {
        this.id = new GroupMembershipKey(userId, groupId);
    }
}
