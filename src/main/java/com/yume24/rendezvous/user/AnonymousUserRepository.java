package com.yume24.rendezvous.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnonymousUserRepository extends ReactiveCrudRepository<AnoynymousUser, UUID> {
}
