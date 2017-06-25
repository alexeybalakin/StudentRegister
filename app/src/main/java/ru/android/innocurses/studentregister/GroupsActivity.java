package ru.android.innocurses.studentregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import ru.android.innocurses.studentregister.Adapters.GroupListAdapter;
import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Group;

public class GroupsActivity extends Activity {
    private RecyclerView rvGroups;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        rvGroups = (RecyclerView) findViewById(R.id.rvGroups);

        ArrayList<Group> groups = new ArrayList<>(ManagerGroups.groups.values());

        GroupListAdapter groupListAdapter = new GroupListAdapter(groups);
        rvGroups.setAdapter(groupListAdapter);
        rvGroups.setLayoutManager(new LinearLayoutManager(this));
        groupListAdapter.onItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupsActivity.this, StudentsActivity.class));
            }
        });

    }
}
