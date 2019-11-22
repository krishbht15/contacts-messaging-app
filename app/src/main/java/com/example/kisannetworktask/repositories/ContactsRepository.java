package com.example.kisannetworktask.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.kisannetworktask.pojo.ContactDao;
import com.example.kisannetworktask.pojo.ContactDatabase;
import com.example.kisannetworktask.pojo.ContactPojo;

import java.util.List;

public class ContactsRepository {

    private ContactDao contactDao;

    public LiveData<List<ContactPojo>> getAllContacts() {
        return allContacts;
    }

    public void setAllContacts(LiveData<List<ContactPojo>> allContacts) {
        this.allContacts = allContacts;
    }

    private LiveData<List<ContactPojo>> allContacts;

    public ContactsRepository(Application application) {
        ContactDatabase database = ContactDatabase.getInstance(application);
        contactDao = database.noteDao();
        allContacts = contactDao.getAllContacts();
    }

    public void insert(ContactPojo contactPojo) {
        new InsertNoteAsyncTask(contactDao).execute(contactPojo);
    }
    private static class InsertNoteAsyncTask extends AsyncTask<ContactPojo, Void, Void> {
        private ContactDao contactDao1;

        private InsertNoteAsyncTask(ContactDao contactDao) {
            this.contactDao1 = contactDao;
        }

        @Override
        protected Void doInBackground(ContactPojo... contactPojos) {
            contactDao1.insert(contactPojos[0]);
            return null;
        }
    }

}
