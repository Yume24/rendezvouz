package com.yume24.rendezvous.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
  ANONYMOUS("anonymous"),
  REGISTERED("registered");

  private final String role;
}
