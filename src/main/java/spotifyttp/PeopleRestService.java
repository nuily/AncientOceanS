package spotifyttp;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("people")
public class PeopleRestService {
    private PeopleDirectory peopleDirectory;

    public PeopleRestService() {
        peopleDirectory = PeopleDirectory.instance;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<People> viewAll() {
        return peopleDirectory.getPeopleDirectory().values();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public People pathMethod(@PathParam("id") String id) {
        return peopleDirectory.getPeopleDirectory().get(id);
    }

//    @GET
//    @Path("param")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String paramMethod(@QueryParam("name") String name) {
//        return "Hello, " + name;
//    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public void addPerson(@QueryParam("id") String id, @QueryParam("name") String name,
                          @QueryParam("favoriteCity") String favoriteCity) {
        People person = new People(id, name, favoriteCity);
        peopleDirectory.getPeopleDirectory().put(person.getId(), person);
    }
}
