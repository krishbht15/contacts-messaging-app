package com.example.kisannetworktask;



import com.textmagic.sdk.RestClient;
import com.textmagic.sdk.RestException;
import com.textmagic.sdk.resource.instance.TMNewMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

public class NexmoHelper {
    private static final String TAG = "NexmoHelper";

/*public class SMSSend {
public static void main(String[] args)
{ try {

}}*/

        public String sendSms() {
//            try {
//                // Construct data
////
//                Date mydate = new Date(System.currentTimeMillis());
//
//
//                URL url = new URL("https://global.datagenit.com/API/sms-api.php?auth=D!~1607UpxQGKV2nT&senderid=TXTSMS&msisdn=+918766330660&message=Hello Message");
//
//                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//                conn.setRequestMethod("GET");
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//                conn.setUseCaches(false);
//                conn.connect();
//                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String line;
//                StringBuffer buffer = new StringBuffer();
//                while ((line = rd.readLine()) != null)
//                {
//                    buffer.append(line).append("\n");
//                }
//                System.out.println(buffer.toString());
//                rd.close();
//                conn.disconnect();
//                return buffer.toString();
//            }catch(Exception e)
//
//            {
//                e.printStackTrace();
//                return e.getMessage();
//                }

            RestClient client = new RestClient("<username>", "<apiv2_key>");

            TMNewMessage m = client.getResource(TMNewMessage.class);
            m.setText("Hello from TextMagic Java");
            m.setPhones(Arrays.asList(new String[] {"8766330660"}));
            try {
                m.send();
            } catch (final RestException e) {
                System.out.println(e.getErrors());
                throw new RuntimeException(e);
            }
          return  String.valueOf(m.getId());
        }
         }


