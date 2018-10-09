package com.example.a62510.weidunproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;


public class Third_Interface_Fragment extends Fragment {

    private ListView listView;
    private static final String [] string = new String[]{"个人信息","个人主页","我的关注","关注我的",
                                            "我的消息","退出登录"};
    private ArrayAdapter<String> adapter;
    private List<String> data;
    public Third_Interface_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third__interface_,container,false);
        getData();
        listView = view.findViewById(R.id.third_interface_listview);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        //个人信息
                        Intent intent1 = new Intent(getActivity(),User_Setting_Activity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        //个人主页
                        Intent intent2 = new Intent(getActivity(),Personal_Activity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        //我的关注
                        Toast.makeText(getActivity(),data.get(i),Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        //关注我的
                        Toast.makeText(getActivity(),data.get(i),Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        //我的消息
                        Toast.makeText(getActivity(),data.get(i),Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
//                      退出登录
                        new AlertDialog.Builder(getActivity())
                                .setTitle("提示")
                                .setMessage("是否确认退出？")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent();
                                        intent.setClass(getActivity(),MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton("取消",null)
                                .show();
                        break;
                    default:
                        break;
                }

            }
        });
        return view;
    }
    private void getData(){
        data = new ArrayList<String>();
        for(int i=0;i<6;i++){
            data.add(string[i]);
        }
    }

}
