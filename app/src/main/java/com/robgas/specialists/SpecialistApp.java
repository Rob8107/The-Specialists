package com.robgas.specialists;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.robgas.specialists.DateBase.DBService;
import com.robgas.specialists.Network.ApiInterface;
import com.robgas.specialists.Network.RetrofitClient;

public class SpecialistApp extends Application {
    private static SpecialistApp instance;
    public DBService appDb;

    public static SpecialistApp getApplicationInstance() {
        return instance;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) instance.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appDb = DBService.getDataBase(instance);
    }

    public ApiInterface getApiInterface() {
        return RetrofitClient.request();
    }
}
