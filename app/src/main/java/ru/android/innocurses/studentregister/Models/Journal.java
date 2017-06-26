package ru.android.innocurses.studentregister.Models;


import java.util.Map;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */
public class Journal {
    private Long id;
    private Long lessonId;
    private Map<Student,Boolean> present;

    public Journal(Long lessonId, Map<Student, Boolean> present) {
        this.lessonId = lessonId;
        this.present = present;
        this.id = System.nanoTime();
    }

    public Long getId() {
        return id;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Map<Student, Boolean> getPresent() {
        return present;
    }

    public void setPresent(Map<Student, Boolean> present) {
        this.present = present;
    }
}
