package com.robgas.specialists.Network.Models;

import com.google.gson.annotations.SerializedName;


public class SpecialtyItem {

    @SerializedName("specialty_id")
    private int specialtyId;

    @SerializedName("name")
    private String name;

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "SpecialtyItem{" +
                        "specialty_id = '" + specialtyId + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}