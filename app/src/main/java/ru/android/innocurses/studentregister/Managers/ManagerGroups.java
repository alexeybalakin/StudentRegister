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
import ru.android.innocurses.studentregister.Models.Student;

public class ManagerGroups {
    public static Map<String,Group> groups = new HashMap<>();

    static{

        //Заполняем список групп
        groups.put("Group#1", new Group("Group#1"));
        groups.put("Group#2", new Group("Group#2"));
        groups.put("Group#3", new Group("Group#3"));
        groups.put("Group#4", new Group("Group#4"));
        groups.put("Group#5", new Group("Group#5"));

        //Добавляем студентов в группу
        List<Student> students = new ArrayList<>();
        students.add(new Student(new Date(),1l,"Иван", "Иванович","Иванов"));
        students.add(new Student(new Date(),2l,"Петр", "Петрович","Петров"));
        students.add(new Student(new Date(),3l,"Сидор", "Сидорович","Сидоров"));
        students.add(new Student(new Date(),4l,"Николай", "Николаевич","Николаев"));
        students.add(new Student(new Date(),5l,"Семен", "Семенович","Семенов"));

        groups.get("Group#1").setStudents(students);


    }

    public ManagerGroups() {
    //    this.groups = new HashMap<>();

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
