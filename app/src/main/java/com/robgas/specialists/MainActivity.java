package com.robgas.specialists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.robgas.specialists.Network.Models.ResponseFromGitLab;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpecialistApp.getApplicationInstance().getApiInterface().getFeed().enqueue(new Callback<ResponseFromGitLab>() {
            @Override
            public void onResponse(Call<ResponseFromGitLab> call, retrofit2.Response<ResponseFromGitLab> response) {
//                for (ResponseItem responseItem : response.body().getResponse()) {
//                    SpecialistApp.getApplicationInstance().appDb.feedDao().insertSpecialityEntity(DBUtils.getSpecialistEntity(responseItem));
//                }
            }

            @Override
            public void onFailure(Call<ResponseFromGitLab> call, Throwable t) {

            }
        });
    }
}
