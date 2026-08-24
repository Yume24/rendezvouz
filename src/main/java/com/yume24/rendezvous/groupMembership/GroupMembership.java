package com.yume24.rendezvous.groupMembership;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

record GroupMembershipKey(UUID userId, UUID groupId) {
}

@Table("users_groups")
@Getter
@Setter
@AllArgsConstructor
public class GroupMembership {
    @Id
    private GroupMembershipKey id;
}
