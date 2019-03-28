package com.robgas.specialists.Utils;


import com.robgas.specialists.DateBase.Entity.SpecialistEntity;
import com.robgas.specialists.Network.Models.ResponseItem;
import com.robgas.specialists.Network.Models.SpecialtyItem;
import com.robgas.specialists.data.Employee;
import com.robgas.specialists.data.Specialty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBUtils {

    // response to db
    public static SpecialistEntity getSpecialistMapper(ResponseItem specialtyItem) {
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

    public static List<SpecialistEntity> getSpecialistMapper(List<ResponseItem> specialtyItem) {
        List<SpecialistEntity> specialistEntities = new ArrayList<>();
        for (ResponseItem responseItem : specialtyItem) {
            specialistEntities.add(getSpecialistMapper(responseItem));
        }

        return specialistEntities;
    }

    // db to response
    public static Employee getSpecialistMapper2(SpecialistEntity specialtyItem) {
        Employee item = new Employee();
        item.avatrUrl = specialtyItem.getAvatrUrl();
        item.birthday = specialtyItem.getBirthday();
        item.firstName = specialtyItem.getFName();
        item.lastName = specialtyItem.getLName();
        item.id = specialtyItem.getId();

        ArrayList<Specialty> items = new ArrayList<>();
        List<SpecialistEntity.SpecialtyEntity> specialtyLizst = specialtyItem.getSpecialty();

        for (int i = 0; i < specialtyLizst.size(); i++) {
            Specialty specialty = new Specialty();

            specialty.name = specialtyLizst.get(i).getName();
            specialty.id = specialtyLizst.get(i).getSpecialtyId();
            items.add(specialty);
        }

        item.specialty = items;
        return item;
    }

    public static List<Employee> getSpecialistMapper2(List<SpecialistEntity> specialtyItem) {
        List<Employee> specialistEntities = new ArrayList<>();

        for (SpecialistEntity specialistEntity : specialtyItem) {
            specialistEntities.add(getSpecialistMapper2(specialistEntity));
        }

        return specialistEntities;
    }

    private static String getUUID(String s) {
        UUID uid = UUID.nameUUIDFromBytes(s.getBytes());
        return uid.toString();
    }
}
