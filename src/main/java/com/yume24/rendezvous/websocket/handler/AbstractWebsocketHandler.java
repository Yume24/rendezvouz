package com.yume24.rendezvous.websocket.handler;

import lombok.Getter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity.AuthorizeExchangeSpec;
import org.springframework.web.reactive.socket.WebSocketHandler;

import static com.yume24.rendezvous.websocket.configuration.WebsocketConfiguration.WEBSOCKET_PATH;

@Getter
public abstract class AbstractWebsocketHandler implements WebSocketHandler, Customizer<AuthorizeExchangeSpec> {
    private final String path;

    public AbstractWebsocketHandler(String path) {
        this.path = WEBSOCKET_PATH + path;
    }

    @Override
    public void customize(AuthorizeExchangeSpec authorizeExchangeSpec) {
        authorizeExchangeSpec.pathMatchers(path).permitAll();
    }
}
