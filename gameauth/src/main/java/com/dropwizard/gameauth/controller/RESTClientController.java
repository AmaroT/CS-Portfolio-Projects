package com.dropwizard.gameauth.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dropwizard.gameauth.representations.GameUserInfo;
import javax.ws.rs.core.GenericType; // Import the correct GenericType class

@Produces(MediaType.APPLICATION_JSON) // Set default production type as JSON
@Path("/client")
public class RESTClientController {

    private final Client client;

    public RESTClientController(Client client) {
        this.client = client;
    }

    // Method to get all game users
    @GET
    @Path("/gameusers")
    public Response getGameUsers() {
        WebTarget webTarget = client.target("http://localhost:8080/gameusers");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        
        // Read the entity as a List of GameUserInfo objects
        List<GameUserInfo> gameUsers = response.readEntity(new GenericType<List<GameUserInfo>>() {});
        
        // Return the list as a response
        return Response.ok(gameUsers).build();
    }

    // Method to get a single game user by ID
    @GET
    @Path("/gameusers/{id}")
    public Response getGameUserById(@PathParam("id") int id) {
        WebTarget webTarget = client.target("http://localhost:8080/gameusers/" + id);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        
        // Check if the user exists
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            GameUserInfo gameUserInfo = response.readEntity(GameUserInfo.class);
            return Response.ok(gameUserInfo).build();
        } else {
            // If not found, return a 404 status
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Game user with ID " + id + " not found.")
                    .build();
        }
    }
}
