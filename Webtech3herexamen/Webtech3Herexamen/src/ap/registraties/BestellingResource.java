package ap.registraties;

import ap.xml.XMLParser;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class BestellingResource extends ServerResource {
	
	@Get("html")
	public String getRegistratie() {
		String bestelling_id = getAttribute("bestelling_id");
		XMLParser parser = new XMLParser();
		return parser.getRegistratie(bestelling_id);
	}
	
	/*@Post("txt")
	public String addRunner(String bestelling) {
		String registratie_id = getAttribute("registratie_id");
		XMLParser parser = new XMLParser();
		return parser.addRunner(registratie_id, bestelling);
	}*/

}
