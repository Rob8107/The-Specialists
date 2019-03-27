package com.robgas.specialists.DateBase.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "specialists_entity")
public class SpecialistEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    String id = "";

    @ColumnInfo(name = "birthday")
    String birthday = "";

    @ColumnInfo(name = "avatr_url")
    String avatrUrl;
    //    @Ignore
    @ColumnInfo(name = "specialty")
    List<SpecialtyEntity> specialty;

    @ColumnInfo(name = "l_name")
    String lName;

    @ColumnInfo(name = "f_name")
    String fName;

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

    public List<SpecialtyEntity> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<SpecialtyEntity> specialty) {
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

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SpecialistEntity{" +
                "id='" + id + '\'' +
                ", birthday='" + birthday + '\'' +
                ", avatrUrl='" + avatrUrl + '\'' +
                ", specialty=" + specialty +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                '}';
    }

    public static class SpecialtyEntity {
        @ColumnInfo(name = "specialty_id")
        int specialtyId;

        @ColumnInfo(name = "name")
        String name;

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
            return "SpecialtyEntity{" +
                    "specialtyId=" + specialtyId +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
