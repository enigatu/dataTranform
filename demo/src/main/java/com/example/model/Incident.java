package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
@JsonInclude(Include.NON_EMPTY)
@XmlRootElement
public class Incident {
    public List<TrafficIncident> getTis() {
        return tis;
    }

    public void setTis(List<TrafficIncident> tis) {
        this.tis = tis;
    }
    @XmlElement(name = "ti")
    List<TrafficIncident> tis;
}
