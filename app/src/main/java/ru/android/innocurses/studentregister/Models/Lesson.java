package ru.android.innocurses.studentregister.Models;

import java.util.Date;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */
public class Lesson {
    private String name;
    private String subject;
    private String room;
    private String description;
    private Date startTime;
    private Date finishTime;
    private String lector;
    private Long groupId;
    private Long id;

    public Lesson(String name, String subject, String room, String description, Date startTime, Date finishTime, String lector, Long groupId) {
        this.name = name;
        this.subject = subject;
        this.room = room;
        this.description = description;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.lector = lector;
        this.groupId = groupId;
        this.id = System.nanoTime();
    }

    public Lesson(String name, Date startTime, Date finishTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.id = System.nanoTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }
    @Override
    public int hashCode() {
        return (int) (21+id*42);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return  false;
        if (!(obj instanceof Lesson)) return false;
        if(this.id !=((Lesson)obj).getId()) return false;
        return true;
    }
}
