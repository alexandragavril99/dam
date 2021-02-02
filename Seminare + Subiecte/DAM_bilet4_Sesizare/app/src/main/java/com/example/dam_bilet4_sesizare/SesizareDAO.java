package com.example.dam_bilet4_sesizare;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SesizareDAO {

    @Insert
    public void insertSesizare(Sesizare sesizare);

    @Query("SELECT * FROM Sesizari")
    public List<Sesizare> getSesizari();
}
