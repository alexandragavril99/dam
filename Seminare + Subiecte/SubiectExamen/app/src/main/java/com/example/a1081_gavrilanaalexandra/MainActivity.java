package com.example.a1081_gavrilanaalexandra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExercitiuFizic> exercitiuFizicArrayList = new ArrayList<>();
    Button btn;
    Button okBtn;
    EditText etVal;
    Button deleteBtn;
    private int REQUEST_CODE = 201;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddExercitiu.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });


        okBtn = findViewById(R.id.okBtn);
        final String[] valoare = new String[1];
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etVal = findViewById(R.id.editTextTextPersonName);
                valoare[0] = etVal.getText().toString();
                if(valoare[0].isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nu ai introdus nicio valoare", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean w = false;
                    for(ExercitiuFizic exercitiuFizic : exercitiuFizicArrayList) {
                        if(exercitiuFizic.getDenumire().equals(valoare[0])) {
                            w = true;
                            Toast.makeText(MainActivity.this, "Obiectul este " + exercitiuFizic.toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    if(!w) {
                        Toast.makeText(MainActivity.this, "Nu exista aceasta denumire", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        deleteBtn = findViewById(R.id.stergere);

        ArrayList<ExercitiuFizic> arrayList = new ArrayList<>();
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valoare[0] != null) {

                    etVal = findViewById(R.id.editTextTextPersonName);
                    etVal.setText("");
                    for(ExercitiuFizic exercitiuFizic : exercitiuFizicArrayList) {
                        if(!exercitiuFizic.getDenumire().equals(valoare[0])) {
                           arrayList.add(exercitiuFizic);
                        }
                    }

                    exercitiuFizicArrayList = arrayList;
                    Toast.makeText(MainActivity.this, exercitiuFizicArrayList.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                ExercitiuFizic exercitiuFizic = (ExercitiuFizic) data.getSerializableExtra("obiect");
                exercitiuFizicArrayList.add(exercitiuFizic);
                Toast.makeText(this, exercitiuFizicArrayList.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}