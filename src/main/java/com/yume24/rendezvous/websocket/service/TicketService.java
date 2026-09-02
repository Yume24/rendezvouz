package com.yume24.rendezvous.websocket.service;

import com.yume24.rendezvous.websocket.dto.TicketDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class TicketService {
    public Mono<TicketDTO> createTicket(UUID userId) {
        return Mono.just(new TicketDTO(""));
    }
}
