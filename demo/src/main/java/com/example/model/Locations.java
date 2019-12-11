package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_EMPTY)
public class Locations {
	
	
	private List<Event> locations;

	public List<Event> getLocations() {
		return locations;
	}

	public void setLocations(List<Event> locations) {
		this.locations = locations;
	}

	

}
