package com.yume24.rendezvous.groupMembership.controller;

import com.yume24.rendezvous.group.service.GroupService;
import com.yume24.rendezvous.groupMembership.service.GroupMembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
class GroupMembershipController {
    private final GroupMembershipService groupMembershipService;
    private final GroupService groupService;

    @PostMapping("/{groupId}/join")
    Mono<Void> joinGroup(@PathVariable UUID groupId, @AuthenticationPrincipal Jwt jwt) {
        var userId = UUID.fromString(Objects.requireNonNull(jwt.getSubject()));
        return groupService.checkIfGroupExists(groupId).then(
                groupMembershipService.addUserToGroup(userId, groupId)
        );
    }
}
