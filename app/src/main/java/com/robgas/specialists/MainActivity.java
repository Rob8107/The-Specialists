package com.robgas.specialists;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.robgas.specialists.Network.Models.ResponseFromGitLab;
import com.robgas.specialists.Network.Models.ResponseItem;
import com.robgas.specialists.Utils.DBUtils;
import com.robgas.specialists.fragments.SpecialtyListFragment;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpecialistApp.Instance().getRestService().getFeed().enqueue(new Callback<ResponseFromGitLab>() {
            @Override
            public void onResponse(Call<ResponseFromGitLab> call, retrofit2.Response<ResponseFromGitLab> response) {
                if (response.body() != null) {
                    for (ResponseItem responseItem : response.body().getResponse()) {
                        SpecialistApp.Instance().appDb.specialistDao().insertSpecialityEntity(DBUtils.getSpecialistMapper(responseItem));
                    }

                    openFragment(SpecialtyListFragment.newInstance(), false);

                }
            }

            @Override
            public void onFailure(Call<ResponseFromGitLab> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void openFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}
