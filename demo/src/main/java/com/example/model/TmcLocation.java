package com.example.model;

import com.example.util.TmcLocationSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.xml.bind.annotation.XmlRootElement;
@JsonInclude(Include.NON_EMPTY)
//@JsonRootName(value="tmc")
@XmlRootElement(name="geo")//change this to geo to get json right on geo location why ?.
//@JsonTypeName("subB")
//@JsonSerialize(using=TmcLocationSerializer.class)
@JsonIgnoreType
@JsonTypeName("tmc")
public class TmcLocation extends Location{
	
    private int table;
    public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}
	//@JsonIgnore
	
    
	public Start getStart() {
        return start;
    }
    
    public void setStart(Start start) {
        this.start = start;
    }
    @JsonUnwrapped
    private Start start;
    /*
    * <loc type='tmc'>
                <start id='16078' dir='+' offset='86' extent='14'/>
            </loc>*/
    /*"​tmc​": ​{ 
        "​table​": ​4​, 
        "​id​": ​12915​, 
        "​direction​": ​"+"​, 
      ​} */

}
