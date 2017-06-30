package ru.android.innocurses.studentregister.Activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.android.innocurses.studentregister.Adapters.StudentListAdapter;
import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

public class FilterStudentsActivity extends Activity {

    EditText etFilter;

    Fragment fragmentStudents;
    RecyclerView rv;

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

        etFilter = (EditText)findViewById(R.id.etFilterStudents);
         fragmentStudents = getFragmentManager().findFragmentById(R.id.fragmentFilterStudents);
        rv = (RecyclerView)fragmentStudents.getView().findViewById(R.id.rvStudents);
        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = etFilter.getText().toString().toLowerCase();
                ((StudentListAdapter)rv.getAdapter()).filter(text);

            }
        });



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString("filterStudents",etFilter.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        etFilter.setText(savedInstanceState.getString("filterStudents"));
//        arrayAdapter.getFilter().filter(etFilter.getText());
    }
}
