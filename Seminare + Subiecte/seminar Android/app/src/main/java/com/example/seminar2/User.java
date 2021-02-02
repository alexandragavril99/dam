package com.example.seminar2;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable
{
    private String nume;
    private String username;
    private String email;
    private String parola;
    private int id;

    public User(String nume, String username, String email, String parola, int id) {
        this.nume = nume;
        this.username = username;
        this.email = email;
        this.parola = parola;
        this.id = id;
    }

    protected User(Parcel in) {
        nume = in.readString();
        username = in.readString();
        email = in.readString();
        parola = in.readString();
        id = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(parola);
        dest.writeInt(id);
    }
}
