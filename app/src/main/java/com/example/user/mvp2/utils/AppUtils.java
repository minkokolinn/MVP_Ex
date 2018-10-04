package com.example.user.mvp2.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtils
{
    public static boolean isInternet(Context ctxt)
    {
        ConnectivityManager cm=(ConnectivityManager)ctxt.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        if(ni!=null&&ni.isConnectedOrConnecting()){
            return true;
        }else {
            return false;
        }
    }
}
