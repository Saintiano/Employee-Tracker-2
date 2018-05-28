package com.firebaseapp.clovis_saintiano.employeetimetracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {


        private static final int ACTIVITY_NUM = 0;

        private Context mContext = HomeActivity.this;



        //firebase setup
        private FirebaseAuth mAuthentication;
        private FirebaseAuth.AuthStateListener mAuthenticationListener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);






            setUpBottomNavigationView();





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
