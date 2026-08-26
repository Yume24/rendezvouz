package com.yume24.rendezvous.user;

import com.yume24.rendezvous.user.entities.AnonymousUser;
import com.yume24.rendezvous.user.entities.RegisteredUser;
import com.yume24.rendezvous.user.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserMapper {
    UserDTO toDto(AnonymousUser anonymousUser);

    UserDTO toDto(RegisteredUser user);

    User toEntity(AnonymousUser anonymousUser);

    User toEntity(RegisteredUser registeredUser);
}
