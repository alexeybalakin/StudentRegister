package ru.android.innocurses.studentregister.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

public class StudentsActivity extends Activity {
    List<Student> students = ManagerGroups.groups.get("Group#1").getStudents();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        //Находим список
        ListView lvStudents = (ListView) findViewById(R.id.lvStudents);
        //Создаем адаптер
        final ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students);
        //Присваиваем адаптер списку
        lvStudents.setAdapter(arrayAdapter);

        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(StudentsActivity.this, ProfileActivity.class);
                i.putExtra("student", arrayAdapter.getItem(position));
                startActivity(i);
            }
        });

    }

}
