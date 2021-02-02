package com.example.seminar6;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.ParameterizedType;

public class ClipVideo implements Parcelable {
    private String titlu;
    private int durata;
    private float spatiuOcupat;
    private String gen;

    public ClipVideo(String titlu, int durata, float spatiuOcupat) {
        this.titlu = titlu;
        this.durata = durata;
        this.spatiuOcupat = spatiuOcupat;
    }
    public ClipVideo(String titlu, int durata, float spatiuOcupat, String gen) {
        this.titlu = titlu;
        this.durata = durata;
        this.spatiuOcupat = spatiuOcupat;
        this.gen = gen;
    }

    public ClipVideo() {
        this.titlu = "titlu";
        this.durata = 120;
        this.spatiuOcupat = 300;
        this.gen = "necunoscut";
    }

    protected ClipVideo(Parcel in) {
        titlu = in.readString();
        durata = in.readInt();
        spatiuOcupat = in.readFloat();
        gen = in.readString();
    }

    public static final Creator<ClipVideo> CREATOR = new Creator<ClipVideo>() {
        @Override
        public ClipVideo createFromParcel(Parcel in) {
            return new ClipVideo(in);
        }

        @Override
        public ClipVideo[] newArray(int size) {
            return new ClipVideo[size];
        }
    };

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public float getSpatiuOcupat() {
        return spatiuOcupat;
    }


    public void setSpatiuOcupat(float spatiuOcupat) {
        if(spatiuOcupat>0) {
            this.spatiuOcupat = spatiuOcupat;
        }
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "ClipVideo{" +
                "titlu='" + titlu + '\'' +
                ", durata=" + durata +
                ", spatiuOcupat=" + spatiuOcupat + ", gen=" +gen+
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titlu);
        dest.writeInt(durata);
        dest.writeFloat(spatiuOcupat);
        dest.writeString(gen);
    }
}
