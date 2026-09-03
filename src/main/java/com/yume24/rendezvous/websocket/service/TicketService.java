package com.yume24.rendezvous.websocket.service;

import com.yume24.rendezvous.jwt.JwtService;
import com.yume24.rendezvous.websocket.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final JwtService jwtService;

    public Mono<TicketDTO> createTicket(String userId) {
        var jwt = jwtService.createTicketJwt(userId);
        return Mono.empty();
    }
}
