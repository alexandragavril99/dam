package com.example.seminar2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class seminar4Activity extends AppCompatActivity {

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