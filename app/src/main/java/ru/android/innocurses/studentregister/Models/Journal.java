package ru.android.innocurses.studentregister.Models;


import java.util.Map;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */
public class Journal {
    private Lesson lesson;
    private Student student;
    private boolean present;

    public Journal(Lesson lesson, Student student, boolean present) {
        this.lesson = lesson;
        this.student = student;
        this.present = present;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}