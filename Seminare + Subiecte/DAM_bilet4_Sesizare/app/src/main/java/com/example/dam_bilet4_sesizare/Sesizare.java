package com.example.dam_bilet4_sesizare;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "Sesizari")
public class Sesizare implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name="titlu")
    private String titlu;

    @ColumnInfo(name="descriere")
    private String descriere;

    @ColumnInfo(name="data_inregistrarii")
    private Date dataInregistrarii;

    @ColumnInfo(name="tip")
    private Tip tip;


    @Ignore
    public Sesizare(){

    }

    public Sesizare(String titlu, String descriere, Date dataInregistrarii, Tip tip) {
        this.titlu = titlu;
        this.descriere = descriere;
        this.dataInregistrarii = dataInregistrarii;
        this.tip = tip;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Date getDataInregistrarii() {
        return dataInregistrarii;
    }

    public void setDataInregistrarii(Date dataInregistrarii) {
        this.dataInregistrarii = dataInregistrarii;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Sesizare{" +
                "titlu='" + titlu + '\'' +
                ", descriere='" + descriere + '\'' +
                ", dataInregistrarii=" + dataInregistrarii +
                ", tip=" + tip +
                '}';
    }
}
