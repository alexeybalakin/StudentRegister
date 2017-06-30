package ru.android.innocurses.studentregister.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.android.innocurses.studentregister.Models.Contact;
import ru.android.innocurses.studentregister.R;

/**
 * Created by admin on 30.06.2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter {
    private List<Contact> dataSet;
    private  final List<Contact> cleanCopyDataSet;



    public ContactListAdapter(List<Contact> contacts) {
        this.dataSet = contacts;
        this.cleanCopyDataSet = contacts;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactListAdapter.ContactHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ContactListAdapter.ContactHolder) holder).bind(dataSet.get(position));
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }




    private class ContactHolder extends RecyclerView.ViewHolder  {

        private TextView tvContact;

        private Contact contact;

        public ContactHolder(View itemView) {
            super(itemView);
            tvContact = (TextView) itemView.findViewById(R.id.tvContact);

        }

        public void bind(Contact contact) {
           this.contact = contact;
            tvContact.setText(contact.getValue());
        }


    }
    public void filter(String charText) {
        charText = charText.toLowerCase();
        dataSet = new ArrayList<>();
        if (charText.length() == 0) {
            dataSet.addAll(cleanCopyDataSet);
        } else {
            for (Contact item : cleanCopyDataSet) {
                if (item.getValue().toLowerCase().contains(charText)) {
                    dataSet.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
