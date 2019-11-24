package com.example.kisannetworktask.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.repositories.SmsRepositoryImpl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class OtpSendViewModel extends AndroidViewModel {
    private SmsRepositoryImpl smsRepository;
    public Response sendSms(String  url) throws ExecutionException, InterruptedException {
        return smsRepository.sendSms(url);

    }
    public OtpSendViewModel(@NonNull Application application) {
        super(application);
        smsRepository=new SmsRepositoryImpl(application);
    }

    public void insert(SentSmsPojo sentSmsPojo){
        smsRepository.insert(sentSmsPojo);

    }

    public LiveData<List<SentSmsPojo>> getAllSentSms() {
        return smsRepository.getAllSmsSent();

    }

}
