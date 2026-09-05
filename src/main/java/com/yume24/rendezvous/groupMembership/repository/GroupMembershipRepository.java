package com.yume24.rendezvous.groupMembership.repository;

import com.yume24.rendezvous.groupMembership.entity.GroupMembership;
import com.yume24.rendezvous.groupMembership.entity.GroupMembershipKey;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMembershipRepository
    extends ReactiveCrudRepository<GroupMembership, GroupMembershipKey> {}
