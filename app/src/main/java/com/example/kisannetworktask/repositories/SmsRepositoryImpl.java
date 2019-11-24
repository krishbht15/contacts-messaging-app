package com.example.kisannetworktask.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.kisannetworktask.dao.ContactDatabase;
import com.example.kisannetworktask.dao.SentSmsDAO;
import com.example.kisannetworktask.pojo.SentSmsPojo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SmsRepositoryImpl implements SmsRepository {
    private SentSmsDAO sentSmsDAO;
    private static final String TAG = "SmsRepositoryImpl";
    public SmsRepositoryImpl(Application application) {
        ContactDatabase database = ContactDatabase.getInstance(application);
        sentSmsDAO = database.sentSmsDAO();

    }





    @Override
    public void insert(SentSmsPojo sentSmsPojo) {
        new InsertNoteAsyncTask(sentSmsDAO).execute(sentSmsPojo);
    }

    @Override
    public LiveData<List<SentSmsPojo>> getAllSmsSent() {
        return sentSmsDAO.getAllSmsSent();
    }

    @Override
    public Response sendSms(String url) throws ExecutionException, InterruptedException {
        return new SendSmsAsyncTask().execute(url).get();
    }


    private static class SendSmsAsyncTask extends AsyncTask<String,Void,Response>{


        public SendSmsAsyncTask() {
        }

        @Override
    protected Response doInBackground(String... strings) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(strings[0])
                .get()
                .addHeader("content-type", "application/phonNumber-www-form-urlencoded")
                .build();
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
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
