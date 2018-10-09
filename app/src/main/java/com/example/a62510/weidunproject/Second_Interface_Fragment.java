package com.example.a62510.weidunproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Second_Interface_Fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        final String token = bundle.getString("token");
        Toast.makeText(getActivity(),token, Toast.LENGTH_SHORT).show();

        View view = inflater.inflate(R.layout.fragment_second__interface_, container, false);
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++){
            list.add("a");
        }

        return view;
    }
}
