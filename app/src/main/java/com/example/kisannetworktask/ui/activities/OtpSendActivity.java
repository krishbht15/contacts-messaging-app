package com.example.kisannetworktask.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import com.example.kisannetworktask.Constants;
import com.example.kisannetworktask.R;
import com.example.kisannetworktask.databinding.ActivityOtpSendBinding;
import com.example.kisannetworktask.pojo.ContactPojo;
import com.example.kisannetworktask.pojo.SentSmsPojo;
import com.example.kisannetworktask.viewModels.OtpSendViewModel;

import java.util.concurrent.ExecutionException;

import okhttp3.Response;

public class OtpSendActivity extends AppCompatActivity {
    private ContactPojo contactPojo;

    private OtpSendViewModel otpSendViewModel;

    private ActivityOtpSendBinding activityOtpSendBinding;
    private static final String TAG = "OtpSendActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOtpSendBinding = DataBindingUtil.setContentView(this, R.layout.activity_otp_send);
        otpSendViewModel = ViewModelProviders.of(this).get(OtpSendViewModel.class);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        contactPojo = (ContactPojo) getIntent().getSerializableExtra(Constants.CONTACT_POJO);
        activityOtpSendBinding.phoneNumber.setText(contactPojo.getContact());


        activityOtpSendBinding.sendMessage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isNetworkAvailable(OtpSendActivity.this)) {

                    String phonNumber = contactPojo.getContact();
                    String otp = activityOtpSendBinding.yourTextAnswer.getText().toString();
                    String url = "http://2factor.in/API/V1/fd930f73-0e20-11ea-9fa5-0200cd936042/SMS/" + phonNumber + "/" + otp;
                    Response response = null;
                    try {
                        response = otpSendViewModel.sendSms(url);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (response.code() == 200) {
                        SentSmsPojo sentSmsPojo = new SentSmsPojo(contactPojo.getFirstName(), contactPojo.getLastName(), contactPojo.getContact());
                        Intent data = new Intent();
                        data.putExtra(Constants.SENT_CONTACT, sentSmsPojo);

                        setResult(RESULT_OK, data);
                        finish();
                    } else {
                        Toast.makeText(OtpSendActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(OtpSendActivity.this, "You are not connected to the internet", Toast.LENGTH_SHORT).show();
                }
            }

        });
}


    @SuppressLint("MissingPermission")
    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
