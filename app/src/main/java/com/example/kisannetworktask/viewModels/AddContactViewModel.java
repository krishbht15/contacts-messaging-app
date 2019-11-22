package com.example.kisannetworktask.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.repositories.ContactsRepository;

import java.util.List;

public class AddContactViewModel extends AndroidViewModel {
    private ContactsRepository repository;

    public LiveData<List<ContactPojo>> getAllContacts() {
        return allContacts;
    }

    public void setAllContacts(LiveData<List<ContactPojo>> allContacts) {
        this.allContacts = allContacts;
    }

    private LiveData<List<ContactPojo>> allContacts ;

    public AddContactViewModel(@NonNull Application application) {
        super(application);
        repository = new ContactsRepository(application);
        allContacts = repository.getAllContacts();
    }

    public void insert(ContactPojo note) {
        repository.insert(note);
    }
}

