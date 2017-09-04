package ap.registraties;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class BestellingApplicatie extends Application {
	
	   @Override
	   public synchronized Restlet createInboundRoot() {

	       Router router = new Router(getContext());


	       router.attach("/bestellingen", BestellingenResource.class);
	       router.attach("/bestelling/{bestelling_id}", BestellingResource.class);

	       return router;
	   }
	

}
