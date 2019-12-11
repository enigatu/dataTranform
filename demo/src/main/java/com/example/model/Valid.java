package com.example.model;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)

public class Valid {
    /*
    * <valid start='2019-02-10T05:00:00Z'
                   end='2019-04-13T03:58:59Z'/>*/
    @XmlAttribute(name="start")
    private String start;
    @XmlAttribute(name="end")
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
