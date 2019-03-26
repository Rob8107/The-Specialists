package com.robgas.specialists.DateBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.robgas.specialists.DateBase.Dao.SpecialistDao;
import com.robgas.specialists.DateBase.Entity.SpecialistEntity;

@Database(entities = {SpecialistEntity.class}, version = 1, exportSchema = false)
public abstract class DBService extends RoomDatabase {
    private static DBService INSTANCE = null;

    public static DBService getDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder
                    (context, DBService.class, "specialists.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public abstract SpecialistDao feedDao();

}
