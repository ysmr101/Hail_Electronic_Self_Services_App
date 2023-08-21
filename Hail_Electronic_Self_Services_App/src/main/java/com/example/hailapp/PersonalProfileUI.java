package com.example.hailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class PersonalProfileUI extends AppCompatActivity {

    public Student user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Personal profile ");

        user = getIntent().getParcelableExtra(HomePageUI.std_key);

        TextView username = findViewById(R.id.nameText);
        username.setText(user.getName() );

        TextView userID = findViewById(R.id.STDIDText);
        userID.setText(user.getStudentId()  );

        TextView PhoneNum = findViewById(R.id.phneNumberText);
        PhoneNum.setText(user.getPhoneNumber()  );

        TextView emaill = findViewById(R.id.emailText);
        emaill.setText(user.getEmail()  );

        TextView ID = findViewById(R.id.IDText);
        ID.setText(user.getID()  );

        TextView ageT = findViewById(R.id.ageText);
        ageT.setText(String.valueOf(user.getAge()));

        TextView slaryT = findViewById(R.id.SalaryText);
        slaryT.setText(String.valueOf(user.getSalary())  );

        TextView majorT = findViewById(R.id.MajorText);
        majorT.setText(user.getMajor().name );


    }
    public void Home(android.view.View view){

        finish();
    }
}