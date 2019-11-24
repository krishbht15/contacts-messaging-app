package com.example.kisannetworktask.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisannetworktask.Constants;
import com.example.kisannetworktask.OtpSendActivity;
import com.example.kisannetworktask.R;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.SentSmsPojo;

import java.util.List;

public class ContactsCommonAdapter extends RecyclerView.Adapter<ContactsCommonAdapter.ContactsViewHolder> {
        List<ContactPojo> contacts;
        List<SentSmsPojo> sent;
        private int checkWhichClass=-1;

    public ContactsCommonAdapter(List<ContactPojo> contacts, List<SentSmsPojo> sent, int checkWhichClass) {
        this.contacts = contacts;
        this.sent = sent;
        this.checkWhichClass = checkWhichClass;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_card,parent,false);

       return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactsViewHolder holder, final int position) {
       if(checkWhichClass==1) {
           holder.first.setText(contacts.get(position).getFirstName());
           holder.last.setText(contacts.get(position).getLastName());
           holder.msgSent.setVisibility(View.GONE);

           holder.contact.setText(contacts.get(position).getContact());
           holder.view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (checkWhichClass == 1) {
                       Intent intent = new Intent(holder.view.getContext(), OtpSendActivity.class);
                       intent.putExtra(Constants.CONTACT_POJO, contacts.get(position));
                       ((Activity)  holder.view.getContext()).startActivityForResult(intent,2);
                   }
               }
           });
       }else if(checkWhichClass==2){
           holder.first.setText(sent.get(position).getFirstName());
           holder.last.setText(sent.get(position).getLastName());
           holder.msgSent.setVisibility(View.VISIBLE);
           holder.contact.setText(sent.get(position).getContact());
       }

    }

    @Override
    public int getItemCount() {
        if(checkWhichClass==2){
            return sent.size();
        }
        return contacts.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder{
        private TextView first,last,contact;
        private ImageView msgSent;
        private View view;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            first=itemView.findViewById(R.id.firstNameTextAnswer);
            last=itemView.findViewById(R.id.lastNameTextAnswer);
            contact=itemView.findViewById(R.id.contactNumber);
            msgSent=itemView.findViewById(R.id.msgSent);
            view=itemView;
        }
    }
}
