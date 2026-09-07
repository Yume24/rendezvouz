package com.yume24.rendezvous.user.converter;

import com.yume24.rendezvous.user.entity.UserType;
import org.jspecify.annotations.NonNull;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@ReadingConverter
@Component
public class StringToUserTypeConverter implements org.springframework.core.convert.converter.Converter<String, UserType> {
  @Override
  public UserType convert(@NonNull String source) {
    return switch (source) {
      case "anonymous" -> UserType.anonymous;
      case "registered" -> UserType.registered;
      default -> throw new IllegalArgumentException("Invalid UserType: " + source);
    };
  }
}
