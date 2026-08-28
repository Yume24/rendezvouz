package com.yume24.rendezvous.security.dtos;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank String username, @NotBlank String password) {
}
