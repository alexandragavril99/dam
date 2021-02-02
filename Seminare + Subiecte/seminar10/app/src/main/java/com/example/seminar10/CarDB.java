package com.example.seminar10;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Car.class}, version = 1, exportSchema = false)
public abstract class CarDB extends RoomDatabase {

    public abstract CarDAO getCarDAO();
}
