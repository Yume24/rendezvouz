package com.yume24.rendezvous.security.dtos;

import jakarta.validation.constraints.NotBlank;

public record AnonymousLoginDTO(@NotBlank String username) {
}
