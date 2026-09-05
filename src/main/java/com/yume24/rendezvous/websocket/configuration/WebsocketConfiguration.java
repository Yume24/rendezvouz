package com.yume24.rendezvous.websocket.configuration;

import com.yume24.rendezvous.websocket.handler.AbstractWebsocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class WebsocketConfiguration {
   public static final String WEBSOCKET_PATH = "/ws";

    @Bean
    public HandlerMapping handlerMapping(List<AbstractWebsocketHandler> handlers) {
        var handlerMappingMap = handlers.stream()
                .collect(Collectors.toMap(AbstractWebsocketHandler::getPath, Function.identity()));
        return new SimpleUrlHandlerMapping(handlerMappingMap, -1);
    }
}
