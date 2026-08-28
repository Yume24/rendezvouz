package com.yume24.rendezvous.user.converters;

import com.yume24.rendezvous.r2dbc.R2dbcConverter;
import com.yume24.rendezvous.user.Role;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
@Component
public class RoleToStringConverter implements R2dbcConverter<Role, String> {
    @Override
    public String convert(Role source) {
        return source.getRole();
    }
}
