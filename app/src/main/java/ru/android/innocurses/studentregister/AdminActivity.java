package ru.android.innocurses.studentregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends Activity {
    Button bAdminGroups;
    Button bAdminStudents;
    Button bAdminJournals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        bAdminGroups = (Button) findViewById(R.id.bAdminGroups);
        bAdminJournals = (Button) findViewById(R.id.bAdminJournals);
        bAdminStudents = (Button) findViewById(R.id.bAdminStudents);

        bAdminGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this,FilterGroupsActivity.class));
            }
        });

        bAdminStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this,FilterStudentsActivity.class ));
            }
        });

    }


}
