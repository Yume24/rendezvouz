package com.yume24.rendezvous.user.repositories;

import com.yume24.rendezvous.user.entity.AnonymousUser;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonymousUserRepository extends ReactiveCrudRepository<AnonymousUser, UUID> {}
