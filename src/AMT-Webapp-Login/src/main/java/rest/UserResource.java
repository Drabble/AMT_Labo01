/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.heig.amt.webapp.model.User;
import com.heig.amt.webapp.services.UserServiceLocal;
import java.sql.SQLException;
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
import rest.dto.UserDTO;
import rest.dto.UserLoginDTO;

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
    public List<UserDTO> getUsers() {
        try {
            List<User> users = userService.findAll();
            return users.stream().map(u -> userToDTO(u)).collect(Collectors.toList());
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public UserDTO getUser(@PathParam("userId") long userId) {
        try {
            return userToDTO(userService.get(userId));
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(UserLoginDTO user) {
        try {
            if (userService.create(user.getUsername(), user.getPassword()) == -1) {
                return Response.status(Response.Status.CONFLICT).build();
            } else {
                return Response.status(Response.Status.CREATED).build();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Response.Status.CONFLICT).build();
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
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Response.Status.OK).build();
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
        } catch (SQLException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Response.Status.OK).build();
    }

    private UserDTO userToDTO(User user) {
        return new UserDTO(user.getUsername());
    }

    private User UserLoginDTOToUser(UserLoginDTO userLoginDTO) {
        return new User(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }
}
