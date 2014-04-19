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
@XmlRootElement(name="tagdata")
public class TagData {
    
    
    private String completed = "0";
    
    private String created = "0";
    
    private String deleted = "0";
    
    private String flags = "0";
    
    private String isFolder = "0";
    
    private String isTeam = "1";
    
    private String isUnread = "0";
    
    private String lastActivityDate = "0";
    
    private String lastAutosync = "0";
    
    private String members = "0";
    
    private String memberCount = "0";
    
    private String metadata_pushed_at = "0";
    //TODO: list name
    
    private String name = "";
    
    private String picture = "";
    
    private String pushedAt = "0";
    
    private String tagDescription = "";
    
    private String tagOrdering = "[]";
    
    private String tasks_pushed_at = "0";
    
    private String taskCount = "0";
    
    private String thumb = "";
    
    private String user = "";
    
    private String activities_pushed_at = "0";
    
    private String userId = "0";
    
    private String remoteId = "";
    
    public TagData() {
        long id = IdGenerator.generate();
        this.remoteId = String.valueOf(id);
    }

    @XmlAttribute
    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
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
    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    @XmlAttribute
    public String getIsFolder() {
        return isFolder;
    }

    public void setIsFolder(String isFolder) {
        this.isFolder = isFolder;
    }

    @XmlAttribute
    public String getIsTeam() {
        return isTeam;
    }

    public void setIsTeam(String isTeam) {
        this.isTeam = isTeam;
    }

    @XmlAttribute
    public String getIsUnread() {
        return isUnread;
    }

    public void setIsUnread(String isUnread) {
        this.isUnread = isUnread;
    }

    @XmlAttribute
    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    @XmlAttribute
    public String getLastAutosync() {
        return lastAutosync;
    }

    public void setLastAutosync(String lastAutosync) {
        this.lastAutosync = lastAutosync;
    }

    @XmlAttribute
    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    @XmlAttribute
    public String getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(String memberCount) {
        this.memberCount = memberCount;
    }

    @XmlAttribute
    public String getMetadata_pushed_at() {
        return metadata_pushed_at;
    }

    public void setMetadata_pushed_at(String metadata_pushed_at) {
        this.metadata_pushed_at = metadata_pushed_at;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @XmlAttribute
    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    @XmlAttribute
    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    @XmlAttribute
    public String getTagOrdering() {
        return tagOrdering;
    }

    public void setTagOrdering(String tagOrdering) {
        this.tagOrdering = tagOrdering;
    }

    @XmlAttribute
    public String getTasks_pushed_at() {
        return tasks_pushed_at;
    }

    public void setTasks_pushed_at(String tasks_pushed_at) {
        this.tasks_pushed_at = tasks_pushed_at;
    }

    @XmlAttribute
    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(String taskCount) {
        this.taskCount = taskCount;
    }

    @XmlAttribute
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @XmlAttribute
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @XmlAttribute
    public String getActivities_pushed_at() {
        return activities_pushed_at;
    }

    public void setActivities_pushed_at(String activities_pushed_at) {
        this.activities_pushed_at = activities_pushed_at;
    }

    @XmlAttribute
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlAttribute
    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }
    
}
