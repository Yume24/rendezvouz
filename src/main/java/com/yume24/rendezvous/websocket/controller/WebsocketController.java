package com.yume24.rendezvous.websocket.controller;

import com.yume24.rendezvous.websocket.dto.TicketDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebsocketController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TicketDTO> getTicket() {
        return Mono.empty();
    }
}
