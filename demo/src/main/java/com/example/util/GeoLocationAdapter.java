package com.example.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.json.bind.adapter.JsonbAdapter;

import com.example.jsonbmodel.domain.Address;
import com.example.model.GeoCoordinate;
import com.example.model.GeoLocation;
import com.example.model.GeoLocationJson;

public class GeoLocationAdapter implements JsonbAdapter<GeoLocation,GeoLocationJson>{

	@Override
	public GeoLocationJson adaptToJson(GeoLocation obj) throws Exception {
		// TODO Auto-generated method stub
		GeoLocationJson gjson=new GeoLocationJson();
        //LinkedList<String> object = new LinkedList<String>(); 

		LinkedList<Double> coord=new LinkedList<Double>();
		coord.add(obj.getGeoLoc().getLat());
		coord.add(obj.getGeoLoc().getLon());
		gjson.setCoordinates(coord);
		return gjson;
	}

	@Override
	public GeoLocation adaptFromJson(GeoLocationJson obj) throws Exception {
		// TODO Auto-generated method stub
		GeoLocation geol=new GeoLocation();
		geol.setType(null);
		geol.setLocationType("geo");
		geol.setAddr(null);
		GeoCoordinate gc=new GeoCoordinate();
		gc.setLat(obj.getCoordinates().get(0));
		gc.setLon(obj.getCoordinates().get(1));
		geol.setGeoLoc(gc);
		return geol;
	}

}
