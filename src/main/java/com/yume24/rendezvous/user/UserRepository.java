package com.yume24.rendezvous.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface UserRepository extends ReactiveCrudRepository<User, UUID> {
}
