package com.example.tech11;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/maintain")
public class HelloResource {


    @GET
    @Path("/read/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String readEntity(@PathParam("id") int id) {         //method to read entity from database with "/read/{id}"

        String ret;
        User u = UserDatabase.findUser(id);

        if (u != null) {            //check if a valid id was used
            ret = u.toString();
        } else {
            ret = "The Id " + id + " can't be found in the database.";
        }
        return ret;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User user) {         //when creating user, no id is set, it's created automatically

        if (user.id != 0) {                     //check that the User didn't set their own id
            throw new IllegalArgumentException("Do NOT set an ID when creating a User");
        } else {
            UserDatabase.addUser(user);
        }
        return user;
    }

    @PUT
    @Path("/alter")
    @Consumes(MediaType.APPLICATION_JSON)
    public String alterUser(User user) {        //alter a existing entity

        String ret;
        User existingUser = UserDatabase.findUser(user.getId());        //check if id exists
        if (existingUser != null) {
            UserDatabase.replaceUser(existingUser, user);
            ret = existingUser.toString();
        } else {
            ret = "The ID " + user.getId() + " can't be found in the database.";
        }


        return ret;
    }

}