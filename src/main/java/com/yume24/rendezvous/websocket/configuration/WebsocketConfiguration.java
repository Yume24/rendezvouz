package com.yume24.rendezvous.websocket.configuration;

import com.yume24.rendezvous.websocket.handler.AbstractWebsocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.result.SimpleHandlerAdapter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class WebsocketConfiguration {

    @Bean
    public HandlerAdapter handlerAdapter() {
        return new SimpleHandlerAdapter();
    }

    @Bean
    public HandlerMapping handlerMapping(List<AbstractWebsocketHandler> handlers) {
        var handlerMappingMap = handlers.stream()
                .collect(Collectors.toMap(AbstractWebsocketHandler::getPath, Function.identity()));
        return new SimpleUrlHandlerMapping(handlerMappingMap, -1);
    }
}
