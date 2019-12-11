package com.example.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.example.model.GeoLocation;
import com.example.model.Start;
import com.example.model.TmcLocation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class TmcLocationSerializer extends StdSerializer<TmcLocation> {

	static org.apache.log4j.Logger log = Logger.getLogger(TmcLocation.class);

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("started testing ");
		// GeoLocSerializer =new GeoLocSerializer();
		try {
			TmcLocation tmcLocation = new TmcLocation();
			tmcLocation.setLocationType("tmc");
			Start start = new Start();
			start.setId(16078);
			start.setDir("+");
			start.setOffset(86);
			start.setExtent(14);
			tmcLocation.setStart(start);
			// mapper.setSerializerProvider(p)
			SimpleModule module = new SimpleModule();
			module.addSerializer(GeoLocation.class, new GeoLocSerializer());
			mapper.registerModule(module);
			String serialized = mapper.writeValueAsString(tmcLocation);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			System.out.println("finished ");
			// mapper.set
			System.out.println("" + serialized);
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}

	}
	

	protected TmcLocationSerializer(Class<TmcLocation> t) {
		super(t);
	}

	public TmcLocationSerializer() {
		this(null);
	}
	/**/

	
	@Override
	public void serialize(TmcLocation value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		/*"​tmc​": ​{ 
        "​table​": ​4​, 
        "​id​": ​12915​, 
        "​direction​": ​"+"​, 
      ​} */
		System.out.println("calling geo loc serializer **************");
		log.info("Geo Loc serializer called **************");

		gen.writeStartObject();
		gen.writeStringField("table", "coming from table ");
		gen.writeNumberField("id",value.getStart().getId());
		gen.writeStringField("direction", value.getStart().getDir());
		gen.writeEndObject();

	}

}
