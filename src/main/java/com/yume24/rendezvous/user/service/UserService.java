package com.yume24.rendezvous.user.service;

import com.yume24.rendezvous.user.dto.UserDTO;
import com.yume24.rendezvous.user.entity.AnonymousUser;
import com.yume24.rendezvous.user.entity.RegisteredUser;
import com.yume24.rendezvous.user.exceptions.UserNotFoundException;
import com.yume24.rendezvous.user.repositories.AnonymousUserRepository;
import com.yume24.rendezvous.user.repositories.RegisteredUserRepository;
import com.yume24.rendezvous.user.repositories.UserRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
  private final UserRepository userRepository;
  private final AnonymousUserRepository anonymousUserRepository;
  private final RegisteredUserRepository registeredUserRepository;
  private final UserMapper userMapper;

  public Mono<UserDTO> createAnonymousUser(String username) {
    var anonymousUser = AnonymousUser.builder().username(username).build();
    var user = userMapper.toEntity(anonymousUser);
    return userRepository
        .save(user)
        .then(anonymousUserRepository.save(anonymousUser).map(userMapper::toDto));
  }

  public Mono<UserDTO> createUser(String username, String password) {
    var registeredUser = RegisteredUser.builder().username(username).password(password).build();
    var user = userMapper.toEntity(registeredUser);
    return userRepository
        .save(user)
        .then(registeredUserRepository.save(registeredUser).map(userMapper::toDto));
  }

  public Mono<RegisteredUser> findRegisteredUserByUsername(String username) {
    return registeredUserRepository
        .findByUsername(username)
        .switchIfEmpty(Mono.error(new UserNotFoundException(username)));
  }

  public Mono<AnonymousUser> getAnonymousUser(UUID id) {
    return anonymousUserRepository.findById(id);
  }
}
