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

import ru.android.innocurses.studentregister.Adapters.ContactListAdapter;
import ru.android.innocurses.studentregister.Adapters.JournalListAdapter;
import ru.android.innocurses.studentregister.Managers.ManagerGroups;
import ru.android.innocurses.studentregister.Models.Contact;
import ru.android.innocurses.studentregister.Models.Journal;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

/**
 * Created by admin on 30.06.2017.
 */

public class FragmetContact extends Fragment {
    private RecyclerView rvContacts;
    private Student student;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_contacts, container, true);
        rvContacts = (RecyclerView) fragment.findViewById(R.id.rvContacts);

        List<Contact> contacts = student.getContacts();

        ContactListAdapter contactListAdapter = new ContactListAdapter(contacts);
        rvContacts.setAdapter(contactListAdapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        student = (Student) getActivity().getIntent().getSerializableExtra("student");

    }
}