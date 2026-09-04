package com.yume24.rendezvous.websocket.ticket.repository;

import com.yume24.rendezvous.redis.RedisConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class TicketRepository {
    private static final String TICKET_KEY_PREFIX = "ticket:";
    private final ReactiveRedisOperations<String, String> redisTemplate;
    @Value("${jwt.expiry.ticket}")
    private long ticketExpirationDuration;

    public Mono<Void> saveTicket(String userId, String ticket) {
        return redisTemplate.opsForValue().set(getKey(userId), ticket, Duration.ofSeconds(ticketExpirationDuration)).then();
    }

    public Mono<String> getTicket(String userId) {
        return redisTemplate.opsForValue().get(getKey(userId));
    }

    private String getKey(String userId) {
        return TICKET_KEY_PREFIX + RedisConfiguration.KEY_DELIMITER + userId;
    }
}
