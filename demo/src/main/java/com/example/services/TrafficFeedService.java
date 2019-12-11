package com.example.services;



import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.example.model.TrafficIncidentResponse;

@Service
public class TrafficFeedService {

	

	static org.apache.log4j.Logger log = Logger.getLogger(TrafficFeedService.class);
	
	private String table;

	public Response getTrafficFeed() throws Exception
			 {

		TrafficIncidentResponse response = null;
		Response resp=null;

		try {
            String baseUrl="http://localhost:8080/greetings";
			
			final ClientConfig clientConfig = new ClientConfig();
			//clientConfig.register(JacksonFeature.class);
			
			resp= ClientBuilder.newClient(clientConfig).target(baseUrl)
					.request(MediaType.TEXT_PLAIN_VALUE).get();
			log.debug("Response: " + resp.getStatus() + " - " + resp.readEntity(String.class));

			response = ClientBuilder.newClient(clientConfig).target(baseUrl)
					.request()
					.get(TrafficIncidentResponse.class);
			
			if (resp != null) {
				log.debug("6)  response.getStatus()==" + resp.getStatus());
				log.debug("6)  response ==" + resp);

			} else {
				log.debug("7)  response==null");
			}

		} catch (Exception e) {
			log.debug("8)  blows up!");
			log.error(e.getMessage());
			e.printStackTrace();
			log.error(e);
			throw new Exception(e.getMessage(), e);
		}

		return resp;

	}
	
	/*@GetMapping("/incident")
	public ResponseEntity<Student> read() {
		TrafficIncidentResponse foundStudent = service.read(id);
	    if (foundStudent == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(foundStudent);
	    }
	}*/
	
}
