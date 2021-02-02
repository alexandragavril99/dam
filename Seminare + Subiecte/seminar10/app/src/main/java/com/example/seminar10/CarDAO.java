package com.example.seminar10;

import android.widget.EditText;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarDAO {

    @Insert
    public void insertCar(Car car);

    @Query("SELECT * FROM Cars")
    public List<Car> getCars();


    @Query("SELECT * FROM Cars WHERE registrationNumber =  :registrationNumber")
    public Car getCar(String registrationNumber);
}
