package com.example.kisannetworktask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.kisannetworktask.databinding.ActivityOtpSendBinding;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.MessageResponse;
import com.example.kisannetworktask.pojo.SMS;
import com.example.kisannetworktask.pojo.SendSmsReq;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.repositories.SmsRepositoryImpl;
import com.msg91.sendotpandroid.library.SendOtpVerification;
import com.msg91.sendotpandroid.library.Verification;
import com.msg91.sendotpandroid.library.VerificationListener;
import com.nexmo.client.NexmoClientException;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kong.unirest.Unirest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//import com.example.kisannetworktask.pojo.TwilloHelper;

public class OtpSendActivity extends AppCompatActivity {
    private ContactPojo contactPojo;

    private NexmoHelper nexmoHelper;
    private OtpSendViewModel otpSendViewModel;

    private ActivityOtpSendBinding activityOtpSendBinding;
    private static final String TAG = "OtpSendActivity";
    private SendSmsReq sendSmsReq=new SendSmsReq();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOtpSendBinding= DataBindingUtil.setContentView(this,R.layout.activity_otp_send);
        otpSendViewModel= ViewModelProviders.of(this).get(OtpSendViewModel.class);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        nexmoHelper=new NexmoHelper();
        contactPojo= (ContactPojo) getIntent().getSerializableExtra(Constants.CONTACT_POJO);
        activityOtpSendBinding.phoneNumber.setText(contactPojo.getContact());


        SMS sms1=new SMS();
        sms1.setMessage("Hello everyone");
      sms1.getTo().add("8766330660");
      sendSmsReq.getSms().add(sms1);
      

        sendSmsReq.setCountry("91");
        sendSmsReq.setRoute("4");
        sendSmsReq.setSender("SOCKET");
        final FastSmsPojo fastSmsPojo=new FastSmsPojo();
        fastSmsPojo.setSender_id("FSTSMS");
        activityOtpSendBinding.sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                otpSendViewModel.sendSms(fastSmsPojo);
//                    otpSendViewModel.sendSms(fastSmsPojo);
//                HttpResponse<String> response = Unirest.get("http://2factor.in/API/V1/293832-67745-11e5-88de-5600000c6b13/SMS/991991199/AUTOGEN")
//                        .header("content-type", "application/x-www-form-urlencoded")
//                        .asString();
//                OkHttpClient client = new OkHttpClient();
String x=contactPojo.getContact();
//                Request request = new Request.Builder()
//                        .url("http://2factor.in/API/V1/fd930f73-0e20-11ea-9fa5-0200cd936042/SMS/"+x+"/AUTOGEN")
//                        .get()
//                        .addHeader("content-type", "application/x-www-form-urlencoded")
//                        .build();

                Response response = null;
                OkHttpClient client = new OkHttpClient();
String otp=activityOtpSendBinding.yourTextAnswer.getText().toString();
                Request request = new Request.Builder()
                        .url("http://2factor.in/API/V1/fd930f73-0e20-11ea-9fa5-0200cd936042/SMS/"+x+"/"+otp)
                        .get()
                        .addHeader("content-type", "application/x-www-form-urlencoded")
                        .build();
//https://www.fast2sms.com/dev/bulk?authorization=drBUuYvcAqKfbelR6NhiwZQyWmgkIxznXp1J2FjL9aHG8O3S7T48ikldrPCUcVJL3v5aYDo9wzjQZuTA&sender_id=FSTSMS&message=ramramji&language=english&route=p&numbers=7838238498
//                Request request = new Request.Builder()
//                        .url("https://www.fast2sms.com/dev/bulk?authorization=drBUuYvcAqKfbelR6NhiwZQyWmgkIxznXp1J2FjL9aHG8O3S7T48ikldrPCUcVJL3v5aYDo9wzjQZuTA&sender_id=FSTSMS&message=ramramji&language=english&route=p&numbers=8285139369")
//                        .get()
//                        .addHeader("content-type", "application/x-www-form-urlencoded")
//                        .build();
//                Response response =null;
                try {
                    response = client.newCall(request).execute();
                    if(response.code()==200) {
                        SentSmsPojo sentSmsPojo = new SentSmsPojo(contactPojo.getFirstName(), contactPojo.getLastName(), contactPojo.getContact());
                        Intent data = new Intent();
                        data.putExtra(Constants.SENT_CONTACT, sentSmsPojo);

                        setResult(RESULT_OK, data);
                        finish();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        otpSendViewModel.getLiveData().observe(this, new Observer<MessageResponse>() {
            @Override
            public void onChanged(MessageResponse messageResponse) {
                Log.d(TAG, "onChanged: ");
                if(messageResponse.getMessage()=="success"){


//                    otpSendViewModel.insert(sentSmsPojo);
                }
            }
        });
        otpSendViewModel.getAllSentSms().observe(this, new Observer<List<SentSmsPojo>>() {
            @Override
            public void onChanged(List<SentSmsPojo> sentSmsPojos) {


            }
        });
    }
}
