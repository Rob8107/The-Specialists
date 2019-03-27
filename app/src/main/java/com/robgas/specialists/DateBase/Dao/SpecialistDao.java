package com.robgas.specialists.DateBase.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.robgas.specialists.DateBase.Entity.SpecialistEntity;

import java.util.List;

@Dao
public interface SpecialistDao {
    @Query("SELECT * FROM specialists_entity")
    LiveData<List<SpecialistEntity>> getSpecialistLiveData();

    @Query("SELECT * FROM specialists_entity")
    List<SpecialistEntity> getSpecialisyList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpecialityEntity(SpecialistEntity pinEntity);
}
