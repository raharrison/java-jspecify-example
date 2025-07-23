package com.example.myapp;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@NullMarked
public class UserRepo {

    private final List<User> users = List.of(
            new User("1", "alice", "alice@example.com"),
            new User("2", "bob", "bob@example.com"),
            new User("3", "carol", null) // Carol has no email — null is OK here
    );

    /**
     * Returns a user by ID, or null if not found.
     */
    public @Nullable User getUserById(@Nullable String id) {
        for (User user : users) {
            if (user.id().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Returns all users with a non-null email.
     */
    public List<@NonNull User> getUsersWithEmail() {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.email() != null) {
                result.add(user);
            }
        }
        return result;
    }
}
