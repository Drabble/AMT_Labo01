/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.heig.amt.webapp.model.User;
import com.heig.amt.webapp.services.UserServiceLocal;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import rest.dto.UserDTO;

/**
 *
 * @author antoi
 */
@Stateless	
@Path("/user")	
public class UserResource {
    @EJB	
    UserServiceLocal userService;	

    @Context
    UriInfo uriInfo;

    @GET	
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")	
    public List<UserDTO> getUsers() {	
        List<User> users = userService.findAll();
        return users.stream().map(u -> userToDTO(u)).collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)	
    @Path("/{userId}")	
    public UserDTO getUser(@PathParam("userId") long userId)	{	
        return userToDTO(userService.get(userId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)	
    public long addUser(User user)	{	
        return userService.register(user.getUsername(), user.getPassword());	
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")	
    public void updateUser(@PathParam("userId") long userId, User user) {	
        userService.update(userId, user);	
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")	
    public void deleteUser(@PathParam("userId") long userId) {	
        userService.delete(userId);	
    }
    
    private UserDTO  userToDTO(User user){
        return new UserDTO(user.getUsername());
    }
}