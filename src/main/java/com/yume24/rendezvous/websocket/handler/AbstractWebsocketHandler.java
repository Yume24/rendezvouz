package com.yume24.rendezvous.websocket.handler;

import lombok.Getter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity.AuthorizeExchangeSpec;
import org.springframework.web.reactive.socket.WebSocketHandler;

@Getter
public abstract class AbstractWebsocketHandler implements WebSocketHandler, Customizer<AuthorizeExchangeSpec> {
    private static final String HANDLER_PATH = "/ws";
    private final String path;

    public AbstractWebsocketHandler(String path) {
        this.path = HANDLER_PATH + path;
    }

    @Override
    public void customize(AuthorizeExchangeSpec authorizeExchangeSpec) {
        authorizeExchangeSpec.pathMatchers(path).permitAll();
    }
}
