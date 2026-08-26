package com.yume24.rendezvous.security;

import com.yume24.rendezvous.jwt.JwtService;
import com.yume24.rendezvous.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;

    public Mono<TokensDTO> anonymousLogin(String username) {
        return userService.createAnonymousUser(username)
                .map(user -> jwtService.createJwt(user.id().toString(), Set.of(user.role())))
                .map(TokensDTO::new);
    }
}
