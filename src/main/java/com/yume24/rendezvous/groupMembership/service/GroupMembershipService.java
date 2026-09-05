package com.yume24.rendezvous.groupMembership.service;

import com.yume24.rendezvous.group.service.GroupService;
import com.yume24.rendezvous.groupMembership.entity.GroupMembership;
import com.yume24.rendezvous.groupMembership.entity.GroupMembershipKey;
import com.yume24.rendezvous.groupMembership.exception.UserAlreadyInGroupException;
import com.yume24.rendezvous.groupMembership.repository.GroupMembershipRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GroupMembershipService {
  private final GroupMembershipRepository groupMembershipRepository;
  private final GroupService groupService;

  public Mono<Void> addUserToGroup(UUID userId, UUID groupId) {
    return groupService
        .checkIfGroupExists(groupId)
        .then(checkUserInGroup(userId, groupId))
        .then(groupMembershipRepository.save(new GroupMembership(userId, groupId)))
        .then();
  }

  public Mono<Void> checkUserInGroup(UUID userId, UUID groupId) {
    var key = new GroupMembershipKey(userId, groupId);
    return groupMembershipRepository
        .existsById(key)
        .handle(
            (exists, sink) -> {
              if (exists) sink.error(new UserAlreadyInGroupException(key.toString()));
              else sink.complete();
            });
  }

  public Mono<Void> removeUserFromGroup(UUID userId, UUID groupId) {
    var key = new GroupMembershipKey(userId, groupId);
    return groupMembershipRepository.deleteById(key);
  }
}
