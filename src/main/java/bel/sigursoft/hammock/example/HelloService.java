package bel.sigursoft.hammock.example;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import org.infinispan.AdvancedCache;
import org.infinispan.manager.EmbeddedCacheManager;

@Path("/hello")
@RequestScoped
public class HelloService {

    @Inject
    @SmallCache
    private AdvancedCache<String, String> smallCache;

    @GET
    public Response doGet() {
      boolean isEmpty = smallCache.isEmpty();
      return Response.ok("Is small cache empty? => " + isEmpty).build();
    }
}
