package com.example.adaptorpersonalizatbilet;

import java.io.Serializable;
import java.util.Date;

public class EchipamentSportiv implements Serializable {
    private String denumire;
    private Date dataAchizitionarii;
    private String gen;
    private int numparPiese;
    private Tip tip;

    public EchipamentSportiv(String denumire, Date dataAchizitionarii, String gen, int numparPiese, Tip tip) {
        this.denumire = denumire;
        this.dataAchizitionarii = dataAchizitionarii;
        this.gen = gen;
        this.numparPiese = numparPiese;
        this.tip = tip;
    }

    public Date getDataAchizitionarii() {
        return dataAchizitionarii;
    }

    public void setDataAchizitionarii(Date dataAchizitionarii) {
        this.dataAchizitionarii = dataAchizitionarii;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNumparPiese() {
        return numparPiese;
    }

    public void setNumparPiese(int numparPiese) {
        this.numparPiese = numparPiese;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "EchipamentSportiv{" +
                "denumire='" + denumire + '\'' +
                ", dataAchizitionarii=" + dataAchizitionarii +
                ", gen='" + gen + '\'' +
                ", numparPiese=" + numparPiese +
                ", tip=" + tip +
                '}';
    }
}
