/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudsonhui.wunderlisttoastrid.astrid;

import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author HiM
 */
@XmlRootElement(name="astrid")
@XmlSeeAlso({Task.class, TagData.class})
public class Astrid {
    
    private String version = "329";
    private String format = "3";
    
    private List<Task> tasks;
    private List<TagData> tagDatas;
    
    @XmlElements({
        @XmlElement(name="task")
    })
    public List<Task> getTasks() {
        return tasks;
    }
    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    @XmlElements({
        @XmlElement(name="tagdata")
    })
    public List<TagData> getTagDatas() {
        return tagDatas;
    }
    
    public void setTagDatas(List<TagData> tagDatas) {
        this.tagDatas = tagDatas;
    }

    @XmlAttribute
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    
}
