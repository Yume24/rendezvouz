package com.yume24.rendezvous.user.repositories;

import com.yume24.rendezvous.user.entities.RegisteredUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegisteredUserRepository extends ReactiveCrudRepository<RegisteredUser, UUID> {
}
