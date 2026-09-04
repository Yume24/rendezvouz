package com.yume24.rendezvous.websocket.ticket.controller;

import com.yume24.rendezvous.websocket.ticket.dto.TicketDTO;
import com.yume24.rendezvous.websocket.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TicketDTO> getTicket(@AuthenticationPrincipal Jwt jwt) {
        return ticketService.createTicket(jwt.getSubject());
    }
}
