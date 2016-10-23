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
import com.heig.amt.webapp.rest.dto.UserIdDTO;
import javax.ejb.DuplicateKeyException;

/**
 * This class regroups the business logic of our JAX-RS REST API. It allows the 
 * web service to manage users by performing CRUD actions when recieving GET, 
 * POST, PUT and DELETE HTTP Requests.
 * The @Stateless, @EJB and @Context  specifies this class as a managed compnent 
 * and allows the dependency injection of the userService EJB.
 * The @Path specifies each of the individual path used after the root path 
 * "/api"to achieve the CRUD operations
 * The @Consumes and @Produces annotations specify the type of data used, in our
 * case it's JSON
 * 
 * @author Antoine Drabble antoine.drabble@heig-vd.ch
 * @author Guillaume Serneels guillaume.serneels@heig-vd.ch
 */
@Stateless
@Path("/users")
public class UserResource {

    @EJB
    UserServiceLocal userService;

    @Context
    UriInfo uriInfo;
    /**
     * This method returns the list of every users when an HTTP GET request is 
     * sent on the "/api/users" url
     * @return a Response object containing the list of users 
     */
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
    /**
     * This methods returns a specific user when an HTTP GET request is 
     * sent on the "/api/users/{userId}" url
     * @param userId the id of the user to return
     * @return a Response containing the User in the form of a Data transfer 
     * object UserDTO
     */
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
    /**
     * This methods creates a new User  when an HTTP POST request is 
     * sent on the "/api/users" url
     * @param user the user in the form of a Data Transfer Object UserLoginDTO
     * @return A response with status code CREATED  and the user's ID in a DTO 
     * if everithing went well or with status code CONFLICT otherwise
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(UserLoginDTO user) {
        try {
            long id = userService.create(user.getUsername(), user.getPassword(), user.getEmail(), user.getFirstname(), user.getLastname());
            return Response.status(Response.Status.CREATED).entity(new UserIdDTO(id)).build();
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
    /**
     * This methods allows the web service to update an existing User when an 
     * HTTP PUT request is sent on the "/api/users" url
     * @param userId the id of the user to update
     * @param user the user in the form of a Data Transfer Object UserLoginDTO
     * @return A response with status code OK and the user's ID in a DTO if 
     * everithing went well or with status code NOT_FOUND, CONFLICT, 
     * SEVERE, BAD_REQUEST or INTERNAT_SERVER_ERROR otherwise
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") long userId, UserLoginDTO user) {
        try {
            if (userService.update(userId, UserLoginDTOToUser(user))) {
                return Response.status(Response.Status.OK).entity(new UserIdDTO(userId)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorDTO("User not found!")).build();
            }
        } catch(DuplicateKeyException e){
            return Response.status(Response.Status.CONFLICT).entity(new ErrorDTO(e.getMessage())).build();
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            // If we throwed an illegal argument exception retrieve message
            if(e.getCause() != null && e.getCause().getCause().getClass().getSimpleName().equals(IllegalArgumentException.class.getSimpleName())){
                return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorDTO(e.getCause().getCause().getMessage())).build();
            }
            // Otherwise send internal server error message
            else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO("Internal server error!")).build();
            }
        }
    }
    /**
     * This methods allows the web service to delete an existing User when an 
     * HTTP DELETE request is sent on the "/api/users/{userId}" url
     * @param userId the id of the user to delete
     * @return A response with status code OK and the deleted user's ID in a DTO
     * if everithing went well or with status code NOT_FOUND, SEVERE, 
     * BAD_REQUEST or INTERNAT_SERVER_ERROR otherwise
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") long userId) {
        try {
            if (userService.delete(userId)) {
                return Response.status(Response.Status.OK).entity(new UserIdDTO(userId)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity(new ErrorDTO("User not found!")).build();
            }
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * This method converts an User object to it's corresponding Data Transfer
     * Object UserDTO, this DTO doesn't contain the password
     * @param user the user to convert
     * @return the DTO resulting from the conversion
     */
    private UserDTO userToDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(), 
                user.getFirstname(), user.getLastname());
    }
    /**
     * This method converts a Data Transfer Object UserLoginDTO (containing the
     * password) to an User objectthis DTO doesn't contain the password
     * @param userLoginDTO the Data Transfer Object to convert
     * @return the resulting User objects
     */
    private User UserLoginDTOToUser(UserLoginDTO userLoginDTO) {
        return new User(userLoginDTO.getUsername(), userLoginDTO.getPassword(), 
                userLoginDTO.getEmail(), userLoginDTO.getFirstname(), 
                userLoginDTO.getLastname());
    }
}
