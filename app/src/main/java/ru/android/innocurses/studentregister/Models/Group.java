package ru.android.innocurses.studentregister.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */
public class Group implements Serializable {
    private String name;
    private Long id;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        this.id = System.nanoTime();
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return name;
    }
}

