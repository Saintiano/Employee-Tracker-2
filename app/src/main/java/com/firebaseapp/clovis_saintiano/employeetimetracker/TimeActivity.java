package com.firebaseapp.clovis_saintiano.employeetimetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class TimeActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 2;

    private Context mContext = TimeActivity.this;


    public final static String USER_NAME = "username";
    public final static String USER_ID = "userId";



    DatabaseReference databaseReferenceCompanyDatails;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        databaseReferenceCompanyDatails = FirebaseDatabase.getInstance().getReference("company");




        setUpBottomNavigationView();






    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseReferenceCompanyDatails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                for(DataSnapshot detailSnapShot : dataSnapshot.getChildren()){



                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
