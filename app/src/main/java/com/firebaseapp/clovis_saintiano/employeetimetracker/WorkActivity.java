package com.firebaseapp.clovis_saintiano.employeetimetracker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebaseapp.clovis_saintiano.employeetimetracker.model.Company_Details;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class WorkActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 1;

    private Context mContext = WorkActivity.this;


    EditText editTextCompanyName, editTextCompanyDepartment, editTextCompanyAssignment, editTextCompanyYear, editTextTotalTime;
    EditText editTextApproved, editTextRejected;

    Spinner spinnerDate, spinnerDay, spinnerMonth;

    Button savebtn;

    DatabaseReference databaseReferenceCompanyDatails;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        setUpBottomNavigationView();


        databaseReferenceCompanyDatails = FirebaseDatabase.getInstance().getReference("company");


        editTextRejected = (EditText) findViewById(R.id.edit_reject_assignment);
        editTextApproved = (EditText) findViewById(R.id.edit_approve_assignment);
        editTextCompanyName = (EditText) findViewById(R.id.edit_company_name);
        editTextCompanyDepartment = (EditText) findViewById(R.id.edit_department);
        editTextCompanyAssignment = (EditText) findViewById(R.id.edit_assignment);
        editTextCompanyYear = (EditText) findViewById(R.id.edit_year);
        editTextTotalTime = (EditText) findViewById(R.id.edit_totalExpectedTime);

        spinnerDate = (Spinner) findViewById(R.id.dateAdd);
        spinnerDay = (Spinner) findViewById(R.id.daysAdd);
        spinnerMonth = (Spinner) findViewById(R.id.monthsAdd);

        savebtn = (Button) findViewById(R.id.btnSave);



        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addDetails();

            }
        });



    }


    private void addDetails(){

        String company = editTextCompanyName.getText().toString().trim();
        String department = editTextCompanyDepartment.getText().toString().trim();
        String assignment = editTextCompanyAssignment.getText().toString().trim();
        String year = editTextCompanyYear.getText().toString().trim();

       // String totalExpectedTime = editTextTotalTime.getText().toString().trim();
        //double totalTime = Double.parseDouble(totalExpectedTime);

        String reject = editTextRejected.getText().toString().trim();
        String approved = editTextApproved.getText().toString().trim();


        String date = spinnerDate.getSelectedItem().toString();
        String day = spinnerDay.getSelectedItem().toString();
        String month = spinnerMonth.getSelectedItem().toString();


        if (!TextUtils.isEmpty(company) && !TextUtils.isEmpty(department) && !TextUtils.isEmpty(assignment)){

            String id = databaseReferenceCompanyDatails.push().getKey();

            Company_Details newDetails = new Company_Details(id, company, department, assignment, year, date, day, month, reject, approved);

            databaseReferenceCompanyDatails.child(id).setValue(newDetails);

            Toast.makeText(WorkActivity.this, "Company Assignment Created", Toast.LENGTH_LONG).show();

            editTextCompanyName.setText("");
            editTextCompanyDepartment.setText("");
            editTextCompanyAssignment.setText("");
            editTextCompanyYear.setText("");


        }else{

            Toast.makeText(WorkActivity.this, "Please fill the name, time and work fields", Toast.LENGTH_LONG).show();

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
