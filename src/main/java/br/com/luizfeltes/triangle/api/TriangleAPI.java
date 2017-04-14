package br.com.luizfeltes.triangle.api;

import br.com.luizfeltes.triangle.core.Triangle;
import br.com.luizfeltes.triangle.core.TriangleException;
import java.util.Arrays;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * This is an API to run the Triangle problem over http
 * 
 * @author Luiz Feltes
 */
@Path("/")
public class TriangleAPI {

    /**
     * Return the type of the Triangle given the sides
     * 
     * @param a the side A
     * @param b the side B
     * @param c the side C
     * @return the type of Triangle. Otherwise will be the error message
     */
    @GET
    @Path("triangle/type")
    @Produces(MediaType.TEXT_PLAIN)
    public String triangleType(@QueryParam("a") String a, @QueryParam("b") String b, @QueryParam("c") String c) {
        try {
            return Triangle.of((String[]) Arrays.asList(a, b, c).toArray()).getType().toString();
        } catch (TriangleException e) {
            return e.getMessage();
        }
    }

}
