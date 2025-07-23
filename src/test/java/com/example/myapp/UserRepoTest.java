package com.example.myapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {

    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        userRepo = new UserRepo();
    }

    @Test
    void testGetUserByIdReturnsCorrectUser() {
        // Test for an existing user (Alice)
        User user = userRepo.getUserById("1");
        assertNotNull(user, "User should not be null");
        assertEquals("1", user.id(), "User ID should be 1");
        assertEquals("alice", user.username(), "User name should be 'alice'");

        // Test for a non-existing user (ID: 999)
        User nonExistentUser = userRepo.getUserById("999");
        assertNull(nonExistentUser, "User should be null if not found");
    }

    @Test
    void testGetUsersWithEmailFiltersOutUsersWithNullEmails() {
        // Get all users with non-null emails
        var usersWithEmail = userRepo.getUsersWithEmail();

        // Assert that there are only 2 users (Alice and Bob, Carol has no email)
        assertEquals(2, usersWithEmail.size(), "There should be 2 users with emails");

        // Assert that Carol is not included in the list
        assertFalse(usersWithEmail.stream().anyMatch(user -> "carol".equals(user.username())),
                "Carol should not be in the list with email");
    }
}
