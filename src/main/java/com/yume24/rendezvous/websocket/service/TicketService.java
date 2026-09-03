package com.yume24.rendezvous.websocket.service;

import com.yume24.rendezvous.websocket.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    public Mono<TicketDTO> createTicket(UUID userId) {
        return Mono.just(new TicketDTO(""));
    }
}
