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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
@Path("/users")	
public class UserResource {
    @EJB	
    UserServiceLocal userService;	

    @Context
    UriInfo uriInfo;

    @GET	
    @Produces(MediaType.APPLICATION_JSON)	
    public List<UserDTO> getUsers() {	
        List<User> users = userService.findAll();
        return users.stream().map(u -> new UserDTO(u.getUsername())).collect(Collectors.toList());
    }

    /*@GET
    @Produces("application/json")	
    @Path("/{userId}")	
    public long getUser()	{	
        return	beersManager.add(beer);	
    }

    @POST
    @Consumes("application/json")	
    @Path("/{userId}")	
    public long getUser()	{	
        return	beersManager.add(beer);	
    }*/
}