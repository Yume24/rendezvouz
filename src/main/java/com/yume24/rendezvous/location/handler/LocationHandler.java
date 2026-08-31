package com.yume24.rendezvous.location.handler;

import com.yume24.rendezvous.websocket.handler.AbstractWebsocketHandler;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class LocationHandler extends AbstractWebsocketHandler {
    private static final String PATH = "/location";

    public LocationHandler() {
        super(PATH);
    }
    @Override
    @NonNull
    public Mono<Void> handle(@NonNull WebSocketSession session) {
        return session.send(Flux.interval(Duration.ofSeconds(1)).map(i -> session.textMessage(String.valueOf(i))));
    }
}
