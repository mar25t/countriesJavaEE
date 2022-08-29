package cz.martin.resources;

import cz.martin.services.CountryService;
import cz.martin.models.YearsGdp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("countries")
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {

    private CountryService service = new CountryService();

    @GET
    @Path("all")
    public Response getAll() {
        return Response.ok(service.getAll()).build();
    }

    @GET
    @Path("specific/{code}")
    public Response getSpecific(@PathParam("code") String code) {
        //Promena, do ktere ulozim rocni vypis hdp zeme, pokud neni nalezen kod zeme, nastavi se na null
        YearsGdp gdp = service.findCountryByCode(code);

        //Pokud je promena "gdp" null, vratim status 404 (not found)
        if(gdp == null) return Response.status(404).build();

        //Pokud null neni, vratim proimenou gdp
        return Response.ok(gdp).build();
    }

    @GET
    @Path("change")
    public Response getChange() {
        return Response.ok(service.getChanges()).build();
    }
}
