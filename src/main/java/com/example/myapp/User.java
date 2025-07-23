package com.example.myapp;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public record User(@NonNull String id, @NonNull String username, @Nullable String email) {
}
