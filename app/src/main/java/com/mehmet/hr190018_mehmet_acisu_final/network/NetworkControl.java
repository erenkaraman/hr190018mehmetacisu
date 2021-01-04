package com.mehmet.hr190018_mehmet_acisu_final.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mehmet.hr190018_mehmet_acisu_final.activity.SplashActivity;

public class NetworkControl {

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiCon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileCon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiCon !=null && wifiCon.isConnected()) || (mobileCon !=null && mobileCon.isConnected())){
            return true;
        }else{
            return false;
        }
    }
}
