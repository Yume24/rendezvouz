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

import static com.yume24.rendezvous.jwt.JwtConfiguration.ROLE_CLAIM;
import static com.yume24.rendezvous.jwt.JwtConfiguration.ROLE_PREFIX;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtEncoder jwtEncoder;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiry.access}")
    private long expiry;

    public String createJwt(String subject, Collection<Role> roles) {
        var now = Instant.now();
        var claimsSet = JwtClaimsSet.builder().
                subject(subject)
                .issuer(issuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .claim(ROLE_CLAIM, roles.stream().map(role -> ROLE_PREFIX + role.name()).toList())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
}
