package ru.android.innocurses.studentregister.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.android.innocurses.studentregister.R;

public class AdminActivity extends Activity {
    Button bAdminGroups;
    Button bAdminStudents;
    Button bAdminLessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        bAdminGroups = (Button) findViewById(R.id.bAdminGroups);
        bAdminLessons = (Button) findViewById(R.id.bAdminLessons);
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
                startActivity(new Intent(AdminActivity.this,FilterStudentsActivity.class));
            }
        });

        bAdminLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, AddLessonActivity.class));
            }
        });

    }


}
