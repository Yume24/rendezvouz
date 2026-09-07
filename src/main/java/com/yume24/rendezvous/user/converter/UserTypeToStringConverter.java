package com.yume24.rendezvous.user.converter;

import com.yume24.rendezvous.user.entity.UserType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
@Component
public class UserTypeToStringConverter implements Converter<UserType, String> {
  @Override
  public String convert(UserType source) {
    return source.name();
  }
}
