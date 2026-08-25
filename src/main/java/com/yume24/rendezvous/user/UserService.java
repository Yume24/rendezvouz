package com.yume24.rendezvous.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AnonymousUserRepository anonymousUserRepository;
    private final RegisteredUserRepository registeredUserRepository;
    private final UserMapper userMapper;

    @Transactional
    public Mono<UserDTO> createAnonymousUser(String username) {
        var anonymousUser = AnoynymousUser.builder().username(username).build();
        return userRepository.save(anonymousUser).map(userMapper::toDto);
    }

    @Transactional
    public Mono<UserDTO> createUser(String username, String password) {
        var user = User.builder().username(username).password(password).role(User.UserRole.USER).build();
        return userRepository.save(user).map(userMapper::toDto);
    }
}
