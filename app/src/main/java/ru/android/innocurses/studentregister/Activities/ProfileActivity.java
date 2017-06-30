package ru.android.innocurses.studentregister.Activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ru.android.innocurses.studentregister.Adapters.JournalListAdapter;
import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

/**
 * Created by admin on 22.06.2017.
 */

public class ProfileActivity extends Activity {
    private ListView listContacts;
    private ListView listJournal;
    private Button bEdit;
    private Button bGroup;
    private TextView tvSurname;
    private TextView tvName;
    private TextView tvPatronymic;
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Получаем из интента студента для которого будем выводит профиль
        student = (Student) getIntent().getSerializableExtra("student");

        tvSurname = (TextView) findViewById(R.id.tvSurname);
        tvSurname.setText(student.getSurname());
        tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(student.getFirstName());
        tvPatronymic = (TextView) findViewById(R.id.tvPatronymic);
        tvPatronymic.setText(student.getSecondName());
        bGroup = (Button) findViewById(R.id.bGroup);

        bGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,FilterGroupsActivity.class));
            }
        });

        bEdit = (Button) findViewById(R.id.bEdit);
        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, UpdateStudentActivity.class));
            }
        });

//        listContacts = (ListView) findViewById(R.id.listContacts);
//        ArrayAdapter<String> arrayAdapterContacts =
//                new ArrayAdapter<String>(ProfileActivity.this,
//                        android.R.layout.simple_list_item_1,
//                        new String[] { "+7 (981) 777-77-77", "@thisIsATest", "vk.com/id01"});
//        listContacts.setAdapter(arrayAdapterContacts);
//        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView clicked = (TextView) view;
//                Toast.makeText(ProfileActivity.this, clicked.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        Fragment fragment = getFragmentManager().findFragmentById(R.id.fragmentJournals);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("student", student);
//        fragment.setArguments(bundle);

//        listJournal = (ListView) findViewById(R.id.journalList);
//        JournalListAdapter journalListAdapter = new JournalListAdapter();
//        ArrayAdapter<String> arrayAdapterJournal=
//                new ArrayAdapter<String>(ProfileActivity.this,android.R.layout.simple_list_item_1,
//                        new String[]{"Java","Android","C++"});
//        listJournal.setAdapter(arrayAdapterJournal);

    }
}
