package com.example.hailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GradesUI extends AppCompatActivity {

    private Student user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Grades");

        user = getIntent().getParcelableExtra(LogInUI.std_key);

        Section[] sbj = LogInUI.user.getSubjects();



      TextView S1 = findViewById(R.id.Subject);
      TextView G1 = findViewById(R.id.code);
      S1.setVisibility(View.VISIBLE);
      G1.setVisibility(View.VISIBLE);

      S1.setText(sbj[0].getSubject().getName());
      G1.setText(sbj[0].viewGrade(user.getStudentId()));

        TextView S2 = findViewById(R.id.Subject1);
        TextView G2 = findViewById(R.id.code1);
        S2.setVisibility(View.VISIBLE);
        G2.setVisibility(View.VISIBLE);

        S2.setText(sbj[1].getSubject().getName());
        G2.setText(sbj[1].viewGrade(user.getStudentId()));




    }

    public void Home(android.view.View view){

        finish();
    }
}