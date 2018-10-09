package com.example.a62510.weidunproject;

import java.util.List;

/**
 * Created by 62510 on 2018/4/11.
 */
//用来查询用户有几个device
class DeviceResponse{
    private String err_msg;
    private int code;
    private Data data;

    public int getCode(){
        return code;
    }
    public void setCode(int code){
        this.code=code;
    }
    public String getErr_msg(){
        return err_msg;
    }
    public void setErr_msg(String err_msg){
        this.err_msg = err_msg;
    }
    public class Data{
        private String username;
        private List<String> device;
        public String getUsername(){
            return username;
        }
        public void setUsername(){
            this.username = username;
        }
        public List<String> getDevice(){
            return device;
        }
        public void setDevice(List<String> device){
            this.device=device;
        }
    }
    public Data getData(){
        return data;
    }
    public void setData(Data data){
        this.data=data;
    }
}
