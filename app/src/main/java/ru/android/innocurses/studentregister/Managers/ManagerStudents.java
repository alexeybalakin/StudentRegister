package ru.android.innocurses.studentregister.Managers;


import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.Student;

/**
 * Created by Alexey Balakin on 08.06.2017.
 */
public class ManagerStudents {

    public static Group addStudent(Group group, Student student){
        group.getStudents().add(student);
        return group;
    }

    public static Group removeStudent(Group group, Student student){
        group.getStudents().remove(student);
        return group;
    }

}

