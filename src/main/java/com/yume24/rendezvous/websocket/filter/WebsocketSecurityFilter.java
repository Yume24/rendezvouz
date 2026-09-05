package com.yume24.rendezvous.websocket.filter;

import static com.yume24.rendezvous.websocket.configuration.WebsocketConfiguration.WEBSOCKET_PATH;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WebsocketSecurityFilter implements WebFilter {
  private static final String TICKET_QUERY_PARAM = "ticket";
  private final ReactiveAuthenticationManager authenticationManager;

  @Override
  @NonNull public Mono<Void> filter(@NonNull ServerWebExchange exchange, @NonNull WebFilterChain chain) {
    if (exchange.getRequest().getPath().value().startsWith(WEBSOCKET_PATH)) {
      return exchange
          .getPrincipal()
          .cast(Authentication.class)
          .switchIfEmpty(Mono.defer(() -> authenticate(exchange)))
          .flatMap(
              authentication ->
                  chain
                      .filter(exchange)
                      .contextWrite(
                          ReactiveSecurityContextHolder.withAuthentication(authentication)));
    }

    return chain.filter(exchange);
  }

  private Mono<Authentication> authenticate(ServerWebExchange exchange) {
    var ticket = getTicket(exchange);
    return authenticationManager.authenticate(new BearerTokenAuthenticationToken(ticket));
  }

  private String getTicket(ServerWebExchange exchange) {
    return exchange.getRequest().getQueryParams().getFirst(TICKET_QUERY_PARAM);
  }
}
