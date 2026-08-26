package com.yume24.rendezvous.user;

import com.yume24.rendezvous.user.entities.AnonymousUser;
import com.yume24.rendezvous.user.entities.RegisteredUser;
import com.yume24.rendezvous.user.repositories.AnonymousUserRepository;
import com.yume24.rendezvous.user.repositories.RegisteredUserRepository;
import com.yume24.rendezvous.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

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
                .then(anonymousUserRepository.
                        save(anonymousUser)
                        .map(userMapper::toDto));
    }

    public Mono<UserDTO> createUser(String username, String password) {
        var registeredUser = RegisteredUser.builder().username(username).password(password).build();
        var user = userMapper.toEntity(registeredUser);
        return userRepository
                .save(user)
                .then(registeredUserRepository
                        .save(registeredUser)
                        .map(userMapper::toDto));
    }

    public Mono<RegisteredUser> getRegisteredUser(UUID id) {
        return registeredUserRepository.findById(id);
    }

    public Mono<AnonymousUser> getAnonymousUser(UUID id) {
        return anonymousUserRepository.findById(id);
    }
}
