package com.yume24.rendezvous.security.dto;

import jakarta.validation.constraints.NotBlank;

public record AnonymousLoginDTO(@NotBlank String username) {
}
