package com.yume24.rendezvous.group.service;

import com.yume24.rendezvous.group.dto.GroupDTO;
import com.yume24.rendezvous.group.entity.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface GroupMapper {
    GroupDTO toDto(Group group);
}
