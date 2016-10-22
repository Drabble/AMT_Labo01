/*
 * File             : UserResource.java
 * Authors          : Antoine Drabble & Guillaume Serneels
 * Last Modified    : 21.10.2016
 */
package com.heig.amt.webapp.rest;

import com.heig.amt.webapp.model.User;
import com.heig.amt.webapp.rest.dto.ErrorDTO;
import com.heig.amt.webapp.services.UserServiceLocal;
import com.heig.amt.webapp.web.LoginServlet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.heig.amt.webapp.rest.dto.UserDTO;
import com.heig.amt.webapp.rest.dto.UserLoginDTO;
import com.heig.amt.webapp.rest.dto.ErrorDTO;
import javax.ejb.DuplicateKeyException;

/**
 *
 * @author antoi
 */
@Stateless
@Path("/users")
public class UserResource {

    @EJB
    UserServiceLocal userService;

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        try {
            List<User> users = userService.findAll();
            return Response.ok(users.stream().map(u -> userToDTO(u)).collect(Collectors.toList()), MediaType.APPLICATION_JSON).build();
        }  catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO("Internal server error")).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") long userId) {
        try {
            return Response.ok(userToDTO(userService.get(userId)), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            // If we throwed an illegal argument exception retrieve message
            if (e.getCause() != null && e.getCause().getCause().getClass().getSimpleName().equals("IllegalArgumentException")) {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorDTO(e.getCause().getCause().getMessage())).build();
            }
            // Otherwise send internal server error message
            else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO("Internal server error!")).build();
            }

            
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(UserLoginDTO user) {
        try {
            userService.create(user.getUsername(), user.getPassword(), user.getEmail(), user.getFirstname(), user.getLastname());
            return Response.status(Response.Status.CREATED).build();
        }  catch(DuplicateKeyException e){
            return Response.status(Response.Status.CONFLICT).entity(new ErrorDTO(e.getMessage())).build();
        }catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            if(e.getCause() != null && e.getCause().getCause().getClass().getSimpleName().equals(IllegalArgumentException.class.getSimpleName())){
                return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorDTO(e.getCause().getCause().getMessage())).build();
            }
            // Otherwise send internal server error message
            else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO("Internal server error!")).build();
            }
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") long userId, UserLoginDTO user) {
        try {
            if (userService.update(userId, UserLoginDTOToUser(user))) {
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            // If we throwed an illegal argument exception retrieve message
            if (e.getCause() != null && e.getCause().getClass().getSimpleName().equals("IllegalArgumentException")) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            // Otherwise send internal server error message
            else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") long userId) {
        try {
            if (userService.delete(userId)) {
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            // If we throwed an illegal argument exception retrieve message
            if (e.getCause() != null && e.getCause().getClass().getSimpleName().equals("IllegalArgumentException")) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            // Otherwise send internal server error message
            else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }
    }

    private UserDTO userToDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(), 
                user.getFirstname(), user.getLastname());
    }

    private User UserLoginDTOToUser(UserLoginDTO userLoginDTO) {
        return new User(userLoginDTO.getUsername(), userLoginDTO.getPassword(), 
                userLoginDTO.getEmail(), userLoginDTO.getFirstname(), 
                userLoginDTO.getLastname());
    }
}
