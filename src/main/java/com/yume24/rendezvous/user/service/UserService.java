package com.yume24.rendezvous.user.service;

import com.yume24.rendezvous.user.dto.UserDTO;
import com.yume24.rendezvous.user.entity.User;
import com.yume24.rendezvous.user.entity.UserType;
import com.yume24.rendezvous.user.exceptions.UserNotFoundException;
import com.yume24.rendezvous.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public Mono<UserDTO> createUser(String username) {
    var user = User.builder().username(username).type(UserType.anonymous).build();
    return userRepository.save(user).map(userMapper::toDto);
  }

  public Mono<UserDTO> createUser(String username, String password) {
    var registeredUser =
        User.builder().username(username).password(password).type(UserType.registered).build();
    return userRepository.save(registeredUser).map(userMapper::toDto);
  }

  public Mono<User> findRegisteredUserByUsername(String username) {
    return userRepository
        .findByUsername(username)
        .switchIfEmpty(Mono.error(new UserNotFoundException(username)));
  }
}
