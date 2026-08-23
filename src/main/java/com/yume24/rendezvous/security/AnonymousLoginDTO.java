package com.yume24.rendezvous.security;

import jakarta.validation.constraints.NotBlank;

public record AnonymousLoginDTO(@NotBlank String username) {
}
