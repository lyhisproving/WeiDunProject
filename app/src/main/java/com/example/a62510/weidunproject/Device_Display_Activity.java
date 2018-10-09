package com.example.a62510.weidunproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Device_Display_Activity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device__display_);
        setTitle("当前数据信息");
        list = new ArrayList<>();
        initData();
        recyclerView = (RecyclerView)findViewById(R.id.device_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new DeviceAdapter(list));
        Button button = (Button)findViewById(R.id.history_button);
        button.setOnClickListener(this);
    }

    private void initData(){
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.history_button:{
                Intent intent = new Intent(Device_Display_Activity.this,History_Activity.class);
                startActivity(intent);

            }
        }
    }

}
