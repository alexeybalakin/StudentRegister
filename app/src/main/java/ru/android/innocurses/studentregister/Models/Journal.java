package ru.android.innocurses.studentregister.Models;


import java.util.Map;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */
public class Journal {
    private Long id;
    private Lesson lesson;
    private Map<Student,Boolean> present;

    public Journal(Lesson lesson, Map<Student, Boolean> present) {
        this.lesson = lesson;
        this.present = present;
        this.id = System.nanoTime();
    }

    public Long getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Map<Student, Boolean> getPresent() {
        return present;
    }

    public void setPresent(Map<Student, Boolean> present) {
        this.present = present;
    }
}
