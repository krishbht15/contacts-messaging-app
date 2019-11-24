package com.example.kisannetworktask.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.repositories.ContactsRepository;
import com.example.kisannetworktask.repositories.SmsRepository;
import com.example.kisannetworktask.repositories.SmsRepositoryImpl;

import java.util.List;

public class PageViewModel extends AndroidViewModel {
    private ContactsRepository contactsRepository;
    private SmsRepository smsRepository;

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public LiveData<List<ContactPojo>> getAllContacts(){
        return contactsRepository.getAllContacts();
    }
    public PageViewModel(@NonNull Application application) {
        super(application);
        smsRepository=new SmsRepositoryImpl(application);
        contactsRepository=new ContactsRepository(application);
    }

    public void setIndex(int index) {
        mIndex.postValue(index);
    }
    public LiveData<List<SentSmsPojo>> getSentList(){
        return smsRepository.getAllSmsSent();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public MutableLiveData<Integer> getmIndex(){
        return mIndex;
    }
}