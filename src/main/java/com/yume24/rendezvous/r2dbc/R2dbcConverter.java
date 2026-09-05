package com.yume24.rendezvous.r2dbc;

import org.jspecify.annotations.Nullable;
import org.springframework.core.convert.converter.Converter;

public interface R2dbcConverter<S, T extends @Nullable Object> extends Converter<S, T> {}
