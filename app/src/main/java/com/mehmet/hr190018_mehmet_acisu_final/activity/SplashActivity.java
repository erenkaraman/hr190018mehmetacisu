package com.mehmet.hr190018_mehmet_acisu_final.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.mehmet.hr190018_mehmet_acisu_final.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init(){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {
                Log.e("COUNTER","TİCK");
            }

            @Override
            public void onFinish() {
                opennextactivity();
            }

        };
        countDownTimer.start();
    }


    private void opennextactivity(){
            Log.e("COUNTER","FİNİSH");
            Intent secondActivityIntent=new Intent(getApplicationContext(),ListActivity.class);
            startActivity(secondActivityIntent);
            finish();
        }
    }

