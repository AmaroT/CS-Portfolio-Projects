package com.dropwizard.gameauth.controller;

import io.dropwizard.auth.Auth;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.dropwizard.gameauth.auth.GameUser;
import com.dropwizard.gameauth.dao.GameUserDB;
import com.dropwizard.gameauth.representations.GameUserInfo;

@Path("/gameusers") // Base path for all gameuser-related operations
@Produces(MediaType.APPLICATION_JSON)
public class GameUserRESTController {

    private final Validator validator;

    public GameUserRESTController(Validator validator) {
        this.validator = validator;
    }

    // Allow all authenticated users to access the list of game users
    @PermitAll
    @GET
    public Response getGameUsers(@Auth GameUser user) {
        return Response.ok(GameUserDB.getGameUsers()).build();
    }

    // Allow users with USER or ADMIN role to access game user info
    @RolesAllowed({"USER", "ADMIN"})
    @GET
    @Path("/{id}")
    public Response getGameUserById(@PathParam("id") Integer id, @Auth GameUser user) {
        // Check if the user has the "ADMIN" role or if they are trying to access their own record
        if (user.getRoles().contains("ADMIN") || id.equals(user.getId())) {
            GameUserInfo gameUserInfo = GameUserDB.getGameUser(id);
            if (gameUserInfo != null) {
                return Response.ok(gameUserInfo).build();
            } else {
                return Response.status(Status.NOT_FOUND).entity("Game user with ID " + id + " not found.").build();
            }
        } else {
            // User is not authorized to access the requested record, return 403 Forbidden
            return Response.status(Status.FORBIDDEN).entity("User not authorized to access this record.").build();
        }
    }

    // Allow only users with ADMIN role to create a new game user
    @RolesAllowed("ADMIN")
    @POST
    public Response createGameUser(GameUserInfo gameUserInfo, @Auth GameUser user) throws URISyntaxException {
        // Validate the GameUserInfo object
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        if (!violations.isEmpty()) {
            ArrayList<String> validationMessages = new ArrayList<>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }

        // Check if the user already exists
        GameUserInfo existingUser = GameUserDB.getGameUser(gameUserInfo.getId());
        if (existingUser != null) {
            return Response.status(Status.CONFLICT).entity("Game user with ID " + gameUserInfo.getId() + " already exists.").build();
        }

        GameUserDB.updateGameUser(gameUserInfo.getId(), gameUserInfo);
        return Response.created(new URI("/gameusers/" + gameUserInfo.getId())).build();
    }

    // Allow only users with ADMIN role to update a game user
    @RolesAllowed("ADMIN")
    @PUT
    @Path("/{id}")
    public Response updateGameUserById(@PathParam("id") Integer id, GameUserInfo gameUserInfo) {
        // Validate the GameUserInfo object
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        if (!violations.isEmpty()) {
            ArrayList<String> validationMessages = new ArrayList<>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }

        GameUserInfo existingUser = GameUserDB.getGameUser(id);
        if (existingUser != null) {
            gameUserInfo.setId(id); // Set the correct ID
            GameUserDB.updateGameUser(id, gameUserInfo);
            return Response.ok(gameUserInfo).build();
        } else {
            return Response.status(Status.NOT_FOUND).entity("Game user with ID " + id + " not found.").build();
        }
    }

    // Allow only users with ADMIN role to delete a game user
    @RolesAllowed("ADMIN")
    @DELETE
    @Path("/{id}")
    public Response removeGameUserById(@PathParam("id") Integer id) {
        GameUserInfo gameUserInfo = GameUserDB.getGameUser(id);
        if (gameUserInfo != null) {
            GameUserDB.removeGameUser(id);
            return Response.ok().entity("Game user with ID " + id + " successfully removed.").build();
        } else {
            return Response.status(Status.NOT_FOUND).entity("Game user with ID " + id + " not found.").build();
        }
    }
}
