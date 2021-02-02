package com.example.dam_bilet4_sesizare;

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
import java.util.Date;

public class JSONParser extends AsyncTask<String,Void, ArrayList<Sesizare>> {
    DateConverter dateConverter = new DateConverter();
    ArrayList<Sesizare> sesizari = new ArrayList<>();
    @Override
    protected ArrayList<Sesizare> doInBackground(String... strings) {

        URL url = null;
        try {
            url = new URL(strings[0]);
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
            JSONArray colectie = object.getJSONArray("sesizari");
            for(int i=0;  i<colectie.length(); i++) {
                JSONObject obj = colectie.getJSONObject(i);
                String titlu = obj.getString("titlu");
                String desc = obj.getString("descriere");
                Date date = dateConverter.fromString(obj.getString("dataInregistrarii"));
                Tip tip = dateConverter.EnumfromString(obj.getString("tip"));
                sesizari.add(new Sesizare(titlu,desc,date,tip));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sesizari;
    }
}
