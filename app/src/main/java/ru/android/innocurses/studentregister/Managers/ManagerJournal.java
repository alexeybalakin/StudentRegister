package ru.android.innocurses.studentregister.Managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.android.innocurses.studentregister.Models.Journal;
import ru.android.innocurses.studentregister.Models.Student;

/**
 * Created by admin on 26.06.2017.
 */

public class ManagerJournal {
    public static List <Journal> journals = new ArrayList<>();
    static{
        Map<Student, Boolean> presents = new HashMap<>();
        presents.put(new Student(new Date(),1l,"Иван", "Иванович","Иванов"),true);
        presents.put(new Student(new Date(),2l,"Петр", "Петрович","Петров"),false);
        presents.put(new Student(new Date(),3l,"Сидор", "Сидорович","Сидоров"),true);
        presents.put(new Student(new Date(),4l,"Николай", "Николаевич","Николаев"),false);
        presents.put(new Student(new Date(),5l,"Семен", "Семенович","Семенов"),true);
        journals.add(new Journal(1l,presents));
        journals.add(new Journal(2l,presents));
        journals.add(new Journal(3l,presents));
        journals.add(new Journal(4l,presents));
        journals.add(new Journal(5l,presents));
    }
}
