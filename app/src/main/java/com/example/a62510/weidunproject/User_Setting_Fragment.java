package com.example.a62510.weidunproject;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

//        将个人信息传入便于更改，更改结果还未返回


public class User_Setting_Fragment extends Fragment {

    private String name,gender,age,introduction;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        name = bundle.getString("name");
        gender = bundle.getString("gender");
        age = bundle.getString("age");
        introduction = bundle.getString("introduction");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_user__setting_, container, false);
        EditText edit_name = (EditText)view.findViewById(R.id.third_first_edit_姓名);
        EditText edit_gender = (EditText)view.findViewById(R.id.third_first_edit_性别);
        EditText edit_age = (EditText)view.findViewById(R.id.third_first_edit_年龄);
        EditText edit_introduction = (EditText)view.findViewById(R.id.third_first_edit_个人简介);
        edit_name.setText(name);
        edit_gender.setText(gender);
        edit_introduction.setText(introduction);
        edit_age.setText(age);
        return view;
    }

}
