package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    public TimeEntry() {

    }

    public long getId() {
        return id;
    }

    private long id;
    private long projectId;
    private long userId;

    public void setId(long id) {
        this.id = id;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    private LocalDate date;

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.userId = userId;
        this.projectId = projectId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, long id, LocalDate date, int hours) {
        this(projectId, userId, date, hours);
        this.id = id;
    }
}
