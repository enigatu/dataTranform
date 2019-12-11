package com.example.util;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.example.model.Event;
import com.example.model.GeoCoordinate;
import com.example.model.GeoLocation;
import com.example.model.Incident;
import com.example.model.Start;
import com.example.model.Text;
import com.example.model.TmcLocation;
import com.example.model.TrafficIncident;
import com.example.model.Valid;

public class TrafficDataUtil {

    public static void main(String[] args) throws JAXBException {
        Incident incident = createIncident();

        JAXBContext context = JAXBContext.newInstance(Incident.class,GeoLocation.class,TmcLocation.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal and output to the console
        marshaller.marshal(incident, System.out);
    }
    public static Incident createIncident() {
    	Incident incident = new Incident();

		TrafficIncident trafficIncident1 = new TrafficIncident();
		// <ti table='120' tv='2Q2016' fv='1.0' at='2019-03-31T21:12:15Z'>
		trafficIncident1.setTable(120);
		trafficIncident1.setAt("2Q2016");
		trafficIncident1.setFv(1.0);
		trafficIncident1.setAt("2019-03-31T21:12:15Z");
		trafficIncident1.setTv("2Q2016");
		/*
		 * <ev> <id>23317403</id> <ec>702</ec> <se>3</se> <loc type='geo'> <geo
		 * lon='-74.00625' lat='40.717075'/> <addr>Worth St</addr> </loc> <valid
		 * start='2019-02-10T05:00:00Z' end='2019-04-13T03:58:59Z'/> <text lang='e'>In
		 * Manhattan, major road construction on Worth St between W Broadway and Church
		 * St.</text> <delay>8</delay> </ev>
		 */
		Event event1 = new Event();
		event1.setId(23317403);
		event1.setEventCode(702);
		event1.setSeverity(3);
		event1.setDelay(8);
		GeoCoordinate geoCoor = new GeoCoordinate();
		geoCoor.setLat(40.717075);
		geoCoor.setLon(-74.00625);
		// Addr addr = new Addr();
		// addr.setStreetAddress("Worth St");
		GeoLocation geoLoc = new GeoLocation();
		geoLoc.setLocationType("geo");
		geoLoc.setAddr("Worth St");
		geoLoc.setGeoLoc(geoCoor);
		event1.setLoc(geoLoc);
		Valid valid = new Valid();
		valid.setStart("2019-02-10T05:00:00Z");
		valid.setEnd("2019-04-13T03:58:59Z");
		event1.setValid(valid);
		Text text = new Text();
		text.setLang("e");
		text.setText("In Manhattan, major road construction on Worth St between W Broadway and Church St.");
		event1.setText(text);
		/*
		 * <ev> <id>24049284</id> <ec>701</ec> <se>2</se> <loc type='tmc'> <start
		 * id='16078' dir='+' offset='86' extent='14'/> </loc> <valid
		 * start='2019-03-02T05:00:00Z' end='2019-04-02T03:58:59Z'/> <text lang='e'>In
		 * Bronx, road construction on Creston Ave between Minerva Pl and E 198th
		 * St.</text> <delay>0</delay> </ev>
		 */
		Event event2 = new Event();
		event2.setId(24049284);
		event2.setEventCode(701);
		event2.setSeverity(2);
		event2.setDelay(0);
		TmcLocation tmcLocation = new TmcLocation();
		tmcLocation.setLocationType("tmc");
		Start start = new Start();
		start.setId(16078);
		start.setDir("+");
		start.setOffset(86);
		start.setExtent(14);
		tmcLocation.setStart(start);

		event2.setLoc(tmcLocation);
		Valid valid2 = new Valid();
		valid.setStart("2019-03-02T05:00:00Z");
		valid.setEnd("2019-04-02T03:58:59Z");
		event2.setValid(valid2);
		Text text2 = new Text();
		text2.setLang("e");
		text2.setText(
				"In Bronx, road construction on Creston Ave between Minerva Pl and E 198th St.");
		event2.setText(text2);
		List<Event> events = new ArrayList<>();
		events.add(event1);
		events.add(event2);

		trafficIncident1.setEvents(events);

		List<TrafficIncident> trafficIncidents = new ArrayList<>();
		trafficIncidents.add(trafficIncident1);

		// purchaseOrder.setCustomer(customer);
		incident.setTis(trafficIncidents);
		return incident;
    }
    
}
