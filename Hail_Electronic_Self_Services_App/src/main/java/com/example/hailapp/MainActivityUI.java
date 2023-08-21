package com.example.hailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

public class MainActivityUI extends AppCompatActivity {

    private static int SPLACH_TIME_OUT=1650;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(LogInUI.PREFS_NAME , 0);
                boolean hasLoggedIn= sharedPreferences.getBoolean("hasLoggedIn" ,false);


                    Intent i = new Intent(MainActivityUI.this , LogInUI.class);
                    startActivity(i);
                    finish();

            }
        },SPLACH_TIME_OUT);
    }
}