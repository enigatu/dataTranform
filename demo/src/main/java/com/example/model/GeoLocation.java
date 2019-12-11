package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.util.GeoLocSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonInclude(Include.NON_EMPTY)

@XmlRootElement(name="loc")
@JsonSerialize(using=GeoLocSerializer.class)
@JsonTypeName("geo")
public class GeoLocation extends Location {

    public GeoLocation() {
    	
    }
   
    @XmlElement(name = "geo")
    private GeoCoordinate geoLoc;
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public GeoCoordinate getGeoLoc() {
        return geoLoc;
    }

    public void setGeoLoc(GeoCoordinate geoLoc) {
        this.geoLoc = geoLoc;
    }
    //@JsonTypeId
    private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}
