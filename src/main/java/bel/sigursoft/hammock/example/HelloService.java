package bel.sigursoft.hammock.example;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import org.infinispan.Cache;

@Path("/hello")
@RequestScoped
public class HelloService {

    @Inject
    private Cache<String, String> cache;

    @GET
    public Response doGet() {
        cache.put("User", "William");
        String me = cache.get("User");
        return Response.ok("Hello, world! " + me).build();
    }
}
