package com.yume24.rendezvous.user.service;

import com.yume24.rendezvous.user.dto.UserDTO;
import com.yume24.rendezvous.user.entity.AnonymousUser;
import com.yume24.rendezvous.user.entity.RegisteredUser;
import com.yume24.rendezvous.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserMapper {
    UserDTO toDto(AnonymousUser anonymousUser);

    UserDTO toDto(RegisteredUser user);

    User toEntity(AnonymousUser anonymousUser);

    User toEntity(RegisteredUser registeredUser);
}
