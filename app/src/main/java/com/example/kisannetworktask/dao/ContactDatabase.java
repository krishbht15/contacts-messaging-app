package com.example.kisannetworktask.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.SentSmsPojo;

@Database(entities = {ContactPojo.class, SentSmsPojo.class}, version = 1,exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {
    private static ContactDatabase instance;

    public abstract ContactDao noteDao();
    public abstract SentSmsDAO sentSmsDAO();
    public static synchronized ContactDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ContactDatabase.class, "contact_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

