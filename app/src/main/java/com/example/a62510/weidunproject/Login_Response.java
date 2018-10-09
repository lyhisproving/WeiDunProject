package com.example.a62510.weidunproject;

import java.util.List;

/**
 * Created by 62510 on 2018/4/10.
 */

public class Login_Response {
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
    public  class Data{
        private String token;
        private int exp;

        public String getToken(){
            return token;
        }
        public void setToken(String token){
            this.token = token;
        }
        public int getExp(){
            return exp;
        }
        public void setExp(int exp){
            this.exp = exp;
        }
    }
    public Data getData(){
        return data;
    }
    public void setData(Data data){
        this.data = data;
    }

}
