package com.yume24.rendezvous.security.controller;

import com.yume24.rendezvous.security.configuration.AuthorizeExchangeCustomizer;
import com.yume24.rendezvous.security.dto.AnonymousLoginDTO;
import com.yume24.rendezvous.security.dto.LoginDTO;
import com.yume24.rendezvous.security.dto.RegisterDTO;
import com.yume24.rendezvous.security.dto.TokensDTO;
import com.yume24.rendezvous.security.service.AuthService;
import com.yume24.rendezvous.user.dto.UserDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthorizeExchangeCustomizer {
    private static final String AUTH_PATH_MATCHER = "/auth/**";
    private final AuthService authService;

    @PostMapping("/login/anonymous")
    Mono<TokensDTO> anonymousLogin(@Valid @RequestBody AnonymousLoginDTO anonymousLoginDTO) {
        return authService.anonymousLogin(anonymousLoginDTO.username());
    }

    @PostMapping("/register")
    Mono<UserDTO> register(@Valid @RequestBody RegisterDTO registerDTO) {
        return authService.register(registerDTO.username(), registerDTO.password());
    }

    @PostMapping("/login")
    Mono<TokensDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO.username(), loginDTO.password());
    }

    @Override
    public Customizer<ServerHttpSecurity.AuthorizeExchangeSpec> getAuthorizeExchangeCustomizer() {
        return ex -> ex.pathMatchers(AUTH_PATH_MATCHER).permitAll();
    }
}
