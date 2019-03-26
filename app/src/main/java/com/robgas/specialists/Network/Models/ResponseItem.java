package com.robgas.specialists.Network.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseItem {

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("avatr_url")
    private String avatrUrl;

    @SerializedName("specialty")
    private List<SpecialtyItem> specialty;

    @SerializedName("l_name")
    private String lName;

    @SerializedName("f_name")
    private String fName;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatrUrl() {
        return avatrUrl;
    }

    public void setAvatrUrl(String avatrUrl) {
        this.avatrUrl = avatrUrl;
    }

    public List<SpecialtyItem> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<SpecialtyItem> specialty) {
        this.specialty = specialty;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    @Override
    public String toString() {
        return
                "ResponseItem{" +
                        "birthday = '" + birthday + '\'' +
                        ",avatr_url = '" + avatrUrl + '\'' +
                        ",specialty = '" + specialty + '\'' +
                        ",l_name = '" + lName + '\'' +
                        ",f_name = '" + fName + '\'' +
                        "}";
    }
}