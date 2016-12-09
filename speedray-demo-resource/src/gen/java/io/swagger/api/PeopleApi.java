package io.swagger.api;

import io.swagger.model.*;

import io.swagger.annotations.ApiParam;

import io.swagger.model.Person;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/people")


@io.swagger.annotations.Api(description = "the people API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-13T08:00:13.155-05:00")
public interface PeopleApi  {
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Creates a new Person object based on suppplied JSON and returns the created object including ID", notes = "", response = Person.class, tags={ "/samples", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    public Response addPerson(Person body
,@Context SecurityContext securityContext)
    throws NotFoundException;
    @DELETE
    @Path("/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Removes a single Person object based on suppplied ID", notes = "", response = Person.class, tags={ "/samples", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    public Response deletePerson(@PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException;
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns the entire collection of in-memory Person objects", notes = "", response = Person.class, responseContainer = "List", tags={ "/samples", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Person.class, responseContainer = "List") })
    public Response getAllPeople(@Context SecurityContext securityContext)
    throws NotFoundException;
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single Person object based on suppplied ID", notes = "", response = Person.class, tags={ "/samples", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    public Response getPerson(@PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException;
    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Modifies an existing Person object based on suppplied JSON and uses the ID parameter to identify the target person", notes = "", response = Person.class, tags={ "/samples", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    public Response updatePerson(@PathParam("id") String id
,Person body
,@Context SecurityContext securityContext)
    throws NotFoundException;
}
