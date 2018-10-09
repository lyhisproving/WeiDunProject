package com.example.a62510.weidunproject;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;


public class First_Interface_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public final int device_success = 1;
    public final int device_failed = 0;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case device_success: {
                    Log.d("Device_Response", "success");
                    Intent device_intent = new Intent(getActivity(),Device_Activity.class);
                    Bundle bundle1 = msg.getData();
                    device_intent.putExtra("token",bundle1.getString("token"));
                    startActivity(device_intent);
                    break;
                }
                default:
                    break;
            }
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first__interface_,container,false);

        Bundle bundle = getArguments();
        final String token = bundle.getString("token");
        //Toast.makeText(getActivity(),token,Toast.LENGTH_SHORT).show();

        Button myequipment = (Button)view.findViewById(R.id.第一界面设备按钮);
        myequipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendRequestWithOkhttp.deviceRequest("http://118.89.227.63:8000/api/user/get",token,new okhttp3.Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String deviceResponse = response.body().string();
                        Gson gson = new Gson();
                        DeviceResponse deviceMessage = gson.fromJson(deviceResponse,DeviceResponse.class);

                        Message message = new Message();
                        message.what = device_success;
                        Bundle bundle = new Bundle();
                        bundle.putString("token",token);
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                });
            }
        });
        return view;
    }



}
