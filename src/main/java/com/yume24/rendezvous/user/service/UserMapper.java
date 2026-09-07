package com.yume24.rendezvous.user.service;

import com.yume24.rendezvous.user.dto.UserDTO;
import com.yume24.rendezvous.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserMapper {
  UserDTO toDto(User user);

  User toEntity(UserDTO userDTO);
}
