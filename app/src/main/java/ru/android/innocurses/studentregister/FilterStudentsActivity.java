package ru.android.innocurses.studentregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.Student;

public class FilterStudentsActivity extends Activity {
    ListView lvStudents;
    EditText etFilter;
    Button bFilter;
    List<Student> students = new ArrayList<>(ManagerGroups.groups.get("Group#1").getStudents());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_students);
        Log.i("MyLog","onCreate_Students");

        Group group = (Group) getIntent().getSerializableExtra("groupName");

         students = group.getStudents();

        lvStudents = (ListView) findViewById(R.id.lvFilterStudents);
        etFilter = (EditText)findViewById(R.id.etFilterStudents);
        bFilter = (Button)findViewById(R.id.btFilterStudents);

        //Создаем адаптер
        final ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        //Присваиваем адаптер списку
        lvStudents.setAdapter(arrayAdapter);


        bFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.getFilter().filter(etFilter.getText());
            }
        });
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FilterStudentsActivity.this, FilterGroupsActivity.class);

                startActivity(intent);
            }
        });

    }
}
