package com.example.kisannetworktask.repositories;

import com.example.kisannetworktask.FastSmsPojo;
import com.example.kisannetworktask.FastSmsResponse;
import com.example.kisannetworktask.pojo.MessageResponse;
import com.example.kisannetworktask.pojo.SendSmsReq;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SmsHttpInterface {

// @POST("api/v2/sendsms?country=91")
// public Call<MessageResponse> sendSms(@Body SendSmsReq req, @Header("authKey") String authkey,@Header("Content-Type") String contentType);


 @GET("bulk")
 public Call<FastSmsResponse> sendSms(@Body FastSmsPojo req);/*&numbers=8766330660*/
////public Call<FastSmsResponse> sendSms(FastSmsPojo smsPojo);
//public Call<FastSmsResponse> sendSms(@Body String  smsPojo);

}
