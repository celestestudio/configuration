package com.celeste.configuration.model.provider.registry.type;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@Getter
public enum ReplaceType {

  ALL("ALL", "*"),
  SET("SET"),
  GET("GET");

  @NotNull
  private final List<String> names;

  /**
   * Create a new enum of ReplaceType
   *
   * @param names List of names that can be given to this format
   */
  ReplaceType(@NotNull final String... names) {
    this.names = ImmutableList.copyOf(names);
  }

  /**
   * Gets the replace by their type
   *
   * @param replace String
   * @return ReplaceType
   */
  @NotNull
  public static ReplaceType getReplace(@NotNull final String replace) {
    return Arrays.stream(values())
        .filter(type -> type.getNames().contains(replace.toUpperCase()))
        .findFirst()
        .orElseThrow(() -> new NullPointerException("Invalid replace type: " + replace));
  }

}