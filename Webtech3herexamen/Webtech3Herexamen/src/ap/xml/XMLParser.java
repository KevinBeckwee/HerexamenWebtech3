package ap.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class XMLParser {
	
	private String INPUTFILE = "C:\\Users\\Keiichi\\Documents\\GitHub\\HerexamenWebtech3\\Webtech3herexamen\\Webtech3Herexamen\\registraties.xml";
	
	/** Get all races from the xml file and return them 
	 * in html format
	 */
	public String getRegistratie(String bestelling_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Bestelling</h2>";
	        
	        NodeList registraties = doc.getElementsByTagName("bestelling");

	        for (int i = 0; i < registraties.getLength(); i++) {
	        	
	        	 Node nNode = registraties.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(bestelling_id)) {
	        		 result += "<br/><b>registratie ID : </b>" + eElement.getAttribute("id");	        		 
	        		 result += "<br/><b>naam klant : </b>" + eElement.getAttribute("klantNaam");
	        		 result += "<br/><b>adres : </b>" + eElement.getAttribute("adres");
	        		 result += "<br/><b>datum bestelling : </b>" + eElement.getAttribute("datum");
	        		 result += "<br/><b>produktnaam : </b>" + eElement.getAttribute("produktNaam");
	        		 result += "<br/><b>hoeveelheid : </b>" + eElement.getAttribute("hoeveelheid");
	        		 result += "<br/>";
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	

	/**
	 * Utility method to print xml document
	 */
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
}
