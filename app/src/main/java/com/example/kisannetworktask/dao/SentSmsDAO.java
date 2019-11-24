package com.example.kisannetworktask.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.kisannetworktask.pojo.SentSmsPojo;

import java.util.List;

@Dao
public interface SentSmsDAO {
    @Insert
    void insert(SentSmsPojo contact);


    @Query("SELECT * FROM sent_msgs")
    LiveData<List<SentSmsPojo>> getAllSmsSent();
}
