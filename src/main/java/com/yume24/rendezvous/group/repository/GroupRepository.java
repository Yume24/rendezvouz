package com.yume24.rendezvous.group.repository;

import com.yume24.rendezvous.group.entity.Group;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends ReactiveCrudRepository<Group, UUID> {}
