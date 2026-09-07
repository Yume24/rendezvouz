package com.yume24.rendezvous.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {
  ANONYMOUS("anonymous"),
  REGISTERED("registered");

  private final String type;
}
