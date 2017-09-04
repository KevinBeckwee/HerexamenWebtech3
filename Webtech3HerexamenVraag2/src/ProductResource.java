import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ProductResource extends ServerResource{
    @Get("html")
    public String getProducts() {
        return "heyboo";
    }

}
