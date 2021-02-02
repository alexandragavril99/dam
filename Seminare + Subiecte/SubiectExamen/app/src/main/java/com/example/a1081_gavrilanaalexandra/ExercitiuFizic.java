package com.example.a1081_gavrilanaalexandra;

import java.io.Serializable;
import java.util.Date;

public class ExercitiuFizic implements Serializable {
    private String denumire;
    private int nrCalorii;
    private String gen;
    private Date dataIncarcarii;
    private String tipExercitiu;

    public ExercitiuFizic(String denumire, int nrCalorii, String gen, Date dataIncarcarii, String tipExercitiu) {
        this.denumire = denumire;
        this.nrCalorii = nrCalorii;
        this.gen = gen;
        this.dataIncarcarii = dataIncarcarii;
        this.tipExercitiu = tipExercitiu;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrCalorii() {
        return nrCalorii;
    }

    public void setNrCalorii(int nrCalorii) {
        this.nrCalorii = nrCalorii;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public Date getDataIncarcarii() {
        return dataIncarcarii;
    }

    public void setDataIncarcarii(Date dataIncarcarii) {
        this.dataIncarcarii = dataIncarcarii;
    }

    public String getTipExercitiu() {
        return tipExercitiu;
    }

    public void setTipExercitiu(String tipExercitiu) {
        this.tipExercitiu = tipExercitiu;
    }

    @Override
    public String toString() {
        return "ExercitiuFizic{" +
                "denumire='" + denumire + '\'' +
                ", nrCalorii=" + nrCalorii +
                ", gen='" + gen + '\'' +
                ", dataIncarcarii=" + dataIncarcarii +
                ", tipExercitiu='" + tipExercitiu + '\'' +
                '}';
    }
}
