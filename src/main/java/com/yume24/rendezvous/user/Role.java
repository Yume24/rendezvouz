package com.yume24.rendezvous.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    ANONYMOUS("anonymous"),
    USER("user");

    private final String role;
}
