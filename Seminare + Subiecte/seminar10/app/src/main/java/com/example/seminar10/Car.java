package com.example.seminar10;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Cars") //pt ca va fi o entitate in bd ul nostru, e o adnotare, primeste si parametru
public class Car {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String registrationNumber;

    @ColumnInfo(name="seats")
    private int numberOfSeats;
    private float price;

    public Car(int ID, String registrationNumber, int numberOfSeats, float price) {
        this.ID = ID;
        this.registrationNumber = registrationNumber;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
    }

    public Car() {

    }

    public Car(String registrationNumber, int numberOfSeats, float price) {
        this.registrationNumber = registrationNumber;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID=" + ID +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", price=" + price +
                '}';
    }
}
