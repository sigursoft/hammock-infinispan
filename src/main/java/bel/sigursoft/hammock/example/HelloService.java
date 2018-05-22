package bel.sigursoft.hammock.example;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
@RequestScoped
public class HelloService {
    @GET
    public Response doGet() {
        return Response.ok("Hello, world!").build();
    }
}
