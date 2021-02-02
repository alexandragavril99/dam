package com.example.dam_bilet4_sesizare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaSesizariActivity extends AppCompatActivity {

    ArrayList<Sesizare> sesizareList = new ArrayList<>();
    private int REQ_CODE= 250;
    private static int poz;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sesizari);
        intent = getIntent();

        sesizareList = (ArrayList<Sesizare>) intent.getSerializableExtra(MainActivity.LISTA);
        SesizareAdapter adapter = new SesizareAdapter(getApplicationContext(),sesizareList);

        Toast.makeText(this, sesizareList.toString(), Toast.LENGTH_SHORT).show();
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                poz = position;
                Sesizare sesizare = sesizareList.get(position);
                Intent intent = new Intent(getApplicationContext(),AdaugaSesizareActivity.class);
                intent.putExtra("obiectLista",sesizare);
                startActivityForResult(intent,REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE)
        {
            if(resultCode == RESULT_OK) {
                Sesizare obiectModificat = (Sesizare) data.getSerializableExtra("obiectModificat");
                sesizareList.get(poz).setTitlu(obiectModificat.getTitlu());
                sesizareList.get(poz).setDescriere(obiectModificat.getDescriere());
                sesizareList.get(poz).setDataInregistrarii(obiectModificat.getDataInregistrarii());
                sesizareList.get(poz).setTip(obiectModificat.getTip());

                ListView lv = findViewById(R.id.listView);
                SesizareAdapter adapter = (SesizareAdapter) lv.getAdapter();
                adapter.notifyDataSetChanged();
            }
        }
    }
}