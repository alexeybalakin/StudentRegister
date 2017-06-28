package ru.android.innocurses.studentregister.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Managers.ManagerJournal;
import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.Journal;
import ru.android.innocurses.studentregister.R;

public class FilterJournalActivity extends Activity {
    ListView lvJournals;
    EditText etFilter;
    Button bFilter;
    ArrayAdapter<Journal> arrayAdapter;
    ArrayList<Journal> journals = new ArrayList<>(ManagerJournal.journals);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_journal);

        Log.i("MyLog", "onCreate_Journal");

        lvJournals = (ListView) findViewById(R.id.lvFilterJournal);
        etFilter = (EditText) findViewById(R.id.etFilterJournal);
        bFilter = (Button) findViewById(R.id.btFilterJournal);

        //Создаем адаптер
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, journals);
        if (savedInstanceState != null){
            etFilter.setText(savedInstanceState.getString("filterJournal"));
            arrayAdapter.getFilter().filter(etFilter.getText());
        }
        //Присваиваем адаптер списку
        lvJournals.setAdapter(arrayAdapter);


        bFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.getFilter().filter(etFilter.getText());
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("filterJournal", etFilter.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        etFilter.setText(savedInstanceState.getString("filterJournal"));
        arrayAdapter.getFilter().filter(etFilter.getText());

    }
}