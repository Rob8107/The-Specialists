package com.robgas.specialists.DateBase.Converters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.robgas.specialists.DateBase.Entity.SpecialistEntity;

import java.lang.reflect.Type;
import java.util.List;

public class SpecialistsConverter {

    @TypeConverter
    public static List<SpecialistEntity.SpecialtyEntity> fromSpecialtyEntity(String value) {
        Type listType = new TypeToken<List<SpecialistEntity.SpecialtyEntity>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<SpecialistEntity.SpecialtyEntity> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
