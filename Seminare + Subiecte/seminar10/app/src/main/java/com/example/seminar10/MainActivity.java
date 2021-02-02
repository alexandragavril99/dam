package com.example.seminar10;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static CarDB carDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carDB = Room.databaseBuilder(getApplicationContext(), CarDB.class, "CarDB").allowMainThreadQueries().build();

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Car car1 = new Car("NT10ABC", 5, 2000);
                Car car2 = new Car("NT10ALE", 5, 2000);
                carDB.getCarDAO().insertCar(car2);

                Toast.makeText(getApplicationContext(),"Car added", Toast.LENGTH_SHORT).show();
            }
        });

        Button showCars = findViewById(R.id.button2);
        showCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Car> cars;
                cars = carDB.getCarDAO().getCars();
//                cars.forEach(car -> {
//                    Toast.makeText(getApplicationContext(),car.toString(),Toast.LENGTH_SHORT).show();
//                });
                for(int i=0; i<cars.size(); i++) {
                    Toast.makeText(getApplicationContext(),cars.get(i).toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });




        Button showSpecificCar = findViewById(R.id.button3);
        showSpecificCar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText et = findViewById(R.id.editTextTextPersonName);
                String etString = et.getText().toString();
                Car car;
                car = carDB.getCarDAO().getCar(etString);

                if(car == null) {
                    Toast.makeText(getApplicationContext(),"Nu exista masina cu numele acesta", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), car.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}