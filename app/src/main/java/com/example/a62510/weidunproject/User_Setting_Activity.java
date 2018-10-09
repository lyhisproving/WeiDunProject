package com.example.a62510.weidunproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

//         进行个人信息展示和个人设置
//

public class User_Setting_Activity extends AppCompatActivity {

    TextView name,gender,age,intoduction;
    FragmentManager manager = getFragmentManager();
    Fragment ud_fragment = new User_Display_Fragment();
    Fragment u_s_fragment = new User_Setting_Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.user_setting,ud_fragment).show(ud_fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting_button:
                Bundle bundle = new Bundle();
                name = (TextView)findViewById(R.id.third_first_text_姓名);
                gender = (TextView)findViewById(R.id.third_first_text_性别);
                age = (TextView)findViewById(R.id.third_first_text_年龄);
                intoduction = (TextView)findViewById(R.id.third_first_text_个人简介);
                bundle.putString("name",name.getText().toString());
                bundle.putString("gender",gender.getText().toString());
                bundle.putString("age",age.getText().toString());
                bundle.putString("introduction",intoduction.getText().toString());

                FragmentTransaction transaction = manager.beginTransaction();
                u_s_fragment.setArguments(bundle);
                if(!u_s_fragment.isAdded()){
                    transaction.hide(ud_fragment).add(R.id.user_setting,u_s_fragment).show(u_s_fragment).commit();
                }else{
                    transaction.hide(ud_fragment).show(u_s_fragment).commit();
                }
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
