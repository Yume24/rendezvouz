package com.yume24.rendezvous.user.repositories;

import com.yume24.rendezvous.user.entity.AnonymousUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnonymousUserRepository extends ReactiveCrudRepository<AnonymousUser, UUID> {
}
