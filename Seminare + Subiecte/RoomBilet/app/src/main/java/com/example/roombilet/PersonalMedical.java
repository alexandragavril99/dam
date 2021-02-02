package com.example.roombilet;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "PersonalMedical")
public class PersonalMedical implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nume;
    private int varsta;
    private String email;
    private String oraInscriere;
    private String pozitie;

    public PersonalMedical(int id,String nume, int varsta, String email, String oraInscriere, String pozitie) {
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
        this.email = email;
        this.oraInscriere = oraInscriere;
        this.pozitie = pozitie;
    }

    @Ignore
    public PersonalMedical(String nume, int varsta, String email, String oraInscriere, String pozitie) {
        this.nume = nume;
        this.varsta = varsta;
        this.email = email;
        this.oraInscriere = oraInscriere;
        this.pozitie = pozitie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOraInscriere() {
        return oraInscriere;
    }

    public void setOraInscriere(String oraInscriere) {
        this.oraInscriere = oraInscriere;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    @Override
    public String toString() {
        return "PersonalMedical{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", email='" + email + '\'' +
                ", oraInscriere='" + oraInscriere + '\'' +
                ", pozitie='" + pozitie + '\'' +
                '}';
    }
}
