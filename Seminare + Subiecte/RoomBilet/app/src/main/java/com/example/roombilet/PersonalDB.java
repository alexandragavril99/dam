package com.example.roombilet;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PersonalMedical.class}, version = 1, exportSchema = false)
public abstract class PersonalDB extends RoomDatabase {

    public abstract PersonalDAO getPersonalDAO();

}
