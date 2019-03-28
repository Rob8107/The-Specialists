package com.robgas.specialists;

import android.app.Application;

import com.robgas.specialists.DateBase.DBService;
import com.robgas.specialists.Network.ApiInterface;
import com.robgas.specialists.Network.RetrofitClient;

public class SpecialistApp extends Application {
    private static SpecialistApp instance;
    public DBService appDb;

    public static SpecialistApp Instance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appDb = DBService.getDataBase(instance);
    }

    public ApiInterface getRestService() {
        return RetrofitClient.restService();
    }
}
