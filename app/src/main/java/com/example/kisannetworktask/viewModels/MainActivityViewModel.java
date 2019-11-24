package com.example.kisannetworktask.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.repositories.ContactsRepository;
import com.example.kisannetworktask.repositories.SmsRepository;
import com.example.kisannetworktask.repositories.SmsRepositoryImpl;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private ContactsRepository repository;
    private SmsRepository smsRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository=new ContactsRepository(application);
        smsRepository=new SmsRepositoryImpl(application);
    }
    public void insert(ContactPojo contactPojo){
        repository.insert(contactPojo);
    }
    public LiveData<List<ContactPojo>> getAllContacts(){
        return repository.getAllContacts();
    }
    public void inserSent(SentSmsPojo sentSmsPojo){
        smsRepository.insert(sentSmsPojo);
    }

}
