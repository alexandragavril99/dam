package com.example.roombilet;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PersonalDAO {

    @Insert
    public void insertPersonal(PersonalMedical personalMedical);

    @Query("SELECT * FROM PersonalMedical")
    public List<PersonalMedical> getPersonal();
}
