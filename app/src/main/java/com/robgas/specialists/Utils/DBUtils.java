package com.robgas.specialists.Utils;

import com.robgas.specialists.DateBase.Entity.SpecialistEntity;
import com.robgas.specialists.Network.Models.ResponseItem;
import com.robgas.specialists.Network.Models.SpecialtyItem;
import com.robgas.specialists.data.Employee;
import com.robgas.specialists.data.Specialty;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class DBUtils {

    // response to db
    public static SpecialistEntity getSpecialistMapper(ResponseItem specialtyItem) {
        SpecialistEntity specialistEntity = new SpecialistEntity();
        specialistEntity.setId(getUUID(specialtyItem.getAvatrUrl() + specialtyItem.getFName() + specialtyItem.getLName()));
        if (specialtyItem.getBirthday() == null) {
            specialistEntity.setBirthday("-");
        } else {
            Calendar dob = Calendar.getInstance();
            dob.setTime(specialtyItem.getBirthday());
            String age = "" + calculateAge(dob.getTimeInMillis());
            specialistEntity.setBirthday(age + " года");
        }
        specialistEntity.setAvatrUrl(specialtyItem.getAvatrUrl());
        specialistEntity.setFName(makeFirstLetterCapital(specialtyItem.getFName()));
        specialistEntity.setLName(makeFirstLetterCapital(specialtyItem.getLName()));
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

    private static String makeFirstLetterCapital(String string) {
        string = string.toLowerCase();
        String cap = string.substring(0, 1).toUpperCase() + string.substring(1);
        return cap;
    }

    private static int calculateAge(long date) {
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
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
        item.setAvatrUrl(specialtyItem.getAvatrUrl());
        item.setBirthday(specialtyItem.getBirthday());
        item.setFirstName(specialtyItem.getFName());
        item.setLastName(specialtyItem.getLName());
        item.setId(specialtyItem.getId());

        ArrayList<Specialty> items = new ArrayList<>();
        List<SpecialistEntity.SpecialtyEntity> specialtyLizst = specialtyItem.getSpecialty();

        for (int i = 0; i < specialtyLizst.size(); i++) {
            Specialty specialty = new Specialty();

            specialty.name = specialtyLizst.get(i).getName();
            specialty.id = specialtyLizst.get(i).getSpecialtyId();
            items.add(specialty);
        }

        item.setSpecialty(items);
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
