package ru.android.innocurses.studentregister.Managers;

/**
 * Created by Alexey Balakin on 13.06.2017.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.Journal;
import ru.android.innocurses.studentregister.Models.Lesson;
import ru.android.innocurses.studentregister.Models.Student;

public class ManagerGroups {
    public static Map<String,Group> groups = new HashMap<>();
    public static List<Journal> journalList = new ArrayList<>();

    static{

        //Заполняем список групп
        groups.put("Group#1", new Group("Group#1"));
        groups.put("Group#2", new Group("Group#2"));
        groups.put("Group#3", new Group("Group#3"));
        groups.put("Group#4", new Group("Group#4"));
        groups.put("Group#5", new Group("Group#5"));

        //Добавляем студентов в группу #1
        List<Student> students = new ArrayList<>();
        students.add(new Student(new Date(),1l,"Иван", "Иванович","Иванов"));
        students.add(new Student(new Date(),2l,"Петр", "Петрович","Петров"));
        students.add(new Student(new Date(),3l,"Сидор", "Сидорович","Сидоров"));
        students.add(new Student(new Date(),4l,"Николай", "Николаевич","Николаев"));
        students.add(new Student(new Date(),5l,"Семен", "Семенович","Семенов"));
        students.add(new Student(new Date(),5l,"Семен", "Андреевич","Зеленкин"));
        groups.get("Group#1").setStudents(students);

        // Создаем список лекцтй
        List<Lesson> lessonlist = new ArrayList<>();
        lessonlist.add(new Lesson("Android", new Date(), new Date(new Date().getTime()+1000*60*60)));
        lessonlist.add(new Lesson("JavaSE", new Date(), new Date(new Date().getTime()+1000*60*60)));
        lessonlist.add(new Lesson("JavaEE", new Date(), new Date(new Date().getTime()+1000*60*60)));
        lessonlist.add(new Lesson("C++", new Date(), new Date(new Date().getTime()+1000*60*60)));
        lessonlist.add(new Lesson("Физкультура", new Date(), new Date(new Date().getTime()+1000*60*60)));

        // Создаем журнал
        for(Student student:students) {
            int i = 1;
            for(Lesson lesson: lessonlist) {
                journalList.add(new Journal(lesson, student, i % 2 == 0));
                i++;
            }
        }

    }

    public ManagerGroups() {


    }

    public  void addGroup(String groupName) {
        groups.put(groupName, new Group(groupName));
    }

    public void deleteGroup(String groupName){
        groups.remove(groupName);
    }

    public void printGroups (){
        for (Map.Entry gr:groups.entrySet()){
            System.out.println(gr.getKey());
        }
    }
    public Group getGroup(String name){
        return groups.get(name);
    }

}
