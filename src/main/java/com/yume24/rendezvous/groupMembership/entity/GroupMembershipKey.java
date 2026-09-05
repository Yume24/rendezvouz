package com.yume24.rendezvous.groupMembership.entity;

import java.util.UUID;

public record GroupMembershipKey(UUID userId, UUID groupId) {}
