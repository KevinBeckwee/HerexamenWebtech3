package ap.registraties;

import org.restlet.resource.ClientResource;

import java.util.ArrayList;

public class BestellingClient {
	public static void main(String[] args) {
		try {
        	ClientResource resource = new ClientResource("http://localhost:8181/bestellingen");
			String bestelling = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
			bestelling += "<bestelling id=\"25\""
					+ " klantNaam=\"Randolph Smith\" "
					+ "adres=\"ErgensInAustraliëlaan 57\" "
					+ "datum=\"07/10/2017\" "
					+ "produktNaam=\"Gundam Model Kits\" "
					+ "hoeveelheid=\"30\" "
					+ "><uri>bestelling/25</uri>";
			bestelling += "</bestelling>";

			String bestelling2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
			bestelling2 += "<bestelling id=\"221\""
					+ " klantNaam=\"Gregory House\" "
					+ "adres=\"221B Baker Street\" "
					+ "datum=\"13/05/2014\" "
					+ "produktNaam=\"Piano\" "
					+ "hoeveelheid=\"1\" "
					+ "><uri>bestelling/221</uri>";
			bestelling2 += "</bestelling>";

        	ArrayList<String> bestellingen = new ArrayList<>();
        	bestellingen.add(bestelling);
        	bestellingen.add(bestelling2);
        	// Post a new bestelling
			for (String aBestellingen : bestellingen) {
				resource.post(aBestellingen);
				System.out.println(resource.getResponseEntity().getText());

			}
        	
        }
        catch (Exception e) {
            System.out.println("In main : " + e.getMessage());
        }
	}

}
