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

public class FilterGroupsActivity extends Activity {
    ListView lvGroups;
    EditText etFilter;
    Button bFilter;
    ArrayList<Group> groups = new ArrayList<>(ManagerGroups.groups.values());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_groups);

        lvGroups = (ListView) findViewById(R.id.lvFilterGroups);
        etFilter = (EditText)findViewById(R.id.etFilterGroups);
        bFilter = (Button)findViewById(R.id.btFilterGroups);

        //Создаем адаптер
        final ArrayAdapter<Group> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groups);
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
