package com.example.kisannetworktask.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.kisannetworktask.Constants;
import com.example.kisannetworktask.R;
import com.example.kisannetworktask.databinding.ActivityAddContactBinding;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.viewModels.AddContactViewModel;

import java.util.List;

public class AddContactActivity extends AppCompatActivity {
    private boolean isRetrieved;
    private static final String TAG = "AddContactActivity";
    private AddContactViewModel addContactViewModel;
    private ActivityAddContactBinding activityAddContactBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isRetrieved=false;
        activityAddContactBinding= DataBindingUtil.setContentView(this, R.layout.activity_add_contact);
addContactViewModel= ViewModelProviders.of(this).get(AddContactViewModel.class);
addContactViewModel.getAllContacts().observe(this, new Observer<List<ContactPojo>>() {
    @Override
    public void onChanged(List<ContactPojo> contactPojos) {

        for (int i = 0; i <contactPojos.size() ; i++) {
            Log.d(TAG, "onChanged: "+contactPojos.get(i).getContact());
        }
    }
});

        activityAddContactBinding.addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                JSONObject obj=convertJson();
                String firstName=activityAddContactBinding.firstNameEditText.getText().toString();
            String lastName=activityAddContactBinding.lastNameEditText.getText().toString();
            String phone=activityAddContactBinding.phoneEditText.getText().toString();
            if(firstName.length()>0 && lastName.length()>0 && isNumberRight(phone)) {
                ContactPojo contactPojo = new ContactPojo(firstName, lastName, phone);
                Intent data = new Intent();
                data.putExtra(Constants.CONTACT_POJO, contactPojo);

                setResult(RESULT_OK, data);
                finish();
            }
            else if(firstName.length()==0 || lastName.length()==0 || phone.length()==0){
                Toast.makeText(AddContactActivity.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();

            }
            else if(!isNumberRight(phone)){
                Toast.makeText(AddContactActivity.this, "Enter Correct Phone Number", Toast.LENGTH_SHORT).show();

            }
            else {

                Toast.makeText(AddContactActivity.this, "Details are Wrong", Toast.LENGTH_SHORT).show();
            }
//            addContactViewModel.insert(contactPojo);
//                finish();



            }
        });
        activityAddContactBinding.clearDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityAddContactBinding.firstNameEditText.setText("");
                activityAddContactBinding.lastNameEditText.setText("");
                activityAddContactBinding.phoneEditText.setText("");
            }
        });
        activityAddContactBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
   finish();

            }
        });
    }

    public static boolean isNumberRight(String mobile){
        return mobile.matches("[1-9][0-9]{9}");
    }
}
