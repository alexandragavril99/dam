package com.example.seminar3_dam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Seminar4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar4);
        Bundle bundle = getIntent().getExtras();
        String nume = bundle.getString("nume");
        EditText etNume = findViewById(R.id.idNume);
        etNume.setText(nume);
    }
}