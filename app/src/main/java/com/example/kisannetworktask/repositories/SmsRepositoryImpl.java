package com.example.kisannetworktask.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kisannetworktask.FastSmsPojo;
import com.example.kisannetworktask.FastSmsResponse;
import com.example.kisannetworktask.pojo.ContactDatabase;
import com.example.kisannetworktask.pojo.MessageResponse;
import com.example.kisannetworktask.pojo.SentSmsDAO;
import com.example.kisannetworktask.pojo.SentSmsPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SmsRepositoryImpl implements SmsRepository {
    private SmsHttpInterface smsHttpInterface;
    private SentSmsDAO sentSmsDAO;
    private MutableLiveData<MessageResponse> mutableLiveData;
    private static final String TAG = "SmsRepositoryImpl";
    public SmsRepositoryImpl(Application application) {
        ContactDatabase database = ContactDatabase.getInstance(application);
        sentSmsDAO = database.sentSmsDAO();
        mutableLiveData=new MutableLiveData<>();
        this.smsHttpInterface= RetrofitClientInstance.getRetrofitInstance().create(SmsHttpInterface.class);

    }

//    @Override
//    public void sendSms(SendSmsReq sendSmsReq) {
//         Call<MessageResponse> call=smsHttpInterface.sendSms(sendSmsReq,"305330A0wNGvsyKRN5dd911c0","application/json");
//        call.enqueue(new Callback<MessageResponse>() {
//            @Override
//            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
//                Log.d(TAG, "onResponse: "+response.code());
//                if(response.code()==200){
//                    mutableLiveData.postValue(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MessageResponse> call, Throwable t) {
//                Log.d(TAG, "onFailure: "+t.getMessage());
//            }
//        });
//    }


    @Override
    public void sendSms(FastSmsPojo sendSmsReq) {
        Call<FastSmsResponse> call=smsHttpInterface.sendSms(sendSmsReq);
        call.enqueue(new Callback<FastSmsResponse>() {
            @Override
            public void onResponse(Call<FastSmsResponse> call, Response<FastSmsResponse> response) {
                Log.d(TAG, "onResponse: "+response.code()+response.message());
                if(response.code()==200){
                    Log.d(TAG, "onResponse: "+response.body().getMessage().get(0));
                }
            }

            @Override
            public void onFailure(Call<FastSmsResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

    @Override
    public MutableLiveData<MessageResponse> getLiveData() {
        return  mutableLiveData;
    }

    @Override
    public void insert(SentSmsPojo sentSmsPojo) {
//        sentSmsDAO.insert(sentSmsPojo);
        new InsertNoteAsyncTask(sentSmsDAO).execute(sentSmsPojo);
    }

    @Override
    public LiveData<List<SentSmsPojo>> getAllSmsSent() {
        return sentSmsDAO.getAllSmsSent();
    }
    private static class InsertNoteAsyncTask extends AsyncTask<SentSmsPojo, Void, Void> {
        private SentSmsDAO contactDao1;

        private InsertNoteAsyncTask(SentSmsDAO contactDao) {
            this.contactDao1 = contactDao;
        }



        @Override
        protected Void doInBackground(SentSmsPojo... sentSmsPojos) {
            contactDao1.insert(sentSmsPojos[0]);

            return null;
        }
    }
}
