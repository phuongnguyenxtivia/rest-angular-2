/**
 * 
 */
package io.swagger.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;

import io.swagger.api.BookApi;
import io.swagger.api.NotFoundException;
import io.swagger.model.Book;

/**
 * @author pnguyen
 *
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-12T14:51:43.709-05:00")
public class BookApiImpl implements BookApi {

	@Override
	public Response addBook(Book body, SecurityContext securityContext) throws NotFoundException {
		// generate a trivial ID based on epoch time
        body.setIsbn(new java.util.Date().getTime());
        __entities.add(body);
        return Response.ok().entity(body).build();
	}

	@Override
	public Response deleteBook(String id, SecurityContext securityContext) throws NotFoundException {
		ResponseBuilder builder =  Response.status(Response.Status.NOT_FOUND).entity("Book not found for ID:" + id);
		try {
			long pid = new Long(id);
			int ndx = 0;
			for (Book entity : __entities) {
				if (entity.getIsbn() == pid) {
					__entities.remove(ndx);
					builder = Response.ok();
					break;
				} else {
					ndx++;
				}
			}
		} catch (Exception e) {
			builder = Response.status(Response.Status.NOT_FOUND).entity("Exception occurred for ID: " + id);
			e.printStackTrace();
		}
		
		return builder.build();
	}

	@Override
	public Response getAllBook(SecurityContext securityContext) throws NotFoundException {
		return Response.ok().entity(__entities).build();
	}

	@Override
	public Response getBook(String id, SecurityContext securityContext) throws NotFoundException {
		ResponseBuilder builder;
		try {
		  Book entry = findBookById(new Long(id));
		  if (entry != null) {
			  builder = Response.ok(entry);
		  } else {
			  builder = Response.status(Response.Status.NOT_FOUND).entity("Book not found for ID:" + id);
		  }
		} catch (Exception e) {
			builder = Response.status(Response.Status.NOT_FOUND).entity("Exception occurred for ID: " + id);
			e.printStackTrace();
		}
		return builder.build();
	}

	@Override
	public Response updateBook(String id, Book body, SecurityContext securityContext) throws NotFoundException {
		ResponseBuilder builder = null;
		
		try {
			Book oldEntity = findBookById(new Long(id));
			if (oldEntity != null) {
				oldEntity.setTitle(body.getTitle());
				oldEntity.setAuthor(body.getAuthor());
				oldEntity.setSummary(body.getSummary());
				builder = Response.ok(oldEntity);
			} else {
				builder = Response.status(Response.Status.NOT_FOUND).entity("Book not found for ID:" + id);
			}
		} catch (Exception e) {
			builder = Response.status(Response.Status.NOT_FOUND).entity("Exception occurred for ID: " + id);
			e.printStackTrace();
		}

		return builder.build();
	}

	public Book findBookById(long id) {
		for (Book entry : __entities) {
			if (entry.getIsbn() == id) {
				return entry;
			}
		}
		return null;
	}
	
	// some sample data for our demo resource
    private static List<Book> __entities = new ArrayList<Book> ();
    static {
    	__entities.add(new Book(1, "20,000 Leagues Under the Sea", "Jules Verne", "Twenty Thousand Leagues Under the Seas: An Underwater Tour of the World) is a classic science fiction novel by French writer Jules Verne published in 1870."));
    	__entities.add(new Book(2, "A Journey to the Center of the Earth", "Jules Verne", "The story involves German professor Otto Lidenbrock who believes there are volcanic tubes going toward the centre of the Earth."));
    	__entities.add(new Book(3, "Around the World in Eighty Days", "Jules Verne", "In the story, Phileas Fogg of London and his newly employed French valet Passepartout attempt to circumnavigate the world in 80 days on a £20,000 wager (equal to about £2 million in 2016) set by his friends at the Reform Club."));
    	__entities.add(new Book(4, "Star Trek", "Gene Roddenberry", "It followed the interstellar adventures of Captain James T. Kirk (William Shatner) and his crew aboard the starship USS Enterprise, a space exploration vessel, built by the interstellar federal republic United Federation of Planets in the twenty-third century."));
    	__entities.add(new Book(5, "Sherlock Holmes", "Arthur Conan Doyle", "Known as a 'consulting detective' in the stories, Holmes is known for a proficiency with observation, forensic science, and logical reasoning that borders on the fantastic, which he employs when investigating cases for a wide variety of clients, including Scotland Yard."));
    	__entities.add(new Book(6, "Hamlet", "William Shakespeare", "Set in the Kingdom of Denmark, the play dramatises the revenge Prince Hamlet is called to wreak upon his uncle, Claudius, by the ghost of Hamlet's father, King Hamlet. Claudius had murdered his own brother and seized the throne, also marrying his deceased brother's widow."));
    }
}
