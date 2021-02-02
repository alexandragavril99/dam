package com.example.dam_bilet4_sesizare;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Sesizare.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class SesizareDB extends RoomDatabase {
    public abstract SesizareDAO getSesizariDAO();
}
