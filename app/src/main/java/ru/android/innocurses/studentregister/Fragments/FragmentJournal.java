package ru.android.innocurses.studentregister.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.android.innocurses.studentregister.Adapters.JournalListAdapter;
import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Managers.ManagerJournal;
import ru.android.innocurses.studentregister.Models.Journal;
import ru.android.innocurses.studentregister.Models.Lesson;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

/**
 * Created by admin on 29.06.2017.
 */

public class FragmentJournal extends Fragment{
    private RecyclerView rvJournals;
    private Student student;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_journals, container,true);
        rvJournals = (RecyclerView) fragment.findViewById(R.id.rvJournals);

  //      Student student = (Student) savedInstanceState.getSerializable("student");

     //  Student student = ManagerGroups.groups.get("Group#1").getStudents().get(0);
        List<Journal> journalForStudent = new ArrayList<>();
        for (Journal journal: ManagerGroups.journalList){
            Log.i("Mylog",""+ (student.getId().equals(journal.getStudent().getId())));
            if(student.equals(journal.getStudent())) {
                journalForStudent.add(journal);
            }
        }
        JournalListAdapter journalListAdapter = new JournalListAdapter(journalForStudent);
        rvJournals.setAdapter(journalListAdapter);
        rvJournals.setLayoutManager(new LinearLayoutManager(getActivity()));
       return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        student = (Student) getActivity().getIntent().getSerializableExtra("student");

    }
}
