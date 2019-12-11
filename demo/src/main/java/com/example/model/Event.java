package com.example.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElementRef;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder({ "id", "description" ,"loc","roadName","eventCode","severity","validStart","validEnd","type","lastUpdated"})
public class Event {
    //*<id>23317403</id>
    //            <ec>702</ec>
    //            <se>3</se>
    //            <loc type='geo'>
    //                <geo lon='-74.00625' lat='40.717075'/>
    //                <addr>Worth St</addr>
    //            </loc>
    //            <valid start='2019-02-10T05:00:00Z'
    //                   end='2019-04-13T03:58:59Z'/>
    //            <text lang='e'>In Manhattan, major road construction on Worth
    //                St between W Broadway and Church St.</text>
    //            <delay>8</delay>
    //
    // */
    private int id;
    private int eventCode;
    private int severity;
    @XmlElementRef
    @JsonProperty(value="geo")    
    private Location loc;
    @JsonIgnore
    private Valid valid;
    @JsonIgnore
    private Text text;
    @JsonIgnore
    private int delay;
    //2019-07-20T00:23:12.748Z 2019-11-25T20:21:41.609+0000
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date lastUpdated=new Date();
    private String type="TrafficIncident";
    private String validStart;
    private String validEnd;
    private String description;
    private String roadName;

   
	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValidStart() {
		return validStart;
	}

	public void setValidStart(String validStart) {
		this.validStart = validStart;
	}

	public String getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(String validEnd) {
		this.validEnd = validEnd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public Valid getValid() {
        return valid;
    }

    public void setValid(Valid valid) {
        this.valid = valid;
        this.validStart=valid.getStart();
        this.validEnd=valid.getEnd();
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
        this.description=text.getText();
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }


}
