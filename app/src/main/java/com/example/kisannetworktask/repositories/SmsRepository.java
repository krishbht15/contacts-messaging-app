package com.example.kisannetworktask.repositories;

import androidx.lifecycle.LiveData;

import com.example.kisannetworktask.pojo.SentSmsPojo;

import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public interface SmsRepository {

    public void insert(SentSmsPojo sentSmsPojo);
    public LiveData<List<SentSmsPojo>> getAllSmsSent();
    public Response sendSms(String url) throws ExecutionException, InterruptedException;
}
