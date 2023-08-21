package com.example.hailapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomePageUI extends AppCompatActivity {


    private Student user;
    public static String std_key = "STD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("HomePage");


        user = getIntent().getParcelableExtra(LogInUI.std_key);

            TextView username = findViewById(R.id.nameTextView);

            if(user.getSubjects() != null)
            username.setText(user.getName() );

            TextView userID = findViewById(R.id.IDTextView);
            userID.setText("Student ID: "+user.getStudentId()  );


    }
    public void personalProfile(View v){

        Intent i = new Intent(HomePageUI.this , PersonalProfileUI.class);
        i.putExtra(std_key, user);
        startActivity(i);

    }
    public void attendanceRecord(View v){

//        Intent i = new Intent(HomePageUI.this , attendanceRecordUI.class);
//        i.putExtra(std_key, user);
//        startActivity(i);

    }
    public void Grades(View v){

        final CharSequence[] choice = {"Semester 1","Semester 2"};

        final int[] from = new int[1];

        AlertDialog.Builder alert = new AlertDialog.Builder(HomePageUI.this);
        alert.setTitle("Choose semester");
        alert.setSingleChoiceItems(choice, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (choice[which] == "Semester 1") {
                    from[0] = 1;
                } else if (choice[which] == "Semester 2") {
                    from[0] = 2;
                }
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (from[0] == 0) {
                    Toast.makeText(HomePageUI.this, "Select One Choice",
                            Toast.LENGTH_SHORT).show();
                } else if (from[0] == 1) {

                    Intent i = new Intent(HomePageUI.this, GradesUI.class);
                    i.putExtra(std_key, user);
                    startActivity(i);

                } else if (from[0] == 2) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(HomePageUI.this);
                    alert.setTitle("No grades for the current semester");

                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    });
                    alert.show();
                }
            }
        });
        alert.show();



    }
    public  void schedule(View v){


    }



    public void academicRecord(View v){

//        Intent i = new Intent(HomePageUI.this , academicRecordUI.class);
//        startActivity(i);

    }
    public void CPlan(View v){

        Intent i = new Intent(HomePageUI.this , CPlanUI.class);
        i.putExtra(std_key, user);
        startActivity(i);

    }
}