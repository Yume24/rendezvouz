package com.yume24.rendezvous.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(AnoynymousUser anoynymousUser);
    UserDTO toDto(RegisteredUser user);
}
