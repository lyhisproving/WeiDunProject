package com.example.a62510.weidunproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class Device_Activity extends AppCompatActivity implements View.OnClickListener{

    public String token;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    Log.d("Device_Response", "success");
                    Intent display_intent = new Intent(Device_Activity.this,Device_Display_Activity.class);
                    Bundle bundle1 = msg.getData();
                    display_intent.putExtra("token",bundle1.getString("token"));
                    startActivity(display_intent);
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
        setContentView(R.layout.activity_device_);
        setTitle("薇盾农业");
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        //Toast.makeText(Device_Activity.this,token,Toast.LENGTH_SHORT).show();
        Button button1 = (Button)findViewById(R.id.device1);
        Button button2 = (Button)findViewById(R.id.device2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.device1:{
//                Intent intent = new Intent(Device_Activity.this,Device_Display_Activity.class);
//                intent.putExtra("token",token);
//                startActivity(intent);
                SendRequestWithOkhttp.Information_Request("http://118.89.227.63:8000/api/current",token, new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String device_response = response.body().string();
                        Gson gson = new Gson();
                        Device_Information device_information = gson.fromJson(device_response,Device_Information.class);
                        int Code = device_information.getCode();
                       // if(Code==0){
                            Message message = new Message();
                            message.what = 1;
                            Bundle bundle = new Bundle();
                            bundle.putString("token",token);

                            //传递其他信息

                            message.setData(bundle);
                            handler.sendMessage(message);
//                        }
//                        else {
//
//                        }

                    }
                });
                break;
            }
            case R.id.device2:{
                Intent intent = new Intent(Device_Activity.this,Device_Display_Activity.class);
                startActivity(intent);
                //传送数据

                break;
            }
            default:
                break;
        }
    }
}
