package com.example.a1081_gavrilanaalexandra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

public class AddExercitiu extends AppCompatActivity {

    EditText denumire;
    EditText nrCalorii;
    CheckBox cbGen;
    Spinner tipSpinner;
    DatePicker dpData;
    Button addBtn;
    DateConverter dc = new DateConverter();
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercitiu);

        denumire = findViewById(R.id.etDenumire);
        nrCalorii = findViewById(R.id.etNrCalorii);
        cbGen = findViewById(R.id.cbGen);
        tipSpinner = findViewById(R.id.tipSpinner);
        dpData = findViewById(R.id.dpData);
        addBtn = findViewById(R.id.addBtn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.options, android.R.layout.simple_spinner_dropdown_item);
        tipSpinner.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {

                    String gen = "Masculin";
                    if(cbGen.isChecked()) {
                        gen = "Feminin";
                    }

                    String tip = "Ambele";
                    if(tipSpinner.getSelectedItem().toString().equals("Brate"))
                        tip = "Brate";
                    else if(tipSpinner.getSelectedItem().toString().equals("Picioare"))
                        tip = "Picioare";

                    Date data = dc.getDateFromDatePicker(dpData);

                    ExercitiuFizic exercitiuFizic = new ExercitiuFizic(denumire.getText().toString(),
                            Integer.parseInt(nrCalorii.getText().toString()),gen,data,tip);

                   // Toast.makeText(AddExercitiu.this, "AICI", Toast.LENGTH_SHORT).show();
                   // Toast.makeText(getApplicationContext(),exercitiuFizic.toString(),Toast.LENGTH_SHORT).show();
                    intent.putExtra("obiect",exercitiuFizic);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    public boolean validate() {
        if(denumire.getText().toString().isEmpty() || denumire.getText().toString().trim().length() < 3) {
            Toast.makeText(this, "Denumire necorespunzatoare", Toast.LENGTH_SHORT).show();
            return false;
        } else if(nrCalorii.getText().toString().isEmpty()){
            Toast.makeText(this, "Numar calorii insuficiente", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}