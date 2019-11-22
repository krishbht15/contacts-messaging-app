package com.example.kisannetworktask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.kisannetworktask.databinding.ActivityOtpSendBinding;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.nexmo.client.NexmoClientException;

import java.io.IOException;
//import com.example.kisannetworktask.pojo.TwilloHelper;

public class OtpSendActivity extends AppCompatActivity {
    private ContactPojo contactPojo;
    private NexmoHelper nexmoHelper;
    private ActivityOtpSendBinding activityOtpSendBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOtpSendBinding= DataBindingUtil.setContentView(this,R.layout.activity_otp_send);
//        twilloHelper=new TwilloHelper();
        nexmoHelper=new NexmoHelper();
        contactPojo= (ContactPojo) getIntent().getSerializableExtra(Constants.CONTACT_POJO);
        activityOtpSendBinding.phoneNumber.setText(contactPojo.getContact());
        activityOtpSendBinding.sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                twilloHelper.sendSms();
                try {
                    nexmoHelper.sendSms();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NexmoClientException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
