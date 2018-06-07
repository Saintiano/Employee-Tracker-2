package com.firebaseapp.clovis_saintiano.employeetimetracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebaseapp.clovis_saintiano.employeetimetracker.model.Company_Details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {


        private static final int ACTIVITY_NUM = 0;

        private Context mContext = HomeActivity.this;


    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



        //firebase setup
        private FirebaseAuth mAuthentication;
        private FirebaseAuth.AuthStateListener mAuthenticationListener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);






            setUpBottomNavigationView();


            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = FirebaseDatabase.getInstance().getReference().child("company");
            databaseReference.keepSynced(true);


            recyclerView = (RecyclerView) findViewById(R.id.show_dashboard_recyclerview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
            Toast.makeText(HomeActivity.this, "Fetching Medications",Toast.LENGTH_SHORT).show();






        }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Company_Details, HomeActivity.Company_Details_ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Company_Details, HomeActivity.Company_Details_ViewHolder>
                (Company_Details.class, R.layout.card_company_dashboard, HomeActivity.Company_Details_ViewHolder.class, databaseReference) {

            @Override
            protected void populateViewHolder(HomeActivity.Company_Details_ViewHolder viewHolder, Company_Details model, int position) {

                viewHolder.set_Date(model.getUserDate());
                viewHolder.set_Day(model.getUserDay());
                viewHolder.set_Month(model.getUserMonth());
                viewHolder.set_CompanyName(model.getCompanyName());
                viewHolder.set_Rejected(model.getRejected());
                viewHolder.set_Approved(model.getApproved());


            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }


    //create a viewholder class where xml fields are initialized
    public static class Company_Details_ViewHolder extends RecyclerView.ViewHolder{

        //create view field
        View mView;

        public Company_Details_ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void set_Date(String date){

            TextView tv_Date = (TextView) mView.findViewById(R.id.tv_dashboard_date);
            tv_Date.setText(date);

        }

        public void set_Day(String day){

            TextView tv_Day = (TextView) mView.findViewById(R.id.tv_dashboard_day);
            tv_Day.setText(day);

        }

        public void set_Month(String month){

            TextView tv_Month= (TextView) mView.findViewById(R.id.tv_dashboard_month);
            tv_Month.setText(month);

        }

        public void set_Year(String year){

            TextView tv_Year = (TextView) mView.findViewById(R.id.tv_dashboard_year);
            tv_Year.setText(year);

        }

        public void set_CompanyName(String companyName){

            TextView tv_CompanyName = (TextView) mView.findViewById(R.id.tv_dashboard_company_name);
            tv_CompanyName.setText(companyName);

        }

        public void set_Rejected (String reject){

            TextView tv_reject = (TextView) mView.findViewById(R.id.tv_dashboard_rejected);
            tv_reject.setText(reject);

        }

        public void set_Approved (String approved){

            TextView tv_approved = (TextView) mView.findViewById(R.id.tv_dashboard_approved);
            tv_approved.setText(approved);

        }







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
