package com.example.kisannetworktask.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.repositories.ContactsRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private ContactsRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository=new ContactsRepository(application);
    }
    public void insert(ContactPojo contactPojo){
        repository.insert(contactPojo);
    }
    public LiveData<List<ContactPojo>> getAllContacts(){
        return repository.getAllContacts();
    }
}
