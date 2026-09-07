package com.yume24.rendezvous.user.converter;

import com.yume24.rendezvous.r2dbc.R2dbcConverter;
import com.yume24.rendezvous.user.entity.UserType;
import org.jspecify.annotations.NonNull;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@ReadingConverter
@Component
public class StringToUserTypeConverter implements R2dbcConverter<String, UserType> {
  @Override
  public UserType convert(@NonNull String source) {
    return switch (source) {
      case "anonymous" -> UserType.ANONYMOUS;
      case "registered" -> UserType.REGISTERED;
      default -> throw new IllegalArgumentException("Invalid UserType: " + source);
    };
  }
}
