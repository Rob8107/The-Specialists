package com.robgas.specialists.Utils;

import com.robgas.specialists.DateBase.Entity.SpecialistEntity;
import com.robgas.specialists.Network.Models.ResponseItem;
import com.robgas.specialists.Network.Models.SpecialtyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBUtils {

    public static SpecialistEntity getSpecialistEntity(ResponseItem specialtyItem) {
        SpecialistEntity specialistEntity = new SpecialistEntity();
        specialistEntity.setId(getUUID(specialtyItem.getAvatrUrl() + specialtyItem.getBirthday()));
        specialistEntity.setBirthday((specialtyItem.getBirthday() == null) ? "" : specialtyItem.getBirthday());
        specialistEntity.setAvatrUrl(specialtyItem.getAvatrUrl());
        specialistEntity.setFName(specialtyItem.getFName());
        specialistEntity.setLName(specialtyItem.getLName());
        List<SpecialistEntity.SpecialtyEntity> specialistEntities = new ArrayList<>();
        List<SpecialtyItem> specialtyItems = specialtyItem.getSpecialty();
        for (int i = 0; i < specialtyItems.size(); i++) {
            SpecialistEntity.SpecialtyEntity specialistEntity1 = new SpecialistEntity.SpecialtyEntity();
            specialistEntity1.setName(specialtyItems.get(i).getName());
            specialistEntity1.setSpecialtyId(specialtyItems.get(i).getSpecialtyId());
            specialistEntities.add(specialistEntity1);

        }
        specialistEntity.setSpecialty(specialistEntities);
        return specialistEntity;
    }

    private static String getUUID(String s) {
        UUID uid = UUID.nameUUIDFromBytes(s.getBytes());
        return uid.toString();
    }
}
