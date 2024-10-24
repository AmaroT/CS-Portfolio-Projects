package com.dropwizard.gameauth.auth;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;
 
public class GameUser implements Principal {
    private String name = "";
    private final Set<String> roles;

    // Constructor that assigns a default empty set of roles if not provided
    public GameUser(String name) {
        this(name, Collections.emptySet());
    }

    // Constructor that ensures roles is not null
    public GameUser(String name, Set<String> roles) {
        // Corrected: Use assignment operator instead of ?:
        this.name = name;
        this.roles = roles != null ? roles : Collections.emptySet();
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return (int) (Math.random() * 100);
    }

    public Set<String> getRoles() {
        return roles;
    }
}
