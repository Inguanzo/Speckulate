package com.speckulate.speckulate.Feed;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.speckulate.speckulate.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<ContactInfo> contactList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.name.setText(ci.name);
        contactViewHolder.email.setText(ci.email);
        contactViewHolder.title.setText(R.string.name);
        contactViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("ContactAdapter", "onClick");


            }
        });
    }

    public void addItem() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.name = "example";
        contactList.add(contactInfo);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected ImageView profilePhoto;
        protected TextView name;
        protected TextView email;
        protected TextView title;

        public ContactViewHolder(View view) {
            super(view);
            profilePhoto = (ImageView) view.findViewById(R.id.profile_photo);
            name =  (TextView) view.findViewById(R.id.name);
            email = (TextView)  view.findViewById(R.id.email);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

}