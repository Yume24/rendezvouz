package com.yume24.rendezvous.security.configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity.AuthorizeExchangeSpec;

public interface AuthorizeExchangeCustomizer {
    Customizer<AuthorizeExchangeSpec> getAuthorizeExchangeCustomizer();
}
