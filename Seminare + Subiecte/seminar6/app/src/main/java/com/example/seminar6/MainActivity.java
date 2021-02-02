package com.example.seminar6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ClipVideo> clipuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void arataListaClipuri(View view) {
         clipuri = new ArrayList<>();
        clipuri.add(new ClipVideo("Seminar_5",100, 200, "stiintific"));
        ClipVideo clip = new ClipVideo("Curs",90,180, "stiintific");
        clipuri.add(clip);
        clipuri.add(new ClipVideo());
        clipuri.add(new ClipVideo("Forrest Gump", 120, 500, "drama"));
        ListView listView = findViewById(R.id.listView);
        ClipAdapter adapter = new ClipAdapter(clipuri,this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClipVideo clip = clipuri.get(position);
                Intent it = new Intent(getApplicationContext(), showClipActivity.class);
                it.putExtra("clip",clip);
                startActivity(it);
            }
        });
    }
}