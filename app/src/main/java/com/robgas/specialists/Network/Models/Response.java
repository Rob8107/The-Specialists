package com.example.empleyeelist.Network.Models;

import com.google.gson.annotations.SerializedName;
import com.robgas.specialists.Network.Models.ResponseItem;

import java.util.List;

public class Response {

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
                "Response{" +
                        "response = '" + response + '\'' +
                        "}";
    }
}