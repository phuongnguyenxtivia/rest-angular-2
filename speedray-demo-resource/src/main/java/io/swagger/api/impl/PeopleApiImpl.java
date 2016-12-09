package io.swagger.api.impl;

import io.swagger.api.*;

import io.swagger.model.Person;

import java.util.ArrayList;
import java.util.List;
import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-12T14:51:43.709-05:00")
public class PeopleApiImpl implements PeopleApi {
    public Response addPerson(Person body, SecurityContext securityContext) throws NotFoundException {
        // generate a trivial ID based on epoch time
        body.setId(new java.util.Date().getTime());
        __people.add(body);
        return Response.ok().entity(body).build();
    }
    public Response deletePerson(String id, SecurityContext securityContext) throws NotFoundException {
        Response.ResponseBuilder builder =  Response.status(Response.Status.NOT_FOUND).entity("Person not found for ID: " + id);
        long pid = new Long(id);
        int ndx = 0;
        for (Person person : __people) {
            if (person.getId() == pid) {
                __people.remove(ndx);
                builder = Response.ok();
                break;
            } else {
                ndx++;
            }
        }
        return builder.build();
    }
    public Response getAllPeople(SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(__people).build();
    }
    public Response getPerson(String id, SecurityContext securityContext) throws NotFoundException {
        Response.ResponseBuilder builder;
        try {
            Person person = findById(new Long(id));
            if (person != null) {
                builder = Response.ok(person);
            } else {
                builder = Response.status(Response.Status.NOT_FOUND).entity("Person not found for ID: " + id);
            }
        } catch (Exception e) {
            builder = Response.status(Response.Status.NOT_FOUND).entity("Exception occurred for ID: " + id);
            e.printStackTrace();
        }
        return builder.build();
    }
    public Response updatePerson(String id, Person body, SecurityContext securityContext) throws NotFoundException {
        Response.ResponseBuilder builder = null;
        Person oldPerson = findById(new Long(id));
        if (oldPerson != null) {
            oldPerson.setFirstName(body.getFirstName());
            oldPerson.setLastName(body.getLastName());
            oldPerson.setLocation(body.getLocation());
            builder = Response.ok(oldPerson);
        } else {
            builder = Response.status(Response.Status.NOT_FOUND).entity("Person not found for ID: " + id);
        }

        return builder.build();
    }

    //
    // Utility function used by multiple endpoints
    //
    private static Person findById(long id) {
        for (Person person : __people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    private static Person createPerson(long id, String firstName, String lastName, String location) {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setLocation(location);
        return person;
    }

    // some sample data for our demo resource
    private static List<Person> __people = new ArrayList<Person>();
    static {
        __people.add(createPerson(1, "Daffy","Duck","Missouri"));
        __people.add(createPerson(2, "Minnie","Mouse","Ohio"));
        __people.add(createPerson(3, "Elmer","Fudd","Texas"));
        __people.add(createPerson(4, "Foghorn","Leghorn","South Carolina"));
        __people.add(createPerson(5, "Mother","Goose","New York"));
        __people.add(createPerson(6, "Bugs","Bunny","Colorado"));
    }
}
