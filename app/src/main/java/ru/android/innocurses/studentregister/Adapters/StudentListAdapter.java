package ru.android.innocurses.studentregister.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import ru.android.innocurses.studentregister.Activities.ProfileActivity;
import ru.android.innocurses.studentregister.Fragments.FragmentStudent;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;

/**
 * Created by admin on 29.06.2017.
 */

public class StudentListAdapter extends Adapter {
    private List<Student> dataSet;
    private  final List<Student> cleanCopyDataSet;
    private Context context;
    public Student selectedStudent;



    public StudentListAdapter(Context context, List<Student> students) {
        this.context = context;
        this.dataSet = students;
        this.cleanCopyDataSet = students;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new StudentListAdapter.StudentHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((StudentListAdapter.StudentHolder) holder).bind(dataSet.get(position));
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public Student getItem (int position){
        return dataSet.get(position);
    }




    private class StudentHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener {

        private final TextView studentName;
        private Student student;


        public StudentHolder(View itemView) {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.tvGroup);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }



        public void bind(Student student) {
            this.student = student;
            studentName.setText(student.toString());
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(itemView.getContext(), ProfileActivity.class);
                i.putExtra("student", student);
                v.getContext().startActivity(i);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            MenuInflater menuInflater = ((Activity)context).getMenuInflater();
            menuInflater.inflate(R.menu.menu_student, menu);
            selectedStudent =  dataSet.get(getAdapterPosition());
        }


    }
    public void filter(String charText) {
        charText = charText.toLowerCase();
        dataSet = new ArrayList<>();
        if (charText.length() == 0) {
            dataSet.addAll(cleanCopyDataSet);
        } else {
            for (Student item : cleanCopyDataSet) {
                if (item.toString().toLowerCase().contains(charText)) {
                    dataSet.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
