package com.yume24.rendezvous.jwt;

import com.yume24.rendezvous.user.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

import static com.yume24.rendezvous.jwt.JwtConfiguration.ROLE_CLAIM;
import static com.yume24.rendezvous.jwt.JwtConfiguration.ROLE_PREFIX;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtEncoder jwtEncoder;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiry.access}")
    private long accessExpiry;
    @Value("${jwt.expiry.ticket}")
    private long ticketExpiry;

    private String createJwt(String subject, Optional<Collection<Role>> roles, long expiry) {
        var now = Instant.now();
        var claimsSet = JwtClaimsSet.builder().
                subject(subject)
                .issuer(issuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry));
        roles.ifPresent(r -> claimsSet.claim(ROLE_CLAIM, r.stream().map(role -> ROLE_PREFIX + role.name()).toList()));
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet.build())).getTokenValue();
    }

    public String createAccessJwt(String subject, Optional<Collection<Role>> roles) {
        return createJwt(subject, roles, accessExpiry);
    }

    public String createTicketJwt(String subject) {
        return createJwt(subject, Optional.empty(), ticketExpiry);
    }
}
