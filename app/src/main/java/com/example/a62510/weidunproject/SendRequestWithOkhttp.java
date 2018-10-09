package com.example.a62510.weidunproject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by 62510 on 2018/4/9.
 */

public class SendRequestWithOkhttp {
    public static void loginRequest(String address,String username,String password,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        String url = address+"?username="+username+"&password="+password;
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
    public static void registerRequest(String address,String username,String password,String device,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("username",username)
                .add("password",password)
                .add("device",device)
                .build();
        final Request request = new Request.Builder()
                .url(address)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(callback);
    }
    public static void deviceRequest(String address,String token,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader("Authorization","Bearer "+token)
                .url(address).build();
        client.newCall(request).enqueue(callback);
    }
    public static void Information_Request(String address,String token,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader("Authorization","Bearer "+token)
                .url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
