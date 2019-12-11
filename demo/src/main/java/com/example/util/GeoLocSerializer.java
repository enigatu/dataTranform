package com.example.util;


import com.example.model.GeoCoordinate;
import com.example.model.GeoLocation;
//import com.example.rss.TrafficFeedService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class GeoLocSerializer extends StdSerializer<GeoLocation> {
	
	/*
	 * "​geo​": ​{ 
        "​type​": ​"Point"​, 
        "​coordinates​": ​[ 
          -118.67265​, 
          53.924755 
        ] 
      }​*/
	static org.apache.log4j.Logger log = Logger.getLogger(GeoLocSerializer.class);

      public static void main(String[] args) {
    	  ObjectMapper mapper=new ObjectMapper();
    	  System.out.println("started testing ");
    	 // GeoLocSerializer =new GeoLocSerializer();
    	  try {
    		  GeoLocation geo=new GeoLocation();
    		  geo.setLocationType("geo");
    		  GeoCoordinate gcoord=new GeoCoordinate();
    		  gcoord.setLat(-11.0);
    		  gcoord.setLon(53.92);
    		  geo.setGeoLoc(gcoord);
    		 // mapper.setSerializerProvider(p)
    		  SimpleModule module = new SimpleModule();
    		  module.addSerializer(GeoLocation.class, new GeoLocSerializer());
    		  mapper.registerModule(module);    		   
    		  String serialized = mapper.writeValueAsString(geo);
    		  mapper.enable(SerializationFeature.INDENT_OUTPUT);
    		  System.out.println("finished ");
    		  //mapper.set
    		  System.out.println(""+serialized);
    	  }catch(Exception e) {
    		  System.out.println("error : "+e.getMessage());
    	  }
    	  
    	  
      }
       /*"​geo​": ​{ 
        "​type​": ​"Point"​, 
        "​coordinates​": ​[ 
          -118.67265​, 
          53.924755 
        ] 
      }​, */

	    protected GeoLocSerializer(Class<GeoLocation> t) {
	        super(t);
	    }
	    public GeoLocSerializer() {
	        this(null);
	    }
	   /**/
	    	 
	    public void serialize(GeoLocation geoLoc, JsonGenerator jsonGenerator,
	                          SerializerProvider serializerProvider)
	            throws IOException {
            System.out.println("calling geo loc serializer **************");
            log.info("Geo Loc serializer called **************");

	        jsonGenerator.writeStartObject();
	        jsonGenerator.writeStringField("type", "Point");
	        jsonGenerator.writeArrayFieldStart("coordinates");
	        jsonGenerator.writeNumber(geoLoc.getGeoLoc().getLon());
	        jsonGenerator.writeNumber(geoLoc.getGeoLoc().getLat());
	        jsonGenerator.writeEndArray();	
	        
	        
	        jsonGenerator.writeEndObject();
	    }
	

}
