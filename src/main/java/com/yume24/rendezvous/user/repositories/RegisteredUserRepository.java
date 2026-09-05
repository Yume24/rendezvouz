package com.yume24.rendezvous.user.repositories;

import com.yume24.rendezvous.user.entity.RegisteredUser;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RegisteredUserRepository extends ReactiveCrudRepository<RegisteredUser, UUID> {
  Mono<RegisteredUser> findByUsername(String username);
}
