package ru.android.innocurses.studentregister.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.android.innocurses.studentregister.Activities.StudentsActivity;
import ru.android.innocurses.studentregister.Adapters.GroupListAdapter;
import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.R;

/**
 * Created by admin on 28.06.2017.
 */

public class FragmentGroups extends Fragment {
    private RecyclerView rvGroups;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_groups,container,true);

        rvGroups = (RecyclerView) fragment.findViewById(R.id.rvGroups);
        ArrayList<Group> groups = new ArrayList<>(ManagerGroups.groups.values());

        GroupListAdapter groupListAdapter = new GroupListAdapter(groups);
        rvGroups.setAdapter(groupListAdapter);
        rvGroups.setLayoutManager(new LinearLayoutManager(getActivity()));
                groupListAdapter.onItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });
        return fragment;
    }
}
