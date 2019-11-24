package com.example.kisannetworktask.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisannetworktask.ui.activities.AddContactActivity;
import com.example.kisannetworktask.R;
import com.example.kisannetworktask.adapters.ContactsCommonAdapter;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.viewModels.PageViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private List<ContactPojo> list;
    private List<SentSmsPojo> sentSmsPojoList;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView allContacts;
    private ContactsCommonAdapter contactsCommonAdapter;
    private Button addContact;
    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        linearLayoutManager=new LinearLayoutManager(getContext());
        list=new ArrayList<>();
        sentSmsPojoList=new ArrayList<>();
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        allContacts=root.findViewById(R.id.commonRecyclerView);

       addContact= root.findViewById(R.id.addContactButton);
       allContacts=root.findViewById(R.id.commonRecyclerView);

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), AddContactActivity.class);
                ((Activity)root.getContext()).startActivityForResult(intent, 1);

            }
        });
        pageViewModel.getAllContacts().observe(this, new Observer<List<ContactPojo>>() {
            @Override
            public void onChanged(List<ContactPojo> contactPojos) {
if(contactPojos.size()>list.size()){
    for (int i = list.size(); i <contactPojos.size() ; i++) {
        list.add(contactPojos.get(i));
    }
    contactsCommonAdapter.notifyDataSetChanged();
}
            }
        });
        pageViewModel.getSentList().observe(this, new Observer<List<SentSmsPojo>>() {
            @Override
            public void onChanged(List<SentSmsPojo> sentSmsPojos) {
                if(sentSmsPojos.size()>sentSmsPojoList.size()){
                    for (int i = sentSmsPojoList.size(); i <sentSmsPojos.size() ; i++) {
                        sentSmsPojoList.add(sentSmsPojos.get(i));
                    }
                    contactsCommonAdapter.notifyDataSetChanged();
                }
            }
        });
        pageViewModel.getmIndex().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer==1){
                    contactsCommonAdapter=new ContactsCommonAdapter(list,null,1);
                    allContacts.setLayoutManager(linearLayoutManager);
                    allContacts.setAdapter(contactsCommonAdapter);

                }
                else   if(integer==2){
                        contactsCommonAdapter=new ContactsCommonAdapter(null,sentSmsPojoList,2);

                        allContacts.setLayoutManager(linearLayoutManager);
                        allContacts.setAdapter(contactsCommonAdapter);
                        addContact.setVisibility(View.GONE);
                    }
            }
        });

        return root;
    }
}