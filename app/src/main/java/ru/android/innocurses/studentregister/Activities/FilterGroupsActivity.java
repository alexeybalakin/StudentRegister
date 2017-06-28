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

import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

public class FilterGroupsActivity extends Activity {
    ListView lvGroups;
    EditText etFilter;
    Button bFilter;
    ArrayAdapter<Group> arrayAdapter;
    ArrayList<Group> groups = new ArrayList<>(ManagerGroups.groups.values());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_groups);
        Log.i("MyLog", "onCreate_Groups");

        lvGroups = (ListView) findViewById(R.id.lvFilterGroups);
        etFilter = (EditText) findViewById(R.id.etFilterGroups);
        bFilter = (Button) findViewById(R.id.btFilterGroups);

        //Создаем адаптер
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groups);
        if (savedInstanceState != null){
            etFilter.setText(savedInstanceState.getString("filterGroups"));
            arrayAdapter.getFilter().filter(etFilter.getText());
        }
        //Присваиваем адаптер списку
        lvGroups.setAdapter(arrayAdapter);


        bFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.getFilter().filter(etFilter.getText());
            }
        });

        lvGroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FilterGroupsActivity.this, FilterStudentsActivity.class);
                intent.putExtra("group", arrayAdapter.getItem(position));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("filterGroups", etFilter.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        etFilter.setText(savedInstanceState.getString("filterGroups"));
        arrayAdapter.getFilter().filter(etFilter.getText());

    }
}