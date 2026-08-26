package com.yume24.rendezvous.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserMapper {
    UserDTO toDto(AnonymousUser anonymousUser);
    UserDTO toDto(RegisteredUser user);
    User toEntity(AnonymousUser anonymousUser);
    User toEntity(RegisteredUser registeredUser);
}
