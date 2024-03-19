package com.example.recipico.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserTest {

    @Test
    void testGetId() {
        User user = new User();
        assertNull(user.getId());
    }

    @Test
    void testGetFirstName() {
        User user = new User();
        user.setFirstName("John");
        assertEquals("John", user.getFirstName());
    }

    @Test
    void testGetLastName() {
        User user = new User();
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    void testGetUsername() {
        User user = new User();
        user.setUsername("johndoe");
        assertEquals("johndoe", user.getUsername());
    }

    @Test
    void testGetEmail() {
        User user = new User();
        user.setEmail("john@example.com");
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    void testGetPassword() {
        User user = new User();
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }
}
