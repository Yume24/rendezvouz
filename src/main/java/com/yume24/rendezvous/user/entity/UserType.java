package com.yume24.rendezvous.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserType {
  ANONYMOUS("anonymous"),
  REGISTERED("registered");

  private final String type;

  @Override
  public String toString() {
    return type;
  }
}
