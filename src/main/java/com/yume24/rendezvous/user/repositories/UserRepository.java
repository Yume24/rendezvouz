package com.yume24.rendezvous.user.repositories;

import com.yume24.rendezvous.user.entity.User;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
  @Query("SELECT u FROM User u WHERE u.username = :username AND u.type = 'registered'")
  Mono<User> findByUsername(@Param("username") String username);
}
