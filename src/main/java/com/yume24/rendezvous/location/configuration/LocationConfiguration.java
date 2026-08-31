package com.yume24.rendezvous.location.configuration;

import com.yume24.rendezvous.location.handler.LocationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.result.SimpleHandlerAdapter;

import java.util.Map;

@Configuration
public class LocationConfiguration {
    @Bean
    public HandlerMapping handlerMapping(LocationHandler locationHandler) {
        return new SimpleUrlHandlerMapping(Map.of("/ws", locationHandler), -1);
    }

    @Bean
    public HandlerAdapter handlerAdapter() {
        return new SimpleHandlerAdapter();
    }
}
