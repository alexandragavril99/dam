package com.example.adaptorpersonalizatbilet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Date;

public class AddEchipament extends AppCompatActivity {

    EditText etDenumire;
    EditText etNrPiese;
    DatePicker datePicker;
    Switch switchGen;
    RadioGroup radio;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_echipament);

        btn = findViewById(R.id.adaugaBtn);
        etDenumire = findViewById(R.id.etDenumire);
        etNrPiese = findViewById(R.id.etNumarPiese);
        datePicker = findViewById(R.id.datePicker);
        switchGen = findViewById(R.id.genSwitch);
        radio = findViewById(R.id.radio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()) {
                    Tip tip = Tip.vara;
                    if(radio.getCheckedRadioButtonId() == R.id.iarna) {
                        tip = Tip.iarna;
                    }
                    Date date =  new Date(datePicker.getYear() - 1900, datePicker.getMonth(), datePicker.getDayOfMonth());
                    String gen = "masculin";
                    if(switchGen.isChecked()) {
                        gen = "feminin";
                    }
                    EchipamentSportiv echipamentSportiv = new EchipamentSportiv(etDenumire.getText().toString(),
                            date,gen, Integer.parseInt(etNrPiese.getText().toString()),tip);

                    Intent intent = new Intent();
                    intent.putExtra("obiect",echipamentSportiv);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    public boolean validateInput() {
        if(etDenumire.getText().toString().isEmpty() || etNrPiese.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campuri necompletate", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}