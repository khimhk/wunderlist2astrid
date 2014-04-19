/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudsonhui.wunderlisttoastrid.astrid;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HiM
 */
@XmlRootElement(name="metadata")
public class MetaData {
    
    
    private String created = "0";
    
    private String deleted = "0";
    
    private String key = "tags-tag";
    //TODO: list name
    
    private String value = "";
    //TODO: list id
    
    private String value2 = "";
    //TODO: task id
    
    private String value3 = "";
    
    public void set(Task task, TagData list) {
        this.setValue(list.getName());
        this.setValue2(list.getRemoteId());
        this.setValue3(task.getRemoteId());
        task.setMetadata(this);
    }

    @XmlAttribute
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @XmlAttribute
    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @XmlAttribute
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @XmlAttribute
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute
    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @XmlAttribute
    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }
    
}
