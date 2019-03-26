package com.robgas.specialists.Utils;

import com.robgas.specialists.DateBase.Entity.SpecialistEntity;
import com.robgas.specialists.Network.Models.ResponseItem;

public class DBUtils {

    public static SpecialistEntity getSpecialistEntity(ResponseItem specialtyItem) {
        SpecialistEntity specialistEntity = new SpecialistEntity();
        specialistEntity.setBirthday(specialtyItem.getBirthday());
        specialistEntity.setAvatrUrl(specialistEntity.getAvatrUrl());
        specialistEntity.setFName(specialistEntity.getFName());
        specialistEntity.setLName(specialistEntity.getLName());
//        specialistEntity.setSpecialty(specialtyItem.getSpecialty());
        return specialistEntity;
    }
}
