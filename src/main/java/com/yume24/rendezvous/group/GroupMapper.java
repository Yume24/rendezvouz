package com.yume24.rendezvous.group;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDTO toDto(Group group);
}
