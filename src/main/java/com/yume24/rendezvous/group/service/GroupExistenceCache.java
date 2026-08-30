package com.yume24.rendezvous.group.service;

import com.yume24.rendezvous.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class GroupExistenceCache {
    private final GroupRepository groupRepository;

    @Cacheable("groupExists")
    public Mono<Boolean> isGroupExists(UUID groupId) {
        return groupRepository.existsById(groupId);
    }
}
