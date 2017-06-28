package ru.android.innocurses.studentregister.Activities;

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
import ru.android.innocurses.studentregister.R;

public class FilterStudentsActivity extends Activity {
    ListView lvStudents;
    EditText etFilter;
    Button bFilter;
    ArrayAdapter<Student> arrayAdapter;
    List<Student> students = new ArrayList<>(ManagerGroups.groups.get("Group#1").getStudents());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_students);
        Log.i("MyLog","onCreate_Students");

        Group group = (Group) getIntent().getSerializableExtra("group");
        if(group != null){
            students = group.getStudents();
        }


        lvStudents = (ListView) findViewById(R.id.lvFilterStudents);
        etFilter = (EditText)findViewById(R.id.etFilterStudents);
        bFilter = (Button)findViewById(R.id.btFilterStudents);

        //Создаем адаптер
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
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
        Intent i = new Intent(FilterStudentsActivity.this, ProfileActivity.class);
        i.putExtra("student", arrayAdapter.getItem(position));
        startActivity(i);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("filterStudents",etFilter.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        etFilter.setText(savedInstanceState.getString("filterStudents"));
        arrayAdapter.getFilter().filter(etFilter.getText());
    }
}
