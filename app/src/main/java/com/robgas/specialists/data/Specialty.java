package com.robgas.specialists.data;

import com.robgas.specialists.Utils.ObjectsCompat;

import java.io.Serializable;

public class Specialty implements Serializable {
    public int id;
    public String name;

    public Specialty() {

    }

    public Specialty(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return id == specialty.id;
    }

    @Override
    public int hashCode() {
        return ObjectsCompat.hash(id);
    }
}
