package com.example.kisannetworktask.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kisannetworktask.FastSmsPojo;
import com.example.kisannetworktask.pojo.MessageResponse;
import com.example.kisannetworktask.pojo.SendSmsReq;
import com.example.kisannetworktask.pojo.SentSmsPojo;

import java.util.List;

public interface SmsRepository {
//    public void sendSms(SendSmsReq sendSmsReq);
    public void sendSms(FastSmsPojo sendSmsReq);

    public MutableLiveData<MessageResponse> getLiveData();
    public void insert(SentSmsPojo sentSmsPojo);
    public LiveData<List<SentSmsPojo>> getAllSmsSent();
}
