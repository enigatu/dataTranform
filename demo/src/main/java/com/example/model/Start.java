package com.example.model;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(Include.NON_EMPTY)

public class Start {

    /*<loc type='tmc'>
                <start id='16078' dir='+' offset='86' extent='14'/>
            </loc>*/
    @XmlAttribute
    private int id;
    @XmlAttribute
    @JsonProperty(value="direction")
    private String dir;
    @XmlAttribute
    @JsonIgnore
    private int offset;
    @XmlAttribute
    @JsonIgnore
    private int extent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getExtent() {
        return extent;
    }

    public void setExtent(int extent) {
        this.extent = extent;
    }


}
