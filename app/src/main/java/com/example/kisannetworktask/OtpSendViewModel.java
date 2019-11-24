package com.example.kisannetworktask;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kisannetworktask.pojo.ContactDao;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.MessageResponse;
import com.example.kisannetworktask.pojo.SendSmsReq;
import com.example.kisannetworktask.pojo.SentSmsDAO;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.repositories.ContactsRepository;
import com.example.kisannetworktask.repositories.SmsRepositoryImpl;

import java.util.List;

public class OtpSendViewModel extends AndroidViewModel {
    private SmsRepositoryImpl smsRepository;

    public OtpSendViewModel(@NonNull Application application) {
        super(application);
        smsRepository=new SmsRepositoryImpl(application);
    }
//    public void sendSms(SendSmsReq sendSmsReq){
//        smsRepository.sendSms(sendSmsReq);
//    }
public void sendSms(FastSmsPojo sendSmsReq){
    smsRepository.sendSms(sendSmsReq);
}
    public void insert(SentSmsPojo sentSmsPojo){
        smsRepository.insert(sentSmsPojo);

    }

    public MutableLiveData<MessageResponse> getLiveData(){
      return   smsRepository.getLiveData();
    }
    public LiveData<List<SentSmsPojo>> getAllSentSms(){
        return smsRepository.getAllSmsSent();

    }
//    public void insert(ContactPojo contactPojo) {
//        new ContactsRepository.InsertNoteAsyncTask(contactDao).execute(contactPojo);
//    }

}
