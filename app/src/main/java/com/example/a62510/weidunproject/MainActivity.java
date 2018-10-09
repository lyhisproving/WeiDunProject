package com.example.a62510.weidunproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String login_response;
    public static final int Login_success = 1;
    public static final int Login_failed = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Login_failed: {
                    Toast.makeText(MainActivity.this, "账号或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    break;
                }
                case Login_success: {
                    Intent login_intent = new Intent(MainActivity.this, First_Interface_Activity.class);
                    String token = msg.getData().getString("token");
                    login_intent.putExtra("token",token);
                    startActivity(login_intent);
                    break;
                }
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {//用来隐藏标题栏
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        Button registerButton = (Button) findViewById(R.id.首界面注册按钮);
        final Button loginButton = (Button) findViewById(R.id.首界面登录按钮);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent = new Intent(MainActivity.this, User_register_Activity.class);
                startActivity(register_intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username,password;
                EditText nameEdit = (EditText)findViewById(R.id.首界面账号框);
                username = nameEdit.getText().toString();
                EditText wordEdit = (EditText)findViewById(R.id.首界面密码框);
                password = wordEdit.getText().toString();
                SendRequestWithOkhttp.loginRequest("http://118.89.227.63:8000/api/token/get"
                        ,username
                        ,password
                        , new okhttp3.Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        login_response = response.body().string();
                        Gson gson = new Gson();
                        Login_Response loginMessage = gson.fromJson(login_response, Login_Response.class);
                        if (loginMessage.getCode()==0){
                            Message message2 = new Message();
                            message2.what = Login_success;
                            String token =loginMessage.getData().getToken();
                            Bundle bundle = new Bundle();
                            bundle.putString("token",token);
                            message2.setData(bundle);
                            handler.sendMessage(message2);


                           // Looper.prepare();
                          //  Toast.makeText(MainActivity.this,token,Toast.LENGTH_SHORT).show();
                        //    Looper.loop();
                        }else {
                            Log.d("MainActivity", loginMessage.getErr_msg());
                            Message message1 = new Message();
                            message1.what = Login_failed;

                            handler.sendMessage(message1);
                        }
                    }
                });
            }
        });
    }
}
