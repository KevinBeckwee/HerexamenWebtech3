package ap.registraties;

import org.restlet.resource.ClientResource;

public class BestellingClient {
	public static void main(String[] args) {
		try {
        	ClientResource resource = new ClientResource("http://localhost:8181/registratie/heyboo");
        	// Post a new race
        	String diagnose = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        	diagnose += "<registratie id=\"201\""
        			+ " datum=\"28/01/2017\" "
        			+ "tijd=\"18:50\" "
        			+ "patiënt_firstname=\"Tim\" "
        			+ "patiënt_lastname=\"Van_Loon\" "
        			+ "birthday=\"14/06/1996\" "
        			+ "verpleegkundige_name=\"James Wilson\" "
        			+ "diagnose=\"Anale kanker\"><uri>registratie/25</uri>";
        	diagnose += "</registratie>";
    		resource.post(diagnose);
    		// get the response
        	System.out.println(resource.getResponseEntity().getText());
        	
           	String diagnose2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        	diagnose2 += "<registratie id=\"201\""
        			+ " datum=\"28/01/2017\" "
        			+ "tijd=\"18:50\" "
        			+ "patiënt_firstname=\"Oliver\" "
        			+ "patiënt_lastname=\"Queen\" "
        			+ "birthday=\"24/02/1985\" "
        			+ "verpleegkundige_name=\"Lisa Cuddy\" "
        			+ "diagnose=\"Shot with arrow\"><uri>registratie/48</uri>";
        	diagnose2 += "</registratie>";
    		resource.post(diagnose2);
    		// get the response
        	System.out.println(resource.getResponseEntity().getText());
        	
        }
        catch (Exception e) {
            System.out.println("In main : " + e.getMessage());
        }
	}

}
