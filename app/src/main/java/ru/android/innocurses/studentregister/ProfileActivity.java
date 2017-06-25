package ru.android.innocurses.studentregister;

import android.app.Activity;
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

/**
 * Created by admin on 22.06.2017.
 */

public class ProfileActivity extends Activity {
    private ListView listContacts;
    private ListView listJournal;
    private Button bEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        bEdit = (Button) findViewById(R.id.bEdit);
        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, UpdateStudentActivity.class));
            }
        });

        listContacts = (ListView) findViewById(R.id.listContacts);
        ArrayAdapter<String> arrayAdapterContacts =
                new ArrayAdapter<String>(ProfileActivity.this,
                        android.R.layout.simple_list_item_1,
                        new String[] { "+7 (981) 777-77-77", "@thisIsATest", "vk.com/id01"});
        listContacts.setAdapter(arrayAdapterContacts);
        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView clicked = (TextView) view;
                Toast.makeText(ProfileActivity.this, clicked.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listJournal = (ListView) findViewById(R.id.journalList);
        JournalListAdapter journalListAdapter = new JournalListAdapter();
        ArrayAdapter<String> arrayAdapterJournal=
                new ArrayAdapter<String>(ProfileActivity.this,android.R.layout.simple_list_item_1,
                        new String[]{"Java","Android","C++"});
        listJournal.setAdapter(arrayAdapterJournal);

    }
}
