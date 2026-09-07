package com.yume24.rendezvous.user.converter;

import com.yume24.rendezvous.r2dbc.R2dbcConverter;
import com.yume24.rendezvous.user.entity.Role;
import com.yume24.rendezvous.user.entity.UserType;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
@Component
public class UserTypeToStringConverter implements R2dbcConverter<UserType, String> {
  @Override
  public String convert(UserType source) {
    return source.name();
  }
}
