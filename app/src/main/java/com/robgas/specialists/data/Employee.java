package com.robgas.specialists.data;

import com.robgas.specialists.Utils.ObjectsCompat;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public String id;
    public String birthday;
    public String avatrUrl;
    public List<Specialty> specialty = new ArrayList<>();
    public String lastName;
    public String firstName;

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
