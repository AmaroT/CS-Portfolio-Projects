package com.dropwizard.gameauth.auth;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> {

    // A map of valid users and their roles
    private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );

    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException {
        // Check if the username exists and the password matches (for simplicity, hard-coded password is used here)
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword())) {
            // Get the roles associated with the username
            Set<String> roles = VALID_USERS.get(credentials.getUsername());
            // Create a new GameUser with the username and roles (handling potential null roles)
            GameUser user = new GameUser(credentials.getUsername(), roles != null ? roles : ImmutableSet.of());
            // Return the authenticated user wrapped in Optional
            return Optional.of(user);
        }
        // If authentication fails, return an empty Optional
        return Optional.empty();
    }
}
