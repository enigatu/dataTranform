package com.example.model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
@JsonInclude(Include.NON_EMPTY)

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({@Type(value = GeoLocation.class, name = "geo"),@Type(value = TmcLocation.class, name = "tmc"),
})

@XmlSeeAlso({
        GeoLocation.class,
        TmcLocation.class,
})

public abstract  class Location {
   
    /*private int table;
    public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}*/

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	@XmlAttribute(name="type")
    //@JsonProperty(value="type")
	@JsonIgnore
    private String locationType;

}
