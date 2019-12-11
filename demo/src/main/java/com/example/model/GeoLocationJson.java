package com.example.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeoLocationJson {
/*"​geo​": ​{ s
        "​type​": ​"Point"​, 
        "​coordinates​": ​[ 
          -118.67265​, 
          53.924755 
        ] 
      }​, */
	
	private String type ="Point";
	public String getType() {
		return type;
	}
	public LinkedList<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(LinkedList<Double> coordinates) {
		this.coordinates = coordinates;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	private LinkedList<Double> coordinates=new LinkedList<Double>();
}
