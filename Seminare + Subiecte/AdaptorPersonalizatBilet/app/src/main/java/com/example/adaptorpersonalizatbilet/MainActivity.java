package com.example.adaptorpersonalizatbilet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int REQUESTCODE = 201;
    Intent intent;
    static ArrayList<EchipamentSportiv> echipamentSportivArrayList = new ArrayList<>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),AddEchipament.class);
                startActivityForResult(intent,REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUESTCODE) {
            if(RESULT_OK == resultCode) {
                EchipamentSportiv echipamentSportiv = (EchipamentSportiv) data.getSerializableExtra("obiect");
                echipamentSportivArrayList.add(echipamentSportiv);

                lv = findViewById(R.id.listView);
                EchipamentAdapter adapter = new EchipamentAdapter(echipamentSportivArrayList,getApplicationContext());
                lv.setAdapter(adapter);

            }
        }
    }
}