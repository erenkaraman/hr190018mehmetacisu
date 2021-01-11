package com.mehmet.hr190018_mehmet_acisu_final.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;

public class DialogUtil extends Activity {

    public void AlertDialogGetir(Context context, String title, String message, Boolean cancel, String positiveButton, String negativeButton, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(cancel);
        builder.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (activity.toString() == "SplashActivity") {
                    ((Activity) context).finish();
                } else {
                    dialogInterface.dismiss();
                }
            }
        });
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (activity.toString().equals("SplashActivity")) {
                    context.startActivity(new Intent(ConnectivityManager.CONNECTIVITY_ACTION));
                } else {
                    ((Activity) context).finish();
                }
            }
        });

        builder.show();
    }

    public void ProgressDialogGetir(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        if (progressDialog != null) {
            if ( progressDialog.isShowing())
            progressDialog.dismiss();
        }
        progressDialog.setMessage(message);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

/*
   public void ProgressDialogGizle(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        if (progressDialog != null){
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }

*/
}



