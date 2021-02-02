package com.example.seminar8;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParsareJson extends AsyncTask<String,Void, List<Double>> {

    @Override
    protected List<Double> doInBackground(String... strings) {


        List<Double> lista = new ArrayList<>();
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
            InputStream stream  = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String linie = "";
            StringBuilder builder = new StringBuilder(); //fol stringbuilder ca sa nu cream f multe obiecte de tip string

            while((linie = reader.readLine()) != null) {
                builder.append(linie);
            }
            String textFull = builder.toString();
            JSONObject object = new JSONObject(textFull);
            JSONArray colectie = object.getJSONArray("DailyForecasts");
            JSONObject primulObiect = colectie.getJSONObject(0);
            JSONObject temperatura = primulObiect.getJSONObject("Temperature");

            JSONObject minimum = temperatura.getJSONObject("Minimum");
            JSONObject maximum = temperatura.getJSONObject("Maximum");

            double minim = minimum.getDouble("Value");
            double maxim = maximum.getDouble("Value");

            lista.add(minim);
            lista.add(maxim);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
