package com.example.kisannetworktask.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.kisannetworktask.Constants;
import com.example.kisannetworktask.R;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.viewModels.MainActivityViewModel;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Toast;

import com.example.kisannetworktask.adapters.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_NOTE_REQUEST = 1;
    public static final int  ADD_CONTACT_SENT=2;
    private static final String TAG = "MainActivity";
    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            Log.d(TAG, "onActivityResult: aafya aandr");
            ContactPojo contactPojo= (ContactPojo) data.getSerializableExtra(Constants.CONTACT_POJO);
            mainActivityViewModel.insert(contactPojo);

            Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show();
        } if (requestCode == ADD_CONTACT_SENT && resultCode == RESULT_OK) {
            SentSmsPojo sentSmsPojo= (SentSmsPojo) data.getSerializableExtra(Constants.SENT_CONTACT);
            mainActivityViewModel.inserSent(sentSmsPojo);
            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
              }


    }
}