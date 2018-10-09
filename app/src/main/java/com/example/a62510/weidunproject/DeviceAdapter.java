package com.example.a62510.weidunproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 62510 on 2018/4/15.
 */

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.Holder> {
    private ArrayList<String> list;
    private String[] title = new String[]{"土壤湿度","风力","温度","abc","abc","abc","abc"};

    static class Holder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView information;
        public Holder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.device_title);
            information = (TextView) itemView.findViewById(R.id.device_information);

        }
    }
    public DeviceAdapter( ArrayList<String> list){
        super();
        this.list = list;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.title.setText(title[position]+":");
        holder.information.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
