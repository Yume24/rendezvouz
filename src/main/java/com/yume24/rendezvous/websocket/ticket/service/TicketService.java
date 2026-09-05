package com.yume24.rendezvous.websocket.ticket.service;

import com.yume24.rendezvous.jwt.JwtService;
import com.yume24.rendezvous.websocket.ticket.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
  private final JwtService jwtService;

  public TicketDTO createTicket(String userId) {
    var jwt = jwtService.createTicketJwt(userId);
    return new TicketDTO(jwt);
  }
}
