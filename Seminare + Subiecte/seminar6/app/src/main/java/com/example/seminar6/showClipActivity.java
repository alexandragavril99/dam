package com.example.seminar6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class showClipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_clip);
        ClipVideo clip = getIntent().getExtras().getParcelable("clip");
        Toast.makeText(this,clip.toString(),Toast.LENGTH_SHORT).show();

//        final List<String> lista = new ArrayList();
//    lista.add("optiune 1");
//    lista.add("optiune 2");
//    lista.add("optiune 3");
//    lista.add("optiune 4");

    //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
    Spinner spinner = findViewById(R.id.spinner);
    //spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selectedtext = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),selectedtext,Toast.LENGTH_SHORT).show();
            WebView webView = findViewById(R.id.webView);
            webView.loadUrl("https://" + selectedtext);
            webView.setWebViewClient(new WebViewClient());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
    }
}