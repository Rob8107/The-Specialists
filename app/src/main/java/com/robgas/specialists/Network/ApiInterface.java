package com.robgas.specialists.Network;

import com.robgas.specialists.Network.Models.ResponseFromGitLab;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("raw/master/testTask.json")
    Call<ResponseFromGitLab> getFeed();
}
