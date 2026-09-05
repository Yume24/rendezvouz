package com.yume24.rendezvous.groupMembership.controller;

import com.yume24.rendezvous.groupMembership.service.GroupMembershipService;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupMembershipController {
  private final GroupMembershipService groupMembershipService;

  @PostMapping("/{groupId}/join")
  @ResponseStatus(HttpStatus.CREATED)
  Mono<Void> joinGroup(@PathVariable UUID groupId, @AuthenticationPrincipal Jwt jwt) {
    var userId = UUID.fromString(Objects.requireNonNull(jwt.getSubject()));
    return groupMembershipService.addUserToGroup(userId, groupId);
  }

  @DeleteMapping("/{groupId}/leave")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  Mono<Void> leaveGroup(@PathVariable UUID groupId, @AuthenticationPrincipal Jwt jwt) {
    var userId = UUID.fromString(Objects.requireNonNull(jwt.getSubject()));
    return groupMembershipService.removeUserFromGroup(userId, groupId);
  }
}
