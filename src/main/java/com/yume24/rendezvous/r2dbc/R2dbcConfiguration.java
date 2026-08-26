package com.yume24.rendezvous.r2dbc;

import com.yume24.rendezvous.user.converters.RoleToStringConverter;
import com.yume24.rendezvous.user.converters.StringToRoleConverter;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {
    private final ConnectionFactory connectionFactory;
    private final StringToRoleConverter stringToRoleConverter;
    private final RoleToStringConverter roleToStringConverter;

    @Override
    @NonNull
    public ConnectionFactory connectionFactory() {
        return connectionFactory;
    }

    @Override
    @NonNull
    protected List<Object> getCustomConverters() {
        return List.of(stringToRoleConverter, roleToStringConverter);
    }
}
