package com.example.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//import org.glassfish.jersey.server.internal.inject.ParamConverters.TypeValueOf;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;
@JsonInclude(Include.NON_EMPTY)

@XmlType(propOrder = {"table", "tv", "fv", "at","events"})
public class TrafficIncident {
    //    <ti table='120' tv='2Q2016' fv='1.0' at='2019-03-31T21:12:15Z'>
    @XmlAttribute
    private int table;
    @XmlAttribute
    private String tv;
    @XmlAttribute
    private double fv;
    @XmlAttribute
    private String at;
    @XmlElement(name = "event")
    @JsonProperty(value="locations")
    private List<Event> events;


    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
        /*for(Event ev:this.getEvents()) {
        	if (ev.getLoc().getClass().getName()=="TmcLocation.class") {
        		((TmcLocation)ev.getLoc()).setTable(table);
        	}
        	
        }*/
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public double getFv() {
        return fv;
    }

    public void setFv(double fv) {
        this.fv = fv;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }




}
