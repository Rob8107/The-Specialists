package com.robgas.specialists.Network.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseFromGitLab {

    @SerializedName("response")
    private List<ResponseItem> response;

    public List<ResponseItem> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseItem> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return
                "ResponseFromGitLab{" +
                        "response = '" + response + '\'' +
                        "}";
    }
}