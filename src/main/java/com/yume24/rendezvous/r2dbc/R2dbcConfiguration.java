package com.yume24.rendezvous.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.util.List;

@Configuration
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {
    private final ConnectionFactory connectionFactory;
    private final List<Object> converters;

    public R2dbcConfiguration(ConnectionFactory connectionFactory, List<R2dbcConverter<?, ?>> converters) {
        this.connectionFactory = connectionFactory;
        this.converters = converters.stream().map(Object.class::cast).toList();
    }

    @Override
    @NonNull
    public ConnectionFactory connectionFactory() {
        return connectionFactory;
    }

    @Override
    @NonNull
    protected List<Object> getCustomConverters() {
        return converters;
    }
}
