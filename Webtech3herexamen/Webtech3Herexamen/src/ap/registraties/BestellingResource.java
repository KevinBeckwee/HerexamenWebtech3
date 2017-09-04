package ap.registraties;

import ap.xml.XMLParser;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class BestellingResource extends ServerResource {
	
	@Get("html")
	public String getBestelling() {
		String bestelling_id = getAttribute("bestelling_id");
		XMLParser parser = new XMLParser();
		return parser.getBestelling(bestelling_id);
	}
	
	/*@Post("txt")
	public String addBestelling(String bestelling) {
		String bestelling_id = getAttribute("bestelling_id");
		XMLParser parser = new XMLParser();
		return parser.addBestelling(bestelling_id, bestelling);
	}*/

}
