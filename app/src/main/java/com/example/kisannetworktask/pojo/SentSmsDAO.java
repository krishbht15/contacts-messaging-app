package com.example.kisannetworktask.pojo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SentSmsDAO {
    @Insert
    void insert(SentSmsPojo contact);


    @Query("SELECT * FROM sent_msgs")
    LiveData<List<SentSmsPojo>> getAllSmsSent();
}
/*@Dao
public interface ContactDao {
    @Insert
    void insert(ContactPojo contact);


    @Query("SELECT * FROM contacts")
    LiveData<List<ContactPojo>> getAllContacts();
}*/