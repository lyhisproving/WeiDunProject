package com.example.a62510.weidunproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//个人主页

public class Personal_Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_);
        Button dynamic_button = (Button)findViewById(R.id.personal_动态);
        Button notice_button = (Button)findViewById(R.id.personal_通知);
        dynamic_button.setOnClickListener(this);
        notice_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.personal_动态:


                break;
            case R.id.personal_通知:


                break;
            default:
                break;
        }
    }
}
