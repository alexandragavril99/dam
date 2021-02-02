package com.example.seminar11;

public class Student {
    private String nrMatricol;
    private String nume;
    private int varsta;
    private float medie;

    public Student(String nrMatricol, String nume, int varsta, float medie) {
        this.nrMatricol = nrMatricol;
        this.nume = nume;
        this.varsta = varsta;
        this.medie = medie;
    }

    public Student() {
        this.nrMatricol = "102";
        this.nume = "Popescu";
        this.varsta = 21;
        this.medie = 9.21f;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
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

    public float getMedie() {
        return medie;
    }

    public void setMedie(float medie) {
        this.medie = medie;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nrMatricol='" + nrMatricol + '\'' +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", medie=" + medie +
                '}';
    }
}
