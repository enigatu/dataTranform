package com.example.controllers;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Event;
//import com.example.model.GeoLocSerializer;
import com.example.model.GeoLocation;
import com.example.model.Incident;
import com.example.model.Locations;
import com.example.model.TmcLocation;
import com.example.model.TrafficIncidentResponse;
//import com.example.rss.TrafficDataUtil;
//import com.example.services.TrafficFeedService;
import com.example.services.TrafficFeedService;
import com.example.util.GeoLocationAdapter;
import com.example.util.TrafficDataUtil;
import com.example.util.GeoLocSerializer;

//import javax.json.bind.JsonbConfig;


@RestController
@ConfigurationProperties(prefix="traffic")
public class TrafficFeedController {

	@Autowired
	TrafficFeedService trafficService;

	@Autowired
	RestTemplate restTemplate;
	
	private String urlEndpoint;

	public String getUrlEndpoint() {
		return urlEndpoint;
	}

	public void setUrlEndpoint(String urlEndpoint) {
		this.urlEndpoint = urlEndpoint;
	}
	static org.apache.log4j.Logger log = Logger.getLogger(TrafficFeedController.class);
	@RequestMapping(value = "/getTrafficXml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public Incident getXmlTrafficData() {
		Incident incident = TrafficDataUtil.createIncident();
		File file = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Incident.class, GeoLocation.class, TmcLocation.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Marshal and output to the console
			// marshaller.marshal(incident, System.out);
			StringBuilder stringBuid = new StringBuilder();
			file = new File("output.xml");

			marshaller.marshal(incident, file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incident;

		// return
	}

	@RequestMapping(value = "/incidents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getTrafficData() throws Exception {
		TrafficIncidentResponse incident = null;
		Response trafficResponse = null;

		try {
            
			trafficResponse = trafficService.getTrafficFeed();

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trafficResponse;

		// return
	}

	
	@RequestMapping(value = "/trafficIncidentsJFeed", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locations> getTrafficJsonFeed() throws MalformedURLException, JAXBException {

		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mtypes = new ArrayList<>();
		mtypes.add(MediaType.APPLICATION_XML);
		headers.setAccept(mtypes);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		JAXBContext context = JAXBContext.newInstance(Incident.class);

		// Create an unmarshaller
		Unmarshaller unmarshaller = context.createUnmarshaller();
		URL url = new URL(urlEndpoint);
		InputStream is = null;
		HttpURLConnection http;
		Incident incident = null;
		Locations locations=new Locations();
		try {
			http = (HttpURLConnection) url.openConnection();
			http.addRequestProperty("User-Agent", "Mozilla/4.76");
			is = http.getInputStream();
			// Unmarshal the XML
			incident = (Incident) unmarshaller.unmarshal(is);

			// incident = rootElement.getValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return ResponseEntity.status(400).body(null);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        System.out.println("parsing events **************");

		for(Event e:incident.getTis().get(0).getEvents()) {
			System.out.println("class name : "+e.getLoc().getClass().getName());
			if(e.getLoc().getClass().getName()=="com.example.model.GeoLocation") {
				//System.out.println("found geolocal");
				e.setRoadName(((GeoLocation)e.getLoc()).getAddr());
			}else {
				//System.out.println("class name : "+e.getLoc().getClass().getName());
				((TmcLocation)e.getLoc()).setTable(incident.getTis().get(0).getTable());

				
			}
			
			
		}
		for(Event e:incident.getTis().get(0).getEvents()) {
			//e.getLoc().setTable(incident.getTis().get(0).getTable());
			//System.out.println("checking class name : "+e.getLoc().getClass().getName());
			
			
		}
		locations.setLocations(incident.getTis().get(0).getEvents());
		return ResponseEntity.ok(locations);

	}

	@RequestMapping(value = "/trafficIncidentsJBFeed", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locations> getTrafficJsonBFeed() throws MalformedURLException, JAXBException {

		HttpHeaders headers = new HttpHeaders();
		List<MediaType> mtypes = new ArrayList<>();
		mtypes.add(MediaType.APPLICATION_XML);
		headers.setAccept(mtypes);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		JAXBContext context = JAXBContext.newInstance(Incident.class);

		// Create an unmarshaller
		Unmarshaller unmarshaller = context.createUnmarshaller();
		URL url = new URL(urlEndpoint);
		InputStream is = null;
		HttpURLConnection http;
		Incident incident = null;
		Locations locations=new Locations();
		try {
			http = (HttpURLConnection) url.openConnection();
			http.addRequestProperty("User-Agent", "Mozilla/4.76");
			is = http.getInputStream();
			// Unmarshal the XML
			incident = (Incident) unmarshaller.unmarshal(is);

			// incident = rootElement.getValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return ResponseEntity.status(400).body(null);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        System.out.println("parsing events **************");

		for(Event e:incident.getTis().get(0).getEvents()) {
			System.out.println("class name : "+e.getLoc().getClass().getName());
			if(e.getLoc().getClass().getName()=="com.example.model.GeoLocation") {
				//System.out.println("found geolocal");
				e.setRoadName(((GeoLocation)e.getLoc()).getAddr());
			}else {
				//System.out.println("class name : "+e.getLoc().getClass().getName());
				((TmcLocation)e.getLoc()).setTable(incident.getTis().get(0).getTable());

				
			}
			
			
		}
		for(Event e:incident.getTis().get(0).getEvents()) {
			//e.getLoc().setTable(incident.getTis().get(0).getTable());
			//System.out.println("checking class name : "+e.getLoc().getClass().getName());
			
			
		}
		/*JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);

        // Create a PurchaseOrder and convert it to JSON
        PurchaseOrder purchaseOrder = createPurchaseOrder();
        String json = jsonb.toJson(purchaseOrder);//to json from java to json
        System.out.println(json);

        // Convert JSON back to a PurchaseOrder object
        PurchaseOrder result = jsonb.fromJson(json, PurchaseOrder.class); //from json to java .

        // Print information about the order
        System.out.println("\nPurchase order for: " + result.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : result.getItems()) {
            System.out.printf("- %2dx %-16s $%6.2f%n", item.getQuantity(), item.getProductName(), item.getPrice());
        }
    }*/
		locations.setLocations(incident.getTis().get(0).getEvents());
		JsonbConfig config = new JsonbConfig()
				.withAdapters(new GeoLocationAdapter())
				.withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);
        
      //JsonbConfig config = new JsonbConfig()
        //        .withAdapters(new LoyaltyAdapter())
             //   .withFormatting(true);
//
        // Create a Jsonb instance
        //Jsonb jsonb = JsonbBuilder.create(config);

		String json = jsonb.toJson(locations);//to json from java to json
        System.out.println(json);
		return ResponseEntity.ok(locations);

	}

	
	

}
