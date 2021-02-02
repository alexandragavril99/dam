package com.example.seminar9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private float value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCitire = findViewById(R.id.button);
        btnCitire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fileInputStream = openFileInput("fisier.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder sb = new StringBuilder();

                    String linie="";
                    while((linie = bufferedReader.readLine()) != null) {
                        sb.append(linie);
                    }
                    Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
                    fileInputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences",MODE_PRIVATE);
        value = sharedPreferences.getFloat("valoarea_fontului",10);
        String text = sharedPreferences.getString("text","default");
        Toast.makeText(this,"" + value,Toast.LENGTH_SHORT).show();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        setareFont();
    }

    public void salvareInFisier(View view) {
        //String idEditText = ((EditText)findViewById(R.id.editText)).getText().toString();
        EditText editText = findViewById(R.id.editText);
        String valueEditText = editText.getText().toString();

        try {
            FileOutputStream file = openFileOutput("fisier.txt", MODE_PRIVATE);
            file.write(valueEditText.getBytes());
            file.close();
            Toast.makeText(this, "AM SCRIS", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setareFont() {
        EditText editText = findViewById(R.id.editText);
        editText.setTextSize(value);

        Button btn1 = findViewById(R.id.button2);
        Button btn = findViewById(R.id.button);
        btn1.setTextSize(value);
        btn.setTextSize(value);
    }


    public void crestereDimensiune(View view) {
        value++;
        setareFont();
    }

    public void scadereDimensiune(View view) {
        value--;
        setareFont();
    }

    public void salvareSharedPreferences(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putFloat("valoarea_fontului",value);
        editor.putString("text","dimensiune font");


        editor.commit(); //sau apply()

    }
}