package com.yume24.rendezvous.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Option;
import java.util.List;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.r2dbc.autoconfigure.ConnectionFactoryOptionsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

@Configuration
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {
  private final ConnectionFactory connectionFactory;
  private final List<Object> converters;
  private static final String SCHEMA_OPTION = "schema";
  private static final String SCHEMA_VALUE = "rendezvous";

  public R2dbcConfiguration(
      ConnectionFactory connectionFactory, List<R2dbcConverter<?, ?>> converters) {
    this.connectionFactory = connectionFactory;
    this.converters = converters.stream().map(Object.class::cast).toList();
  }

  @Override
  @NonNull public ConnectionFactory connectionFactory() {
    return connectionFactory;
  }

  @Bean
  public ConnectionFactoryOptionsBuilderCustomizer connectionFactoryOptionsBuilderCustomizer() {
    return builder -> builder.option(Option.valueOf(SCHEMA_OPTION), SCHEMA_VALUE);
  }

  @Override
  @NonNull protected List<Object> getCustomConverters() {
    return converters;
  }
}
