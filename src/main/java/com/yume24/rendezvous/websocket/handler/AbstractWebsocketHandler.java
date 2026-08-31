package com.yume24.rendezvous.websocket.handler;

import lombok.Getter;
import org.springframework.web.reactive.socket.WebSocketHandler;

@Getter
public abstract class AbstractWebsocketHandler implements WebSocketHandler {
    private static final String HANDLER_PATH = "/ws";
    private final String path;

    public AbstractWebsocketHandler(String path) {
        this.path = HANDLER_PATH + path;
    }
}
