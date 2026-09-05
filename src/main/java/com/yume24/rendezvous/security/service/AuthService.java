package com.yume24.rendezvous.security.service;

import com.yume24.rendezvous.jwt.JwtService;
import com.yume24.rendezvous.security.dto.TokensDTO;
import com.yume24.rendezvous.security.exceptions.IncorrectCredentialsException;
import com.yume24.rendezvous.user.dto.UserDTO;
import com.yume24.rendezvous.user.entity.RegisteredUser;
import com.yume24.rendezvous.user.service.UserService;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserService userService;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;

  public Mono<TokensDTO> anonymousLogin(String username) {
    return userService
        .createAnonymousUser(username)
        .map(
            user ->
                jwtService.createAccessJwt(user.id().toString(), Optional.of(Set.of(user.role()))))
        .map(TokensDTO::new);
  }

  public Mono<UserDTO> register(String username, String password) {
    var encryptedPassword = passwordEncoder.encode(password);

    return userService.createUser(username, encryptedPassword);
  }

  public Mono<TokensDTO> login(String username, String password) {
    return userService
        .findRegisteredUserByUsername(username)
        .flatMap(
            user -> {
              if (passwordEncoder.matches(password, user.getPassword())) {
                var jwt =
                    jwtService.createAccessJwt(
                        user.getId().toString(), Optional.of(Set.of(RegisteredUser.DEFAULT_ROLE)));
                return Mono.just(new TokensDTO(jwt));
              }
              return Mono.error(new IncorrectCredentialsException());
            });
  }
}
