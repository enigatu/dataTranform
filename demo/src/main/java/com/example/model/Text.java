package com.example.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)

public class Text {
    /*
    *             <text lang='e'>In Manhattan, major road construction on Worth
                St between W Broadway and Church St.</text>
            <*/
    @XmlAttribute
    private String lang;
    @XmlValue
    private String text;
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




}
