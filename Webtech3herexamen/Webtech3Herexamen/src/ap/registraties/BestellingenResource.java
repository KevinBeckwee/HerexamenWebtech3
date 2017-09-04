package ap.registraties;

import ap.xml.XMLParser;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class BestellingenResource extends ServerResource {


    @Get("html")
    public String getBestellingen() {
        XMLParser parser = new XMLParser();
        return parser.getBestellingen();
    }

    @Post("txt")
    public String addBetselling(String xml){
        XMLParser parser = new XMLParser();
        return parser.addBestelling(xml);
    }


}
