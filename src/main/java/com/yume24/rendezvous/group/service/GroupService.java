package com.yume24.rendezvous.group.service;

import com.yume24.rendezvous.group.dto.GroupDTO;
import com.yume24.rendezvous.group.entity.Group;
import com.yume24.rendezvous.group.exception.GroupDoesNotExistsException;
import com.yume24.rendezvous.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public Mono<GroupDTO> createGroup(String name, UUID createdBy) {
        var group = Group.builder().name(name).createdBy(createdBy).build();
        return groupRepository.save(group).map(groupMapper::toDto);
    }

    public Mono<Void> checkIfGroupExists(UUID groupID) {
        return groupRepository
                .existsById(groupID)
                .handle((exists, sink) -> {
                    if (exists) {
                        sink.complete();
                    } else {
                        sink.error(new GroupDoesNotExistsException(groupID.toString()));
                    }
                });
    }
}
