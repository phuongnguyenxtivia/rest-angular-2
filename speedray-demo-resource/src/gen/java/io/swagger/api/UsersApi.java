package io.swagger.api;

import io.swagger.model.*;

import io.swagger.annotations.ApiParam;

import io.swagger.model.LiferayUser;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/users")


@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-13T08:00:13.155-05:00")
public interface UsersApi  {
    @GET
    @Path("/current")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a simplified JSON representation of Liferay User object for logged in user (or default user if not logged in)", notes = "", response = LiferayUser.class, tags={ "/samples", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = LiferayUser.class) })
    public Response getCurrentUser(@Context SecurityContext securityContext)
    throws NotFoundException;
}
