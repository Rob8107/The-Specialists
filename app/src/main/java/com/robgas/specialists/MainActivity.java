package com.robgas.specialists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.robgas.specialists.DateBase.Entity.SpecialistEntity;
import com.robgas.specialists.Network.Models.ResponseFromGitLab;
import com.robgas.specialists.Network.Models.ResponseItem;
import com.robgas.specialists.Utils.DBUtils;

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
                if (response.body() != null) {
                    for (ResponseItem responseItem : response.body().getResponse()) {
                        SpecialistApp.getApplicationInstance().appDb.specialistDao().insertSpecialityEntity(DBUtils.getSpecialistEntity(responseItem));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseFromGitLab> call, Throwable t) {

            }
        });
        SpecialistApp.getApplicationInstance().appDb.specialistDao().getSpecialistLiveData().observe(this, specialistEntities -> {
            if (specialistEntities != null) {
                for (SpecialistEntity specialistEntity : specialistEntities) {

                }
            }
        });
    }
}
