package com.yume24.rendezvous.security.configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;

public interface AuthorizeExchangeCustomizer {
    Customizer<ServerHttpSecurity.AuthorizeExchangeSpec> getAuthorizeExchangeCustomizer();
}
