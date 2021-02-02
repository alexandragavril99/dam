package com.example.roombilet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText etNume;
    EditText etEmail;
    SeekBar sbVarsta;
    TimePicker tpOraInscriere;
    CheckBox cbPozitie;
    TextView tvVarsta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etNume = findViewById(R.id.etNume);
        etEmail = findViewById(R.id.etEmail);
        sbVarsta = findViewById(R.id.sbVarsta);
        tvVarsta = findViewById(R.id.tvVarsta);
        sbVarsta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvVarsta.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tpOraInscriere = findViewById(R.id.TimePicker);
        cbPozitie = findViewById(R.id.checkbox);
        Button btnAdd = findViewById(R.id.btnAdauga);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()) {
                    String pozitie = "asistent";
                    if(cbPozitie.isChecked()) {
                        pozitie = "doctor";
                    }
                    PersonalMedical personalMedical = new PersonalMedical(etNume.getText().toString(), Integer.parseInt(String.valueOf(sbVarsta.getProgress())),
                            etEmail.getText().toString(), tpOraInscriere.getCurrentHour()+":"+ tpOraInscriere.getCurrentMinute(),pozitie);

                    Intent intent = new Intent(getApplicationContext(),ListaActivity.class);
                    intent.putExtra("personal",personalMedical);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean validateInput() {
        if(etNume.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Campuri necompletate - nume sau prenume", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}