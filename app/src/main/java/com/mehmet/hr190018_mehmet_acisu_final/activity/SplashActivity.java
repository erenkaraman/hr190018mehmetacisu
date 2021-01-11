package com.mehmet.hr190018_mehmet_acisu_final.activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mehmet.hr190018_mehmet_acisu_final.R;
import com.mehmet.hr190018_mehmet_acisu_final.util.DialogUtil;
import com.mehmet.hr190018_mehmet_acisu_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }
    @Override
    protected void onResume() {
        super.onResume();
        connection();
    }

    public void connection(){
        NetworkUtil networkUtil = new NetworkUtil();
        if(networkUtil.isConnected(getApplicationContext())){
            timeriBaslat();
        }
        else{
            showAlertDialog();
        }
    }
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setTitle(getResources().getString(R.string.network_alert_title));
        builder.setMessage(getResources().getString(R.string.network_alert_message))
                .setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.network_alert_positive_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.network_alert_negative_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void timeriBaslat(){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                openNextActivity();
            }

        };
        countDownTimer.start();
    }
    private void openNextActivity(){
            Intent secondActivityIntent=new Intent(getApplicationContext(),ListActivity.class);
            startActivity(secondActivityIntent);
            finish();
        }
        /*
   private void showAlertDialog() {
        DialogUtil dialogUtil = new DialogUtil();
        dialogUtil.AlertDialogGetir(SplashActivity.this,getResources().getString(R.string.network_alert_title),getResources().getString(R.string.network_alert_message),false,getResources().getString(R.string.network_alert_positive_button),getResources().getString(R.string.network_alert_negative_button),SplashActivity.this);
    */
    }

