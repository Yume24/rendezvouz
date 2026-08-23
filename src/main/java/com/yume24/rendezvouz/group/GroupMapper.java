package com.yume24.rendezvouz.group;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDTO toDto(Group group);
}
