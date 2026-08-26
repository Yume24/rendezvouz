package com.yume24.rendezvous.user.converters;

import com.yume24.rendezvous.user.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
@Component
public class RoleToStringConverter implements Converter<Role, String> {
    @Override
    public String convert(Role source) {
        return source.getRole();
    }
}
