/**
 * 
 */
package io.swagger.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.model.Book;

/**
 * @author pnguyen
 *
 */
@Path("/books")
@io.swagger.annotations.Api(description = "the book API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-09T08:00:13.155-05:00")
public interface BookApi {

	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Creates a new Book object based on suppplied JSON and returns the created object including ID", notes = "", response = Book.class, tags = {
			"/samples", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Book.class) })
	public Response addBook(Book body, @Context SecurityContext securityContext) throws NotFoundException;

	@DELETE
	@Path("/{id}")
	@io.swagger.annotations.ApiOperation(value = "Removes a single Book object based on suppplied ID", notes = "", response = Book.class, tags = {
			"/samples", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Book.class) })
	public Response deleteBook(@PathParam("id") String id, @Context SecurityContext securityContext)
			throws NotFoundException;

	@GET
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Returns the entire collection of in-memory Book objects", notes = "", response = Book.class, responseContainer = "List", tags = {
			"/samples", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Book.class, responseContainer = "List") })
	public Response getAllBook(@Context SecurityContext securityContext) throws NotFoundException;

	@GET
	@Path("/{id}")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Returns a single Book object based on suppplied ID", notes = "", response = Book.class, tags = {
			"/samples", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Book.class) })
	public Response getBook(@PathParam("id") String id, @Context SecurityContext securityContext)
			throws NotFoundException;

	@PUT
	@Path("/{id}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Modifies an existing Book object based on suppplied JSON and uses the ID parameter to identify the target book", notes = "", response = Book.class, tags = {
			"/samples", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Book.class) })
	public Response updateBook(@PathParam("id") String id, Book body, @Context SecurityContext securityContext)
			throws NotFoundException;
}
