package com.example.seminar13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void deschidereHart(View view) {
        Intent it = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(it);
    }
}