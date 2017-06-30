package ru.android.innocurses.studentregister.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.android.innocurses.studentregister.Models.Group;
import ru.android.innocurses.studentregister.R;



/**
 * Created by admin on 23.06.2017.
 */

public class GroupListAdapter extends RecyclerView.Adapter {
    private  List<Group> dataSet;
    private  final List<Group> cleanCopyDataSet;
    private View.OnClickListener itemClickListener;

    public GroupListAdapter(List<Group> groups) {
        this.dataSet = groups;
        this.cleanCopyDataSet = groups;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new GroupHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GroupHolder) holder).bind((Group) dataSet.get(position));
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void delete(int position) {
        dataSet.remove(position);
        notifyItemRemoved(position);
    }

    public void delete(Group group) {
        int position = dataSet.indexOf(group);
        delete(position);
    }

    public void startGroup(View view, Group group) {
        itemClickListener.onClick(view);
    }

    public void onItemClickListener(View.OnClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    private class GroupHolder extends RecyclerView.ViewHolder {

        private final TextView groupName;
        private Group group;

        public GroupHolder(View itemView) {
            super(itemView);
            groupName = (TextView) itemView.findViewById(R.id.tvGroup);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startGroup(view, group);
                }
            });
        }

        public void bind(Group group) {
            this.group = group;
            groupName.setText(group.getName());
        }
    }
    public void filter(String charText) {
        charText = charText.toLowerCase();
        dataSet = new ArrayList<>();
        if (charText.length() == 0) {
            dataSet.addAll(cleanCopyDataSet);
        } else {
            for (Group item : cleanCopyDataSet) {
                if (item.toString().toLowerCase().contains(charText)) {
                    dataSet.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}