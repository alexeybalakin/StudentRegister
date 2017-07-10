package ru.android.innocurses.studentregister.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.android.innocurses.studentregister.Activities.ProfileActivity;
import ru.android.innocurses.studentregister.Activities.StudentsActivity;
import ru.android.innocurses.studentregister.Adapters.GroupListAdapter;
import ru.android.innocurses.studentregister.Adapters.StudentListAdapter;
import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.Models.SQLite.DBHelper;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

/**
 * Created by admin on 29.06.2017.
 */

public class FragmentStudent extends Fragment {
    private RecyclerView rvStudents;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_students,container,true);

        rvStudents = (RecyclerView) fragment.findViewById(R.id.rvStudents);




      //  List<Student> students =  ManagerGroups.groups.get("Group#1").getStudents();
        ManagerGroups managerGroups = new ManagerGroups(getActivity());
        List<Student> students = ManagerGroups.getStudents();

        final StudentListAdapter studentListAdapter = new StudentListAdapter(getActivity(),students);
        rvStudents.setAdapter(studentListAdapter);
        registerForContextMenu(rvStudents);
        rvStudents.setLayoutManager(new LinearLayoutManager(getActivity()));

        return fragment;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Student student = ((StudentListAdapter)rvStudents.getAdapter()).selectedStudent;
        Intent myIntent = new Intent(Intent.ACTION_DIAL);
        myIntent.setData(Uri.parse("tel:"+student.getPhoneNumber()));
        myIntent.resolveActivity(getActivity().getPackageManager());
        startActivity(myIntent);

        return super.onContextItemSelected(item);
    }

}
