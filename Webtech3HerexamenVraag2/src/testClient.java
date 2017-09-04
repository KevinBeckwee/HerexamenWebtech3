import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.ClientResource;

import java.util.ArrayList;

public class testClient {
    public static void main(String[] args) throws JSONException {
        try {
            ClientResource resource = new ClientResource("http://localhost:8181/products");

        JSONObject object1 = new JSONObject();
        object1.put("naam","battlefield 1");
        object1.put("producent","EA");
        object1.put("prijs","60");

        JSONObject object2 = new JSONObject();
        object1.put("naam","battlefield 4");
        object1.put("producent","EA");
        object1.put("prijs","20");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(object1);
        objects.add(object2);

        for (Object o: objects) {
            resource.post(o);
            System.out.println(resource.getResponseEntity().getText());

        }

        }catch (Exception e) {
            System.out.println("In main : " + e.getMessage());
        }

    }
}
