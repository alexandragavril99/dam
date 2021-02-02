package com.example.seminar2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bundle bundle = getIntent().getExtras();
        String nume = bundle.getString("nume");
        String parola = bundle.getString("parola");
        int id = bundle.getInt("id");

        EditText etId = findViewById(R.id.idUser);
        EditText etNume = findViewById(R.id.idNume);
        EditText etParola = findViewById(R.id.idPassword);

        etId.setText("" +id);
        etNume.setText(nume);
        etParola.setText(parola);
    }

    public void salvare(View view) {
        Intent intent = new Intent();
        intent.putExtra("text","Text din a doua activitate");
        intent.putExtra("numar",102);
        User user = new User("Popescu","Popescu","Popescu@gmail.com", "parola",1);
        intent.putExtra("user",user);
        setResult(RESULT_OK, intent);
        finish();

    }
    public void anulare(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}