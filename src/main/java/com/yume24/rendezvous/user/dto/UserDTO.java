package com.yume24.rendezvous.user.dto;

import com.yume24.rendezvous.user.entity.UserType;
import java.util.UUID;

public record UserDTO(UUID id, String username, UserType type) {}
