package com.example.kisannetworktask;

import android.util.Log;

import com.nexmo.client.HttpConfig;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import java.io.IOException;

public class NexmoHelper {
    private static final String TAG = "NexmoHelper";

    public void sendSms() throws IOException, NexmoClientException {

        HttpConfig httpConfig = HttpConfig.builder()
                .apiBaseUri("https://api.example.com")
                .restBaseUri("https://rest.example.com")
                .snsBaseUri("https://sns.example.com")
                .build();

        NexmoClient client = NexmoClient.builder()
                .apiKey("9f8aef53")
                .apiSecret("OGlNDdpiRYwmt8jQ")
                .httpConfig(httpConfig)
                .build();
        String messageText = "Hello from Nexmo";
        TextMessage message = new TextMessage("Nexmo", "918766330660", messageText);

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
            Log.d(TAG, "sendSms: "+responseMessage);
        }
    }
}
