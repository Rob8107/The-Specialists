package com.robgas.specialists.Network;

import com.robgas.specialists.SpecialistApp;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "https://gitlab.65apps.com/65gb/static/";
    private static Retrofit sRetrofitInstance = null;
    private static ApiInterface sApiInterface = null;

    private RetrofitClient() {

    }


    private static Retrofit getRestClient() {
        if (sRetrofitInstance != null) {
            return sRetrofitInstance;
        }

        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(SpecialistApp.getApplicationInstance().getCacheDir(), cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.cache(cache);

        OkHttpClient client = builder.build();

        sRetrofitInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return sRetrofitInstance;
    }

    public static ApiInterface request() {
        if (sApiInterface != null) {
            return sApiInterface;
        }

        sApiInterface = getRestClient().create(ApiInterface.class);
        return sApiInterface;
    }


}
