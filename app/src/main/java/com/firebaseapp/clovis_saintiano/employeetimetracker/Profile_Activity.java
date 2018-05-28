package com.firebaseapp.clovis_saintiano.employeetimetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Profile_Activity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 3;

    private Context mContext = Profile_Activity.this;

    private ImageView settingEditProfile;
    private ImageView settingHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        settingEditProfile = (ImageView) findViewById(R.id.profile_edit);
        settingHome = (ImageView) findViewById(R.id.profile_home);

        setUpBottomNavigationView();



        settingHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Profile_Activity.this, HomeActivity.class));

            }
        });

        settingEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Profile_Activity.this, Edit_Profile_Activity.class));

            }
        });


    }


    /**
     * bottom navigation view setup
     */

    private void setUpBottomNavigationView(){

        BottomNavigationViewEx buttomNavigationViewEx = ( BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        com.firebaseapp.clovis_saintiano.employeetimetracker.bottom_view_helper.BottomNavigationView.setUpBottomNavigationView(buttomNavigationViewEx);

        //Enable bottom activity in each activities / items
        com.firebaseapp.clovis_saintiano.employeetimetracker.bottom_view_helper.BottomNavigationView.enableNavigation(mContext, buttomNavigationViewEx);

        Menu menu = buttomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }

}



