package com.example.seminar8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.TextView);


        ParsareJson parser = new ParsareJson() {
            @Override
            protected void onPostExecute(List<Double> doubles) {
                TextView textView = findViewById(R.id.TextView);
                StringBuilder builder = new StringBuilder();
                builder.append("Minima: ").append(doubles.get(0))
                        .append(", Maxima: ").append(doubles.get(1));
                textView.setText(builder.toString());
                Toast.makeText(MainActivity.this, "GATA", Toast.LENGTH_SHORT).show();
            }
        };

        parser.execute("http://dataservice.accuweather.com/forecasts/v1/daily/1day/287430?apikey=xGxplSd4JGEpYNvVGqzBrZ6B7HlRckYd&metric=true");

    }

    public void send(View view) {
        EditText et = findViewById(R.id.editTextTextPersonName);
        String etString = et.getText().toString();
        ParsareJson2 parser = new ParsareJson2() {
            @Override
            protected void onPostExecute(String s) {
                afisare(s);
            }
        };
        parser.execute("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=xGxplSd4JGEpYNvVGqzBrZ6B7HlRckYd&q=" + etString);
    }

    public void afisare(String s){
        ParsareJson parser = new ParsareJson(){
            @Override
            protected void onPostExecute(List<Double> doubles) {
                TextView textView = findViewById(R.id.tv2);
                StringBuilder builder = new StringBuilder();
                builder.append("Minima: ").append(doubles.get(0))
                        .append(", Maxima: ").append(doubles.get(1));
                textView.setText(builder.toString());
            }
        };
        parser.execute("http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + s +"?apikey=xGxplSd4JGEpYNvVGqzBrZ6B7HlRckYd&metric=true");
    }
}