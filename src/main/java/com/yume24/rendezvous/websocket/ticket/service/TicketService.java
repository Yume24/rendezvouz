package com.yume24.rendezvous.websocket.ticket.service;

import com.yume24.rendezvous.jwt.JwtService;
import com.yume24.rendezvous.websocket.ticket.dto.TicketDTO;
import com.yume24.rendezvous.websocket.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TicketService {
  private final JwtService jwtService;
  private final TicketRepository ticketRepository;

  public Mono<TicketDTO> createTicket(String userId) {
    var jwt = jwtService.createTicketJwt(userId);
    return ticketRepository.saveTicket(userId, jwt).thenReturn(new TicketDTO(jwt));
  }

  public Mono<String> getTicket(String userId) {
    return ticketRepository.getTicket(userId);
  }
}
