package com.robgas.specialists.data;

import com.robgas.specialists.Utils.ObjectsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
    private String id;
    private String birthday;
    private String avatrUrl;
    private List<Specialty> specialty = new ArrayList<>();
    private String lastName;
    private String firstName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialty = specialty;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ObjectsCompat.equals(id, employee.id) &&
                ObjectsCompat.equals(birthday, employee.birthday) &&
                ObjectsCompat.equals(avatrUrl, employee.avatrUrl) &&
                ObjectsCompat.equals(lastName, employee.lastName) &&
                ObjectsCompat.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return ObjectsCompat.hash(id, birthday, avatrUrl, lastName, firstName);
    }
}
