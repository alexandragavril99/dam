package com.example.dam_bilet4_sesizare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class AdaugaSesizareActivity extends AppCompatActivity {

    EditText etTitlu;
    EditText etDescriere;
    EditText etDataInregistrarii;
    Spinner spinner;
    private DateConverter dateConverter = new DateConverter();
    private Intent intent;
    private static SesizareDAO sesizariDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_sesizare);
        intent = getIntent();
        etTitlu = findViewById(R.id.adaugaSesizare);
        etDescriere = findViewById(R.id.descriere);
        etDataInregistrarii = findViewById(R.id.data);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.options, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        populateValues();

        Button adaugaBtn = findViewById(R.id.btnAdauga);
        adaugaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    String titlu = etTitlu.getText().toString();
                    String descriere = etDescriere.getText().toString();
                    Date date = dateConverter.fromString(etDataInregistrarii.getText().toString());
                    Tip tip = Tip.drumuri;
                    if(spinner.getSelectedItem().toString().equals("Personal"))
                        tip = Tip.personal;
                    else if(spinner.getSelectedItem().toString().equals("Iluminat"))
                        tip = Tip.iluminat;
                    else if(spinner.getSelectedItem().toString().equals("Gaze"))
                        tip = Tip.gaze;
                    else if(spinner.getSelectedItem().toString().equals("Apa"))
                        tip = Tip.apa;
                    else if(spinner.getSelectedItem().toString().equals("Canalizare"))
                        tip = Tip.canalizare;

                    Sesizare sesizare = (Sesizare)intent.getSerializableExtra("obiectLista");
                    if(sesizare != null) {
                            sesizare.setTitlu(titlu);
                            sesizare.setDescriere(descriere);
                            sesizare.setDataInregistrarii(date);
                            sesizare.setTip(tip);

                            intent.putExtra("obiectModificat",sesizare);
                            setResult(RESULT_OK,intent);
                            finish();
                    } else {
                        Sesizare sesizareCurenta = new Sesizare(titlu, descriere,date,tip);
                        sesizariDAO = Room.databaseBuilder(getApplicationContext(), SesizareDB.class, "SesizareDB").fallbackToDestructiveMigration()
                                .build().getSesizariDAO();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                sesizariDAO.insertSesizare(sesizareCurenta);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.v("Obiect introdus: ", sesizareCurenta.toString());
                                    }
                                });
                            }
                        }).start();
                        intent.putExtra("obiectCreat",sesizareCurenta);
                        setResult(RESULT_OK,intent);
                        finish();
                    }


                }
            }
        });
    }

    private void populateValues(){
        Sesizare sesizare = (Sesizare)intent.getSerializableExtra("obiectLista");
        //int index = (int)intent.getSerializableExtra(ListActivity.INDEX_KEY);
        if(sesizare != null){
            etTitlu.setText(sesizare.getTitlu());
            etDataInregistrarii.setText(dateConverter.toString(sesizare.getDataInregistrarii()));
            etDescriere.setText(sesizare.getDescriere());
            spinner.setSelection(sesizare.getTip().value);
            Button adaugaBtn = findViewById(R.id.btnAdauga);
            adaugaBtn.setText("Editeaza");
        }
    }

    public boolean validate() {

        if(etTitlu.getText().toString().isEmpty() || etTitlu.getText().toString().trim().length() < 3){
            Toast.makeText(this, "Titlu necorespunzator", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etDescriere.getText().toString().isEmpty() || etDescriere.getText().toString().trim().length() < 10){
            Toast.makeText(this, "Descriere insuficienta", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(etDataInregistrarii.getText().toString().isEmpty()){
            Toast.makeText(this, "Data invalida", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}