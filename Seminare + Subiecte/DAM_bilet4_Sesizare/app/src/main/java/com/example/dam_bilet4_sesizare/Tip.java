package com.example.dam_bilet4_sesizare;

public enum Tip {
    drumuri(0),personal(1),iluminat(2),gaze(3),apa(4),canalizare(5);
    public int value;
    Tip(int value) {
        this.value = value;
    }

}
