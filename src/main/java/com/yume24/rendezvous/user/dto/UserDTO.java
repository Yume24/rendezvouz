package com.yume24.rendezvous.user.dto;

import com.yume24.rendezvous.user.entity.Role;
import java.util.UUID;

public record UserDTO(UUID id, String username, Role role) {}
