package com.example.a62510.weidunproject;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class User_register_Activity extends AppCompatActivity implements View.OnClickListener{
    String password1,password2,username;
    String regist_response;
    public static final int regist_success = 1;
    public static final int regist_failed = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case regist_failed:{
                    Toast.makeText(User_register_Activity.this,"注册失败，请重试",Toast.LENGTH_SHORT).show();
                    break;
                }
                case regist_success:{
                    Toast.makeText(User_register_Activity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                    finish();
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
        if(getSupportActionBar()!=null){//用来隐藏标题栏
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_user_register_);
        Button return_button = (Button)findViewById(R.id.注册界面返回按钮);
        Button register_button = (Button)findViewById(R.id.注册界面注册按钮);
        return_button.setOnClickListener(this);
        register_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.注册界面注册按钮:{
                EditText wordText1 = (EditText)findViewById(R.id.注册界面密码框);
                EditText wordText2 = (EditText)findViewById(R.id.注册界面密码确认框);
                EditText account = (EditText)findViewById(R.id.注册界面账号框);
                password1 = wordText1.getText().toString();
                password2 = wordText2.getText().toString();
                username = account.getText().toString();

                if(password1.isEmpty() || password2.isEmpty() || username.isEmpty()){
                    Toast.makeText(User_register_Activity.this,"请输入账号或密码",Toast.LENGTH_SHORT).show();
                } else if(!password1.equals(password2)){
                    Toast.makeText(User_register_Activity.this,"密码不一致，请重新输入！",Toast.LENGTH_SHORT).show();
                }else{
                    SendRequestWithOkhttp.registerRequest("http://118.89.227.63:8000/api/token/post",username,password1,"A/B/C", new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            regist_response = response.body().string();
                            Gson gson = new Gson();
                            Login_Response registMessage = gson.fromJson(regist_response,Login_Response.class);
                            if(registMessage.getCode()!=0){
                                Message message1 = new Message();
                                message1.what = regist_failed;
                                handler.sendMessage(message1);
                            }
                            else{
                                Message message3 = new Message();
                                message3.what = regist_success;
                                handler.sendMessage(message3);
//                                Looper.prepare();
//                                String err_message=registMessage.getErr_msg();
//                                int err_code=registMessage.getCode();
//                                Toast.makeText(User_register_Activity.this,err_code+"",Toast.LENGTH_SHORT).show();
//                                Looper.loop();
                            }
                        }
                    });
                }
                break;
            }
            case R.id.注册界面返回按钮:{
                finish();
                break;
            }
            default:
                break;
        }
    }

}
