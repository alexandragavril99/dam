package com.example.roombilet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.nio.channels.AsynchronousByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private static PersonalDB personalDB;
    List<PersonalMedical> listaPersonal = new ArrayList<>();
    ListView lv;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        PersonalMedical personalMedical = (PersonalMedical) getIntent().getExtras().getSerializable("personal");

        personalDB = Room.databaseBuilder(getApplicationContext(), PersonalDB.class, "PersonalDB").allowMainThreadQueries().build();

        lv = findViewById(R.id.listView);

        ArrayAdapter<PersonalMedical> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaPersonal);
        lv.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                personalDB.getPersonalDAO().insertPersonal(personalMedical);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ListaActivity.this, "Am inserat", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<PersonalMedical> lista = (ArrayList<PersonalMedical>) personalDB.getPersonalDAO().getPersonal();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(PersonalMedical i : lista) {
                            listaPersonal.add(i);
                        }
                        ArrayAdapter adapter = (ArrayAdapter) lv.getAdapter();
                       adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();

        radioGroup = findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId() == R.id.alfabetic) {
                    Collections.sort(listaPersonal, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            PersonalMedical ob1= (PersonalMedical) o1;
                            PersonalMedical ob2= (PersonalMedical) o2;
                            return ob1.getNume().compareTo(ob2.getNume());
                        }
                    });
                    adapter.notifyDataSetChanged();
                }
                if(group.getCheckedRadioButtonId() == R.id.invAlfabetic) {
                    Collections.sort(listaPersonal, Collections.reverseOrder( new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            PersonalMedical ob1= (PersonalMedical) o1;
                            PersonalMedical ob2= (PersonalMedical) o2;
                            return ob1.getNume().compareTo(ob2.getNume());
                        }
                    }));
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
}