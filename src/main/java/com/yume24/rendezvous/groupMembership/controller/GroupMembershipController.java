package com.yume24.rendezvous.groupMembership.controller;

import com.yume24.rendezvous.groupMembership.service.GroupMembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
class GroupMembershipController {
    private final GroupMembershipService groupMembershipService;

    @PostMapping("/{groupId}/join")
    Mono<Void> joinGroup(@PathVariable UUID groupId, @AuthenticationPrincipal Jwt jwt) {
        var userId = UUID.fromString(Objects.requireNonNull(jwt.getSubject()));
        return groupMembershipService.addUserToGroup(userId, groupId);
    }

    @DeleteMapping("/{groupId}/leave")
    Mono<Void> leaveGroup(@PathVariable UUID groupId, @AuthenticationPrincipal Jwt jwt) {
        var userId = UUID.fromString(Objects.requireNonNull(jwt.getSubject()));
        return groupMembershipService.removeUserFromGroup(userId, groupId);
    }
}
