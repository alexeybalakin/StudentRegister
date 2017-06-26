package ru.android.innocurses.studentregister;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.Student;

public class FilterStudentsActivity extends Activity {
    ListView lvGroups;
    EditText etFilter;
    Button bFilter;
    ArrayList<Student> students = new ArrayList<>(ManagerGroups.groups.get("Group#1").getStudents());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_students);
        lvGroups = (ListView) findViewById(R.id.lvFilterStudents);
        etFilter = (EditText)findViewById(R.id.etFilterStudents);
        bFilter = (Button)findViewById(R.id.btFilterStudents);

        //Создаем адаптер
        final ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        //Присваиваем адаптер списку
        lvGroups.setAdapter(arrayAdapter);


        bFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.getFilter().filter(etFilter.getText());
            }
        });

    }
}
