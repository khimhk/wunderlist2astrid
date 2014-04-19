/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudsonhui.wunderlisttoastrid.astrid;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HiM
 */
@XmlRootElement(name="task")
public class Task {
    
    public static final String RECURRENCE_FREQ_DAILY = "DAILY";
    public static final String RECURRENCE_FREQ_WEEKLY = "WEEKLY";
    public static final String RECURRENCE_FREQ_MONTHLY = "MONTHLY";
    public static final String RECURRENCE_FREQ_YEARLY = "YEARLY";
    
    
    private String attachments_pushed_at = "0";
    
    private String calendarUri = "";
    
    private String classification = "";
    
    private String completed = "0";
    
    private String created = "0";
    
    private String creatorId = "0";
    
    private String deleted = "0";
    
    private String detailsDate = "0";
    //TODO: due date
    
    private String dueDate = "0";
    
    private String elapsedSeconds = "0";
    
    private String estimatedSeconds = "0";
    
    private String flags = "0";
    
    private String hideUntil = "0";
    
    private String importance = "2";
    
    private String is_readonly = "0";
    
    private String lastSync = "0";
    
    private String modified = "0";
    //TODO: notes
    
    private String notes = "";
    
    private String postponeCount = "0";
    
    private String pushedAt = "0";
    //TODO: repeat mode
    
    private String recurrence = "";
    
    private String notificationFlags = "6";
    
    private String lastNotified = "0";
    
    private String notifications = "0";
    
    private String snoozeTime = "0";
    
    private String repeatUntil = "0";
    
    private String socialReminder = "unseen";
    
    private String timerStart = "0";
    //TODO: title
    
    private String title = "";
    
    private String activities_pushed_at = "0";
    
    private String userId = "0";
    //TODO: id
    
    private String remoteId = "";
    
    //TODO: metadata class
    private MetaData metadata;
    
    public Task() {
        long id = IdGenerator.generate();
        this.remoteId = String.valueOf(id);
    }
    
    @XmlElement
    public MetaData getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    @XmlAttribute
    public String getAttachments_pushed_at() {
        return attachments_pushed_at;
    }

    public void setAttachments_pushed_at(String attachments_pushed_at) {
        this.attachments_pushed_at = attachments_pushed_at;
    }

    @XmlAttribute
    public String getCalendarUri() {
        return calendarUri;
    }

    public void setCalendarUri(String calendarUri) {
        this.calendarUri = calendarUri;
    }

    @XmlAttribute
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @XmlAttribute
    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @XmlAttribute
    public String getDetailsDate() {
        return detailsDate;
    }

    public void setDetailsDate(String detailsDate) {
        this.detailsDate = detailsDate;
    }

    @XmlAttribute
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    public void setDueDate(long timestamp) {
        this.setDueDate(String.valueOf(timestamp));
    }
    
    public void setDueDate(Date date) {
        this.setDueDate(date.getTime());
    }

    @XmlAttribute
    public String getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void setElapsedSeconds(String elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
    }

    @XmlAttribute
    public String getEstimatedSeconds() {
        return estimatedSeconds;
    }

    public void setEstimatedSeconds(String estimatedSeconds) {
        this.estimatedSeconds = estimatedSeconds;
    }

    @XmlAttribute
    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    @XmlAttribute
    public String getHideUntil() {
        return hideUntil;
    }

    public void setHideUntil(String hideUntil) {
        this.hideUntil = hideUntil;
    }

    @XmlAttribute
    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    @XmlAttribute
    public String getIs_readonly() {
        return is_readonly;
    }

    public void setIs_readonly(String is_readonly) {
        this.is_readonly = is_readonly;
    }

    @XmlAttribute
    public String getLastSync() {
        return lastSync;
    }

    public void setLastSync(String lastSync) {
        this.lastSync = lastSync;
    }

    @XmlAttribute
    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @XmlAttribute
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlAttribute
    public String getPostponeCount() {
        return postponeCount;
    }

    public void setPostponeCount(String postponeCount) {
        this.postponeCount = postponeCount;
    }

    @XmlAttribute
    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    @XmlAttribute
    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }
    
    public void setRecurrence(String freq, int interval) {
        this.setRecurrence(String.format("RRULE:FREQ=%s;INTERVAL=%d", freq, interval));
    }

    @XmlAttribute
    public String getNotificationFlags() {
        return notificationFlags;
    }

    public void setNotificationFlags(String notificationFlags) {
        this.notificationFlags = notificationFlags;
    }

    @XmlAttribute
    public String getLastNotified() {
        return lastNotified;
    }

    public void setLastNotified(String lastNotified) {
        this.lastNotified = lastNotified;
    }

    @XmlAttribute
    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    @XmlAttribute
    public String getSnoozeTime() {
        return snoozeTime;
    }

    public void setSnoozeTime(String snoozeTime) {
        this.snoozeTime = snoozeTime;
    }

    @XmlAttribute
    public String getRepeatUntil() {
        return repeatUntil;
    }

    public void setRepeatUntil(String repeatUntil) {
        this.repeatUntil = repeatUntil;
    }

    @XmlAttribute
    public String getSocialReminder() {
        return socialReminder;
    }

    public void setSocialReminder(String socialReminder) {
        this.socialReminder = socialReminder;
    }

    @XmlAttribute
    public String getTimerStart() {
        return timerStart;
    }

    public void setTimerStart(String timerStart) {
        this.timerStart = timerStart;
    }

    @XmlAttribute
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
