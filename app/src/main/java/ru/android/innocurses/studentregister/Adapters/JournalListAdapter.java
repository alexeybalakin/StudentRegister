package ru.android.innocurses.studentregister.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.android.innocurses.studentregister.Activities.ProfileActivity;
import ru.android.innocurses.studentregister.Models.Journal;
import ru.android.innocurses.studentregister.Models.Lesson;
import ru.android.innocurses.studentregister.Models.Student;
import ru.android.innocurses.studentregister.R;


/**
 * Created by admin on 22.06.2017.
 */

public class JournalListAdapter extends RecyclerView.Adapter{
    private List<Journal> dataSet;
    private  final List<Journal> cleanCopyDataSet;



    public JournalListAdapter(List<Journal> journals) {
        this.dataSet = journals;
        this.cleanCopyDataSet = journals;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.journal_item, parent, false);
        return new JournalListAdapter.JournalHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((JournalListAdapter.JournalHolder) holder).bind(dataSet.get(position));
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }




    private class JournalHolder extends RecyclerView.ViewHolder  {

        private TextView tvLesson;
        private CheckBox cbPresents;
        private Journal journal;

        public JournalHolder(View itemView) {
            super(itemView);
            tvLesson = (TextView) itemView.findViewById(R.id.tvLesson);
            cbPresents = (CheckBox) itemView.findViewById(R.id.cbPresents);

        }

        public void bind(Journal journal) {
            this.journal = journal;
            tvLesson.setText(journal.getLesson().getName());
            cbPresents.setChecked(journal.isPresent());
        }


    }
    public void filter(String charText) {
        charText = charText.toLowerCase();
        dataSet = new ArrayList<>();
        if (charText.length() == 0) {
            dataSet.addAll(cleanCopyDataSet);
        } else {
            for (Journal item : cleanCopyDataSet) {
                if (item.getLesson().getName().toLowerCase().contains(charText)) {
                    dataSet.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}

