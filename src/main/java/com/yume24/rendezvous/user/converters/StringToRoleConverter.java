package com.yume24.rendezvous.user.converters;

import com.yume24.rendezvous.user.Role;
import org.jspecify.annotations.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@ReadingConverter
@Component
public class StringToRoleConverter implements Converter<String, Role> {
    @Override
    public Role convert(@NonNull String source) {
        return Role.valueOf(source);
    }
}
