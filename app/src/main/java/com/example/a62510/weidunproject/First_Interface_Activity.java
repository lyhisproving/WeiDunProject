package com.example.a62510.weidunproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class First_Interface_Activity extends FragmentActivity implements BottomNavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener{


    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    public String token;
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.设备:
                clickEquipment();
                return true;
            case R.id.社区:
                clickCommunity();
                return true;
            case R.id.我的:
                clickMyown();
                return true;
            default:
                break;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__interface_);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        //initView();
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        First_Interface_Fragment first =new First_Interface_Fragment();
        Second_Interface_Fragment second = new Second_Interface_Fragment();
        Third_Interface_Fragment third = new Third_Interface_Fragment();
        Bundle bundle =new Bundle();
        bundle.putString("token",token);
        first.setArguments(bundle);
        second.setArguments(bundle);
        third.setArguments(bundle);
        ArrayList<Fragment> fragment_list= new ArrayList<Fragment>();
        fragment_list.add(first);
        fragment_list.add(second);
        fragment_list.add(third);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.设备);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragment_list));
        //initListener();
    }


    /*private void initView(){

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        First_Interface_Fragment first =new First_Interface_Fragment();
        Second_Interface_Fragment second = new Second_Interface_Fragment();
        Third_Interface_Fragment third = new Third_Interface_Fragment();
        Bundle bundle =new Bundle();
        bundle.putString("token",token);
        first.setArguments(bundle);
        second.setArguments(bundle);
        third.setArguments(bundle);
        ArrayList<Fragment> fragment_list= new ArrayList<Fragment>();
        fragment_list.add(first);
        fragment_list.add(second);
        fragment_list.add(third);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.设备);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragment_list));
    }*/

//    private void initListener(){
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
//        bottomNavigationView.setSelectedItemId(R.id.设备);
//        viewPager.addOnPageChangeListener(this);
//        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
//
//    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.设备);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.社区);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.我的);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void clickEquipment(){
        viewPager.setCurrentItem(0,false);
    }

    private void clickCommunity(){
        viewPager.setCurrentItem(1,false);
    }

    private void clickMyown(){
        viewPager.setCurrentItem(2,false);
    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter{
        //Bundle bundle = new Bundle();
        //bundle.putString("token",token);
       // public Fragment[] myFragment = new Fragment[]{   ,new Second_Interface_Fragment(),new Third_Interface_Fragment()};
        ArrayList<Fragment> list;
        public ViewPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {
            super(fm);
            this.list=list;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            //return myFragment[position];
            return list.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
