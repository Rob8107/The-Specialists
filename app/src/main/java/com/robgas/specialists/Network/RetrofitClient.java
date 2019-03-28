package com.robgas.specialists.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "https://gitlab.65apps.com/";
    private static Retrofit sRetrofitInstance = null;
    private static ApiInterface sApiInterface = null;

    private RetrofitClient() {

    }


    private static Retrofit getRestClient() {
        if (sRetrofitInstance != null) {
            return sRetrofitInstance;
        }


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()
                .create();

        sRetrofitInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return sRetrofitInstance;
    }

    public static ApiInterface restService() {
        if (sApiInterface != null) {
            return sApiInterface;
        }

        sApiInterface = getRestClient().create(ApiInterface.class);
        return sApiInterface;
    }


}
