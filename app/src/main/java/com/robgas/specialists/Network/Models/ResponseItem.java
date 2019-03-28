package com.robgas.specialists.Network.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseItem {

    //	@Expose(serialize = false, deserialize = false)
    private transient String id;

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

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setAvatrUrl(String avatrUrl) {
        this.avatrUrl = avatrUrl;
    }

    public String getAvatrUrl() {
        return avatrUrl;
    }

    public void setSpecialty(List<SpecialtyItem> specialty) {
        this.specialty = specialty;
    }

    public List<SpecialtyItem> getSpecialty() {
        return specialty;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}