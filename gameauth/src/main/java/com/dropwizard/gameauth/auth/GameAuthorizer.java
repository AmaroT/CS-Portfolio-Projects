package com.dropwizard.gameauth.auth;

import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> {
	
    @Override
    public boolean authorize(GameUser user, String role) {
    	
        // Check if the user has the required role
    	if (user != null && user.getRoles() != null) {
    		// Return true if the user's roles contain the specified role
    		return user.getRoles().contains(role);
    	}
    	return false; // Return false if user or roles are full, or role is not found
    }
}