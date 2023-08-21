package com.example.hailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class CPlanUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplan);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Curriculum Plan");

        Student user = getIntent().getParcelableExtra(LogInUI.std_key);

        Subject[][] s = LogInUI.user.CPlan();

        ((TextView)findViewById(R.id.Subject)).setText(s[0][0].getName());
        ((TextView)findViewById(R.id.code)).setText(s[0][0].getSubjectCode());
        ((TextView)findViewById(R.id.credit)).setText(String.valueOf(s[0][0].getCreditHours()));

        ((TextView)findViewById(R.id.Subject1)).setText(s[0][1].getName());
        ((TextView)findViewById(R.id.code1)).setText(String.valueOf(s[0][1].getSubjectCode()));
        ((TextView)findViewById(R.id.credit1)).setText(String.valueOf(s[0][1].getCreditHours()));

        ((TextView)findViewById(R.id.Subject2)).setText(s[0][2].getName());
        ((TextView)findViewById(R.id.code2)).setText(s[0][2].getSubjectCode());
        ((TextView)findViewById(R.id.credit2)).setText(String.valueOf(s[0][2].getCreditHours()));

        ((TextView)findViewById(R.id.Subject3)).setText(s[0][3].getName());
        ((TextView)findViewById(R.id.code3)).setText(s[0][3].getSubjectCode());
        ((TextView)findViewById(R.id.credit3)).setText(String.valueOf(s[0][3].getCreditHours()));

        ((TextView)findViewById(R.id.Subject4)).setText(s[0][4].getName());
        ((TextView)findViewById(R.id.code44)).setText(s[0][4].getSubjectCode());
        ((TextView)findViewById(R.id.credit4)).setText(String.valueOf(s[0][4].getCreditHours()));

        ((TextView)findViewById(R.id.Subject5)).setText(s[0][5].getName());
        ((TextView)findViewById(R.id.code5)).setText(s[0][5].getSubjectCode());
        ((TextView)findViewById(R.id.credit5)).setText(String.valueOf(s[0][5].getCreditHours()));

        ((TextView)findViewById(R.id.Subject6)).setText(s[1][0].getName());
        ((TextView)findViewById(R.id.code66)).setText(s[1][0].getSubjectCode());
        ((TextView)findViewById(R.id.credit6)).setText(String.valueOf(s[1][0].getCreditHours()));

        ((TextView)findViewById(R.id.Subject7)).setText(s[1][1].getName());
        ((TextView)findViewById(R.id.code7)).setText(s[1][1].getSubjectCode());
        ((TextView)findViewById(R.id.credit7)).setText(String.valueOf(s[1][1].getCreditHours()));

        ((TextView)findViewById(R.id.Subject8)).setText(s[1][2].getName());
        ((TextView)findViewById(R.id.code88)).setText(s[1][2].getSubjectCode());
        ((TextView)findViewById(R.id.credit8)).setText(String.valueOf(s[1][2].getCreditHours()));

        ((TextView)findViewById(R.id.subject9)).setText(s[1][3].getName());
        ((TextView)findViewById(R.id.code9)).setText(s[1][3].getSubjectCode());
        ((TextView)findViewById(R.id.credit9)).setText(String.valueOf(s[1][3].getCreditHours()));

        ((TextView)findViewById(R.id.subject10)).setText(s[1][4].getName());
        ((TextView)findViewById(R.id.code10)).setText(s[1][4].getSubjectCode());
        ((TextView)findViewById(R.id.credit10)).setText(String.valueOf(s[1][4].getCreditHours()));

        ((TextView)findViewById(R.id.subject11)).setText(s[1][5].getName());
        ((TextView)findViewById(R.id.code11)).setText(s[1][5].getSubjectCode());
        ((TextView)findViewById(R.id.credit11)).setText(String.valueOf(s[1][5].getCreditHours()));
    }
    public void Home(android.view.View view){

        finish();
    }

}