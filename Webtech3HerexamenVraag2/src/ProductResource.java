import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.io.*;
import java.util.ArrayList;

public class ProductResource extends ServerResource{

    private String file = "testJSON.JSON";


    public void write (String filename, ArrayList<Product> x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < x.size(); i++) {

            outputWriter.write(x.get(i).toJson());
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }
    @Get("html")
    public String getProducts() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("products.JSON"));

        StringBuilder string = new StringBuilder();
        for ( int i  = 0; i < Product.productList.size(); i++){
            string.append(Product.productList.get(i).toString());
        }

        return string.toString();
    }

    @Post("json")
    public void doPost(JsonRepresentation boo) throws IOException {
        System.out.println(boo);
        JSONObject jsonObject = null;

        try {
            jsonObject= boo.getJsonObject();
            Product.productList.add(
                    new Product(
                            jsonObject.getString("naam"),
                            jsonObject.getString("producent"),
                            Integer.parseInt(jsonObject.getString("prijs"))));
            write(file,Product.productList);
            // System.out.println(jsonObject.toString());
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }

    }

}
