package com.yume24.rendezvous.security;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login/anonymous")
    Mono<TokensDTO> anonymousLogin(@Valid @RequestBody AnonymousLoginDTO anonymousLoginDTO) {
        return authService.anonymousLogin(anonymousLoginDTO.username());
    }

    @PostMapping("/register")
    Mono<UserDTO> register(@Valid @RequestBody RegisterDTO registerDTO) {
        return Mono.empty();
    }
}
