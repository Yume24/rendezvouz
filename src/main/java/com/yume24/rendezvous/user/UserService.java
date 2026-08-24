package com.yume24.rendezvous.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Mono<UserDTO> createAnonymousUser(String username) {
        var anonymousUser = User.builder().username(username).role(User.UserRole.ANONYMOUS).build();
        return userRepository.save(anonymousUser).map(userMapper::toDto);
    }

    public Mono<UserDTO> createUser(String username, String password) {
        var user = User.builder().username(username).password(password).role(User.UserRole.USER).build();
        return userRepository.save(user).map(userMapper::toDto);
    }
}
