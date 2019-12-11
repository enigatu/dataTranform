package com.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_EMPTY)

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafficIncidentResponse",
	propOrder = "incidentReport" )
public class TrafficIncidentResponse {
	
	public TrafficIncidentResponse() {
		
	}
	
	protected Incident incidentReport ;
	protected Integer status ;

	public Incident getIncidentReport() {
		return incidentReport ; 
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
